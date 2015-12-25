/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.photon.bitirmeprojesi.web.entity.Branch;

/**
 *
 * @author Photon
 */
@Stateless(name = "BranchEJB")
public class BranchFacade extends AbstractFacade<Branch> implements BranchFacadeLocal {
  @PersistenceContext(unitName = "BitirmeProjesiPU")
        private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BranchFacade() {
        super(Branch.class);
    }
    
}
