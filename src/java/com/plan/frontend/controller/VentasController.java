/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.frontend.controller;

import com.plan.backend.entities.Vehiculo;
import com.plan.backend.entities.Venta;
import com.plan.backend.model.VehiculoFacadeLocal;
import com.plan.backend.model.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kathe
 */
@Named(value = "ventasController")
@SessionScoped
public class VentasController implements Serializable {
 @EJB
 private VehiculoFacadeLocal vehiculoLocal;
 private VentaFacadeLocal ventasLocal;
 private List<Vehiculo>vehiculos;
 @EJB
 private Venta venta;
 private Vehiculo vehiculo;
 
 @PostConstruct
 public void init(){
     venta= new Venta();
     vehiculo=new Vehiculo();
     
 }
    
    public VentasController() {
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public String create(){
         String redireccion="Registrar";
         try{
             ventasLocal.create(venta);
             redireccion = "Venta?faces-redirect=true";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","se logro registrar"));
         }catch(Exception e){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","no se logro registrar"));
         }
         return redireccion;
  
    }
}
