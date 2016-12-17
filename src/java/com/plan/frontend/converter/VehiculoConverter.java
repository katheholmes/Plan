/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.frontend.converter;

import com.plan.backend.entities.Vehiculo;
import com.plan.backend.model.VehiculoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="VehiculoConverter")
@ViewScoped
public class VehiculoConverter implements Converter{
     @EJB
    private VehiculoFacadeLocal VehiculoFacadeLocal;

    public VehiculoConverter() {
    }
            
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Vehiculo> vehiculos = VehiculoFacadeLocal.findAll();
        for (Vehiculo objeto : vehiculos){
            if(objeto.getCodigo()== Integer.parseInt(value)){
             return  objeto;  
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            return ((Vehiculo) value).getCodigo().toString();
        }else{
            return null;
        }
    }
}
