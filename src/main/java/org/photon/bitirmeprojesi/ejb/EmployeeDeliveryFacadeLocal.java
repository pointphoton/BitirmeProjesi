/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.photon.bitirmeprojesi.web.entity.EmployeeDelivery;

/**
 *
 * @author Photon
 */
@Local
public interface EmployeeDeliveryFacadeLocal {

    void create(EmployeeDelivery employeeDelivery);

    void edit(EmployeeDelivery employeeDelivery);

    void remove(EmployeeDelivery employeeDelivery);

    EmployeeDelivery find(Long id);

    List<EmployeeDelivery> findAll();

    List<EmployeeDelivery> findRange(int[] range);

    int count();
    
}
