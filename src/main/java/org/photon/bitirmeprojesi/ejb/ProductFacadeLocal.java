/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.hibernate.Criteria;
import org.photon.bitirmeprojesi.web.entity.Product;

/**
 *
 * @author Photon
 */
@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Long id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();
    
    
    
}
