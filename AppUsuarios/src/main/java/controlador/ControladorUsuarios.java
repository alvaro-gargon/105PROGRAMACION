/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import org.apache.commons.codec.digest.DigestUtils;
import dao.DaoException;
import dao.UsuarioDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TipoUsuario;
import modelo.Usuario;
import vista.VentanaUsuarios;

/**
 *
 * @author alvaro.gargon.4
 */
public class ControladorUsuarios {

    private VentanaUsuarios ventana;
    private UsuarioDao usuarioDao;
    private static final Logger LOG = Logger.getLogger(ControladorUsuarios.class.getName());

    public ControladorUsuarios(VentanaUsuarios ventana, UsuarioDao usuarioDao) {
        this.ventana = ventana;
        this.usuarioDao = usuarioDao;
    }

    public VentanaUsuarios getVentana() {
        return ventana;
    }

    public void setVentana(VentanaUsuarios ventana) {
        this.ventana = ventana;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void iniciar() {
        try {
            ventana.mostrar();
            ventana.mostrarUsuarios(usuarioDao.listar());
        } catch (DaoException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar() {
        try {
            String nombre = ventana.getNombre();
            Usuario usuario = usuarioDao.buscar(nombre);
            if (usuario != null) {
                ventana.mostrarEmail(usuario.getEmail());
                ventana.mostrarRol(usuario.getRol().toString());
            } else {
                ventana.mostrarMensaje("No se ha encontrado la cuenta");
                ventana.limpiarCampos();
            }
        } catch (DaoException ex) {
            ventana.mostrarMensaje(ex.toString());
        }
    }

    public void listar() {
        try {
            ventana.mostrarUsuarios(usuarioDao.listar());
        } catch (DaoException ex) {
            ventana.mostrarMensaje(ex.getMessage());
        }
    }

    public void crear() {
        try {
            String nombre = ventana.getNombre();
            String email = ventana.getEmail();
            String rol_apoyo = ventana.getRol();
            TipoUsuario rol;
            if ("ADMINISTRADOR".equals(rol_apoyo)) {
                rol = TipoUsuario.ADMINISTRADOR;
            } else {
                rol = TipoUsuario.REGISTRADO;
            }
            String contraseña = ventana.getPassword();
            String password = DigestUtils.sha256Hex(contraseña);
            Usuario usuario = new Usuario(nombre, password, email, rol);
            usuario.setActivo(true);
            usuario.setFechaAlta(LocalDate.now());
            usuario.setUltimoAcceso(null);
            if (usuarioDao.insertar(usuario)) {
                ventana.mostrarMensaje("Cuenta creado con exito");
            } else {
                ventana.mostrarMensaje("No se ha podido crear una cuenta");
            }
            listar();
        } catch (DaoException ex) {
            ventana.mostrarMensaje(ex.toString());
        }
    }

    public void editar() {
        String password;
        String email;
        String nombre = ventana.getEditar();
        Usuario usuario = null;
        try {
            usuario = usuarioDao.buscar(nombre);
        } catch (DaoException ex) {
            ventana.mostrarMensaje(ex.getMessage());
        }
        if (usuario != null) {
            try {
                usuario.setPassword(ventana.getPassword());
                usuario.setEmail(ventana.getEmail());
                usuarioDao.modificar(usuario);
            } catch (DaoException | IllegalArgumentException ex) {
                ventana.mostrarMensaje(ex.getMessage());
            }
        } else {
            ventana.mostrarMensaje("No existe el usuario");
        }
    }

    public void borrar() {
        try {
            if (ventana.solicitarConfiramcion()) {
                String nombre = ventana.getEditar();
                if (usuarioDao.borrar(nombre)) {
                    ventana.limpiarCampos();
                    ventana.mostrarMensaje("Usuario eliminada");
                    listar();
                } else {
                    ventana.mostrarMensaje("No se ha podido eliminar");
                }
            }
        } catch (DaoException ex) {
            ventana.mostrarMensaje(ex.getMessage());
        }
    }

    public void exportar() {
        boolean seguro = true;
        String archivo = ventana.getArchivo();
        Path path = Paths.get(archivo);
        if (Files.exists(path)) {
            seguro = ventana.solicitarConfiramcion();
        }
        if (seguro) {
            try (BufferedWriter bw = Files.newBufferedWriter(path)) {
                for (Usuario u : usuarioDao.listar()) {
                    bw.write(u.toString());
                    bw.newLine();
                }
            } catch (IOException ex) {
                ventana.mostrarMensaje(ex.toString());
            } catch (DaoException ex) {
                ventana.mostrarMensaje(ex.getMessage());
            }
        }
    }

    public void importar() {
        boolean seguro = true;
        String[] parte;
        String linea;
        String archivo = ventana.getArchivo();
        Path path = Paths.get(archivo);
        if (Files.exists(path)) {
            seguro = ventana.solicitarConfiramcion();
        }
        if (seguro) {
            try (BufferedReader br = Files.newBufferedReader(path)) {
                linea = br.readLine();
                while (linea != null) {
                    parte = linea.split(",");
                    if (parte.length != 7) {
                        LOG.warning("fommato incorrecto");
                        throw new DaoException("formato incorrecto");
                    }
                    String nombre = parte[0];
                    String password = parte[1];
                    String email = parte[2];
                    String rol_a = parte[4];
                    TipoUsuario rol = TipoUsuario.valueOf(rol_a);
                    Usuario usuario = new Usuario(nombre, password, email, rol);
                    usuario.setActivo(Boolean.valueOf(parte[3]));
                    usuario.setFechaAlta(LocalDate.parse(parte[5]));
                    if (!parte[6].equals("null")) {
                        usuario.setUltimoAcceso(LocalDateTime.parse(parte[6]));
                    } else {
                        usuario.setUltimoAcceso(null);
                    }

                    usuarioDao.insertar(usuario);
                    linea = br.readLine();
                }
                listar();
            } catch (DaoException | IOException | ArrayIndexOutOfBoundsException ex) {
                ventana.mostrarMensaje(ex.getMessage());
            }
        }
    }

}
