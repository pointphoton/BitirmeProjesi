/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.photon.bitirmeprojesi.web.entity.ProductHistory;

/**
 *
 * @author Photon
 */
@Local
public interface ProductHistoryFacadeLocal {

    void create(ProductHistory productHistory);

    void edit(ProductHistory productHistory);

    void remove(ProductHistory productHistory);

    ProductHistory find(Long id);

    List<ProductHistory> findAll();

    List<ProductHistory> findRange(int[] range);

    int count();
    
}
