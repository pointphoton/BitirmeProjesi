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
import org.photon.bitirmeprojesi.ejb.AddressFacadeLocal;
import org.photon.bitirmeprojesi.ejb.CustomerFacadeLocal;
import org.photon.bitirmeprojesi.ejb.UserFacadeLocal;
import org.photon.bitirmeprojesi.web.entity.Address;
import org.photon.bitirmeprojesi.web.entity.Customer;
import org.photon.bitirmeprojesi.web.entity.User;
import org.photon.bitirmeprojesi.web.entity.util.Role;

@Named("userCont")
@SessionScoped
public class UserController implements Serializable{

       @EJB(beanName = "CustomerEJB")
    private CustomerFacadeLocal customerEJB;
      @EJB(beanName = "UserEJB")
    private UserFacadeLocal userEJB;
     @EJB(beanName = "AddressEJB")
      private AddressFacadeLocal addressEJB;
      
     private Address address1 ;
      private Address address2 ;
    private Customer custo ; 
    
    private User registeredUser ; 
    private User user;

    @PostConstruct
    public void init() {
        user = new User();
        registeredUser=new User();
            custo = new Customer();
        address1 = new Address();
          address2 = new Address();
    }
    


    
    public String createAdminLogin(){
        
   user.setRole(Role.ADMIN.getValue());
    userEJB.create(user);  
    return "index?faces-redirect=true";
    }
    
    public String confirmSignUp() {
        try {
            user.setRole(Role.USER.getValue());
          userEJB.create(user); 
            System.out.println("saved user id : "+user.getUserId());
       registeredUser =     userEJB.find(user.getUserId());
       custo.setName(registeredUser.getName());
       custo.setUserName(registeredUser.getUserName());
       custo.setEmail(registeredUser.getEmail());
       custo.setPassword(registeredUser.getPassword());
        } catch (Exception e) {
        //
        }
        return "customerpage";
    }
    
    public void updateCustInfo(){}
    
    public void  confirmSignIn(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }

    public Customer getCusto() {
        return custo;
    }

    public void setCusto(Customer custo) {
        this.custo = custo;
    }
    
    

}


    /*
    public boolean checkAvailable(AjaxBehaviorEvent event) {
        InputText inputText = (InputText) event.getSource();
        String value = (String) inputText.getValue();
        System.out.println("value string "+value);
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
    */
