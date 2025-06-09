
package es.sauces.appbanco2025.dao;

import es.sauces.appbanco2025.modelo.Movimiento;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface MovimientoDao {
    public void insertar(Movimiento movimiento,String codigoCuenta) throws DaoException;
    public List<Movimiento> listar() throws DaoException;
    public List<Movimiento> listar(String codigoCuenta) throws DaoException;
}
