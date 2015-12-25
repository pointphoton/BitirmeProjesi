/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.ejb;


import java.util.List;
import javax.ejb.Local;
import org.photon.bitirmeprojesi.web.entity.Employee;

/**
 *
 * @author Photon
 */
@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee find(Long id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
}
