/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import mk.gov.ia.exception.DataStoreIntegrityException;
import mk.gov.ia.exception.NoSuchObjectException;
import mk.gov.ia.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author internet
 */
@Repository
public class RoleRepository extends GenericRepository<Role> {

    @Autowired
    private SessionFactory sessionFactory;

    public RoleRepository() {
        super(Role.class);
    }

    public Role getParent(Role x) throws DataStoreIntegrityException, NoSuchObjectException {
        return this.getById(x.getReportsTo().getId());
    }

}
