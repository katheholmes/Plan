/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.backend.model;

import com.plan.backend.entities.Usuario;
import com.plan.backend.entities.Vehiculo;
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
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "PlanFase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
    
    @Override
   public List<Vehiculo> consultarPrecio(double precio) {
        List<Vehiculo>vehiculos;
        try{
            Query query= em.createQuery("SELECT v FROM Vehiculo v WHERE v.precio >:precio");
            query.setParameter("precio",precio);
            
            vehiculos= query.getResultList();
            
        }catch(Exception e){
            throw e;
        }
        return vehiculos;
    }
}
