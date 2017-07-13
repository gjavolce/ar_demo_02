/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.service;

import java.util.List;
import mk.gov.ia.model.Employee;
import mk.gov.ia.model.Role;
import mk.gov.ia.repository.EmployeeRepository;
import mk.gov.ia.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author expert
 */
@Service("organizationService")
@Transactional(readOnly = false)
public class OrganizationService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();

    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void getParent(Role x) {
        Role result = x.getReportsTo();
        System.out.println(result.getId() + " " + result.getName());
    }

}
