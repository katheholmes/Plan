/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.frontend.controller;

import com.plan.backend.entities.Vehiculo;
import com.plan.backend.model.VehiculoFacadeLocal;
import com.plan.backend.model.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Kathe
 */
@Named(value = "consultaController")
@SessionScoped
public class consultaController implements Serializable {

    @EJB
    private VentaFacadeLocal ventaLocal;
    @EJB
    private VehiculoFacadeLocal vehiculoLocal;
    
    public consultaController() {
    }

    public consultaController(VentaFacadeLocal ventaLocal, VehiculoFacadeLocal vehiculoLocal) {
        this.ventaLocal = ventaLocal;
        this.vehiculoLocal = vehiculoLocal;
    }
    
    public String verVehiculoMasBarato() {
        List<Vehiculo> vehiculos = vehiculoLocal.findAll();
        Vehiculo vehiculoBarato = vehiculos.get(0);
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPrecio() < vehiculoBarato.getPrecio()) {
                vehiculoBarato = vehiculos.get(i);
            }
        }
        return "\nMarca:" + vehiculoBarato.getMarca()
                + "\n\nPrecio: " + vehiculoBarato.getPrecio();
    }
    
    public String verModeloMasReciente() {
        List<Vehiculo> vehiculos = vehiculoLocal.findAll();
        Vehiculo vehiculo = vehiculos.get(0);
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getModelo() > vehiculo.getModelo()) {
                vehiculo = vehiculos.get(i);

            }
        }
        return "\nMarca: " + vehiculo.getMarca()
                + "\nModelo: " + vehiculo.getModelo();
    }
}
