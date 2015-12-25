/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.photon.bitirmeprojesi.web.entity.Bucket;

/**
 *
 * @author Photon
 */
@Local
public interface BucketFacadeLocal {

    void create(Bucket bucket);

    void edit(Bucket bucket);

    void remove(Bucket bucket);

    Bucket find(Long id);

    List<Bucket> findAll();

    List<Bucket> findRange(int[] range);

    int count();
    
}
