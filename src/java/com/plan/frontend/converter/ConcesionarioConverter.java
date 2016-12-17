/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.frontend.converter;

import com.plan.backend.entities.Concesionario;
import com.plan.backend.model.ConcesionarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="ConcesionarioConverter")
@ViewScoped
public class ConcesionarioConverter implements Converter {
    @EJB
    private ConcesionarioFacadeLocal concesionarioFacadeLocal;

    public ConcesionarioConverter() {
    }
            
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Concesionario> concesionarios = concesionarioFacadeLocal.findAll();
        for (Concesionario objeto : concesionarios){
            if(objeto.getCodigo()== Integer.parseInt(value)){
             return  objeto;  
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            return ((Concesionario) value).getCodigo().toString();
        }else{
            return null;
        }
    }

}
