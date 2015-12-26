/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.photon.bitirmeprojesi.web.entity.User;
import org.primefaces.component.inputtext.InputText;

@Stateless(name = "UserEJB")
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "BitirmeProjesiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public boolean checkAvailable(String userName) {
                if (userName == null) {
            return false;
        }
        Query query = em.createQuery("select count(*) from user u where u.userName = :userName").setParameter("userName", userName);

        Long count = (Long) query.getSingleResult();
        return count < 1;
       
    }

}
