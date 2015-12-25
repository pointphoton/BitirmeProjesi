/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

 @Stateless(name ="SessionEJB")
public class SessionFacade implements SessionFacadeLocal{

   @PersistenceContext(unitName = "BitirmeProjesiPU")
         private EntityManager em;


   @Override
    public  EntityManager getEntityManager() {
        return em;
    }
    
}
