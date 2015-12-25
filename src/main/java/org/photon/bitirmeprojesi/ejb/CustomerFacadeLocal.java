/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.photon.bitirmeprojesi.web.entity.Customer;

/**
 *
 * @author Photon
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Long id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
}
