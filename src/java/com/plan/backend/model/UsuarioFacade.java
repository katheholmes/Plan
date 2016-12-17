/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.backend.model;

import com.plan.backend.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kathe
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "PlanFase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario iniciarSesion(Usuario u) {
        Usuario usuario=null;
        try{
            Query query= em.createQuery("SELECT u FROM Usuario u WHERE u.cedula=?1 AND u.clave=?2");
            query.setParameter(1,u.getCedula());
            query.setParameter(2,u.getClave());
            List<Usuario>usuarios= query.getResultList();
            if(!usuarios.isEmpty()){
                usuario=usuarios.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
   @Override
   public boolean verificarTipo(Usuario usuario){
       boolean bandera;
       if(usuario.isTipo()){
           return true;
       }
       return false;
   }
    
}
