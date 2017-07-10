/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import mk.gov.ia.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author internet
 */
@Repository
public class EmployeeRepository extends GenericRepository<Employee> {

    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeRepository() {
        super(Employee.class);
    }
    
}
