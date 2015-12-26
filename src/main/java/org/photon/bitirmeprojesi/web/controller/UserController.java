/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.photon.bitirmeprojesi.ejb.UserFacadeLocal;
import org.photon.bitirmeprojesi.web.entity.User;
import org.primefaces.component.inputtext.InputText;

@Named("userCont")
@SessionScoped
public class UserController implements Serializable{

    @EJB(beanName = "UserEJB")
    private UserFacadeLocal userEJB;

    private User user;

    @PostConstruct
    public void init() {
        user = new User();
    }

    public boolean checkAvailable(AjaxBehaviorEvent event) {
        InputText inputText = (InputText) event.getSource();
        String value = (String) inputText.getValue();
        boolean available = userEJB.checkAvailable(value);
        if (!available) {
            String errorMessage = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "userExistsMsg").getString("userExistsMsg");
            FacesMessage message = new FacesMessage(null, errorMessage, errorMessage);
            //    FacesMessage message = constructErrorMessage(null, String.format(FacesContext.getCurrentInstance().getApplication().getMessageBundle().g("userExistsMsg"), value));
            FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), message);
        } else {
          //  FacesMessage message = constructInfoMessage(null, String.format(getMessageBundle().getString("userAvailableMsg"), value));
            //    FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), message);
            String errorMessage = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "userAvailableMsg").getString("userAvailableMsg");
            FacesMessage message = new FacesMessage(null, errorMessage, errorMessage);
            FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), message);
        }

        return available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
