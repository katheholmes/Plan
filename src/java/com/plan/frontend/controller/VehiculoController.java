/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.frontend.controller;

import com.plan.backend.entities.Concesionario;
import com.plan.backend.entities.Vehiculo;
import com.plan.backend.model.ConcesionarioFacadeLocal;
import com.plan.backend.model.VehiculoFacadeLocal;
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
@Named(value = "vehiculoController")
@SessionScoped
public class VehiculoController implements Serializable {

    @EJB
    private VehiculoFacadeLocal vehiculoLocal;
    private Vehiculo vehiculo;
    @EJB
    private ConcesionarioFacadeLocal concesionarioLocal;
    private Concesionario concesionario;
    private List<Concesionario>concesionarios;
    
    @PostConstruct
    public void init(){
        vehiculo= new Vehiculo();
         concesionarios= concesionarioLocal.findAll();
    }
    public VehiculoController() {
    }
    
    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public List<Concesionario> getConcesionarios() {
       
        return concesionarios;
    }

    public void setConcesionarios(List<Concesionario> concesionarios) {
        this.concesionarios = concesionarios;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public List<Vehiculo> listarVehiculos(){
     return vehiculoLocal.findAll();
   
    }
    public String create(){
         String redireccion="registrarVehiculo";
         try{
             vehiculoLocal.create(vehiculo);
             redireccion = "Vehiculo?faces-redirect=true";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se logro registrar el vehiculo"));
         }catch(Exception e){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","No se logro registrar el vehiculo"));
         }
         return redireccion;
  
    }

   
    
}
