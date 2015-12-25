/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.controller;


import java.io.Serializable;
import javax.ejb.EJB;
import org.photon.bitirmeprojesi.ejb.BranchFacadeLocal;

/**
 *
 * @author Photon
 */
public class BranchController implements Serializable{
    
    @EJB(name = "BranchEJB")
   private BranchFacadeLocal branchEJB;
    
}
