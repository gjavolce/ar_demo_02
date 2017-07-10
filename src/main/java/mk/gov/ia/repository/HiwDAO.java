/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import mk.gov.ia.model.Hiw;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author expert
 */
@Repository
public class HiwDAO extends GenericRepository<Hiw> {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HiwDAO() {
        super(Hiw.class);
    }

    public List<Hiw> getAllHiws() {

        Criteria cq = getSessionFactory().getCurrentSession().createCriteria(Hiw.class);

        Criterion crt = Restrictions.conjunction()
                .add(Restrictions.isNull("deletedDate"));
        cq.add(crt);

        return cq.list() != null ? cq.list() : new ArrayList<>();
    }
}
