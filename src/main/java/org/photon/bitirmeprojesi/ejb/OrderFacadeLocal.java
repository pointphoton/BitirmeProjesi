/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.photon.bitirmeprojesi.web.entity.Order;

/**
 *
 * @author Photon
 */
@Local
public interface OrderFacadeLocal {

    void create(Order order);

    void edit(Order order);

    void remove(Order order);

    Order find(Long id);

    List<Order> findAll();

    List<Order> findRange(int[] range);

    int count();
    
}
