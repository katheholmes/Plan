/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.frontend.controller;

import com.plan.backend.entities.Usuario;
import com.plan.backend.model.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kathe
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioLocal;
    private Usuario usuario;
    
   
    @PostConstruct
    public void init(){
        usuario=new Usuario();
    }
           
    public UsuarioController() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
       
     
    public  String  iniciarSesion(){
        Usuario usuarioValidado;
        String redireccion="index";
        try{
            usuarioValidado=usuarioLocal.iniciarSesion(usuario);
            if(usuarioValidado!=null){
                 HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
               sesion.setAttribute("Usuario", usuarioValidado);
                return redireccion="inicio?faces-redirect=true";
            }
        }catch(Exception e ){
            //
        }
        return redireccion;
    }
    
    public String create(){
         String redireccion="registrar";
         try{
             usuarioLocal.create(usuario);
             redireccion = "index?faces-redirect=true";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","se logro registrar"));
         }catch(Exception e){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","no se logro registrar"));
         }
         return redireccion;
  
    }
    public boolean verificarTipo(){
       
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
         Usuario u = (Usuario) sesion.getAttribute("Usuario");
       return this.usuarioLocal.verificarTipo(u);
        
    }
}
