/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface SessionFacadeLocal {
    
    EntityManager getEntityManager();
    
}
