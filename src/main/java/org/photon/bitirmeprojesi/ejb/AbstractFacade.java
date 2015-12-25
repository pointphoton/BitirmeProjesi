
package org.photon.bitirmeprojesi.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;


public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
    Session session=  getEntityManager().unwrap(Session.class);
              session.save(entity);
              
      //  getEntityManager().persist(entity);
    }

    public void edit(T entity) {
          Session session=  getEntityManager().unwrap(Session.class);
          session.update(entity);
       // getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        
          Session session=  getEntityManager().unwrap(Session.class);
          session.delete(entity);
    //    getEntityManager().remove(getEntityManager().merge(entity));
        
    }

    public T find(Long id) {
  Session session=  getEntityManager().unwrap(Session.class);
          return    session.get(entityClass, id);       
// return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
          Session session=  getEntityManager().unwrap(Session.class);
        Criteria criteria =session.createCriteria(entityClass);
        return criteria.list();
   /*
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
           */
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    

    
}
