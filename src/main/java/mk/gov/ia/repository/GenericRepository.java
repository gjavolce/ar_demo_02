package mk.gov.ia.repository;

import mk.gov.ia.exception.DataStoreIntegrityException;
import mk.gov.ia.exception.NoSuchObjectException;
import mk.gov.ia.model.BaseObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * customer DAO
 *
 * @author uday
 * @param <T>
 * @since 19 Nov 2013
 * @version 1.0.0
 *
 */
public class GenericRepository<T extends BaseObject> {

    public int create(T object) {

        return (int) getSessionFactory().getCurrentSession().save(object);

    }

    public void update(T updatedObject) throws 
            DataStoreIntegrityException, NoSuchObjectException {
        
        getById(updatedObject.getId());

        getSessionFactory().getCurrentSession().update(updatedObject);

    }
    
    public void delete(int objectId) throws 
            DataStoreIntegrityException, NoSuchObjectException {
        
        getSessionFactory().getCurrentSession().delete(getById(objectId));

    }

    public T getById(int id) throws 
            DataStoreIntegrityException, NoSuchObjectException {

        return getByParam("id", id);
    }
    
    public T getByParam(String paramName, Object paramValue) throws 
            DataStoreIntegrityException, NoSuchObjectException {

        try {

            Map<String, Object> params = new HashMap<>();

            params.put(paramName, paramValue);

            List<T> list = findByParams(params);

            if (list != null && list.size() == 1) {

                return (T) list.get(0);

            } else if (list != null && list.isEmpty()) {

                throw new NoSuchObjectException();

            } else {

                throw new DataStoreIntegrityException("CRITICAL: Duplicate value for" + 
                        paramName + " in entity "
                        + entityClass.getName() + paramValue);
            }

        } catch (NoSuchFieldException ex) {

            throw new DataStoreIntegrityException("CRITICAL: Column ID not found in entity : "
                    + entityClass.getName());

        }

    }
    
    public List<T> findByParam(String paramName, Object paramValue) throws NoSuchFieldException {

        Map<String, Object> params = new HashMap<>();
        
        params.put(paramName, paramValue);
        
        return findByParams(params);

    }

    public List<T> findByParams(Map<String, Object> params) throws NoSuchFieldException {

        Criteria cq = getSessionFactory().getCurrentSession().createCriteria(entityClass);

        for (String x : params.keySet()) {

            if(params.get(x) instanceof String) {
                
                cq.add(Restrictions.eq(x, params.get(x)).ignoreCase());
                
            } else {
                
                cq.add(Restrictions.eq(x, params.get(x)));
                
            }
            
            

        }
        
        return cq.list() != null ? cq.list() : new ArrayList<>();

    }

    public List<T> findAll() {
        return getSessionFactory().getCurrentSession().createCriteria(entityClass).list();
    }

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private final Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

}
