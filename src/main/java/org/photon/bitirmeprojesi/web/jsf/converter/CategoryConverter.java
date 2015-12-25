/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.jsf.converter;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.photon.bitirmeprojesi.ejb.CategoryFacadeLocal;
import org.photon.bitirmeprojesi.web.entity.Category;

@ManagedBean
@RequestScoped
public class CategoryConverter implements Converter {
    
  @EJB(beanName = "CategoryEJB")
   private CategoryFacadeLocal categoryEJB;
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    
         
        System.out.println("converter "+value);
        if (value == null||value.isEmpty()) {
            return null;
        }
     
        try {
          
            return categoryEJB.find(Long.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", value)), e);
        }
    }
    

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
     if (!(modelValue instanceof Category)) return null;
    return ((Category) modelValue).toString();
    }
}
