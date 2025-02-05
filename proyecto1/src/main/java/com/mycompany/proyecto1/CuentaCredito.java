package com.mycompany.proyecto1;


import com.mycompany.proyecto1.Cuenta;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alvaro.gargon.4
 */
public class CuentaCredito extends Cuenta {
    private float limiteCredito;



    public CuentaCredito(String codigo, String titular, float saldo,float limiteCredito) {
        super(codigo, titular, saldo);
        this.limiteCredito=limiteCredito;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void reintegrar(float cantidad) {
        float nuevoSaldo=getSaldo()-cantidad;
        if(nuevoSaldo>=-limiteCredito){
            setSaldo(nuevoSaldo);
            getMovimientos().add(new Movimiento(LocalDate.now(),'R',-cantidad,getSaldo()));
        }
    }

    @Override
    public String toString() {
        return super.toString()+","+limiteCredito;
    }
    
    
}
