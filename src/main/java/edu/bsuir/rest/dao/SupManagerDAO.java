package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.SupManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class SupManagerDAO implements IDao<SupManager> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(SupManager element) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean addList(List<SupManager> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(SupManager supManager:elements) {
            session.beginTransaction();
            session.save(supManager);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(SupManager element) throws Exception {
        session = sessionFactory.openSession();
        SupManager supManager;
        supManager = (SupManager) session.load(SupManager.class, element.getId());
        tx = session.getTransaction();
        supManager = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(supManager);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<SupManager> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(SupManager supManager:elements) {
            session.beginTransaction();
            String hql = "FROM SupManager G WHERE G.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", supManager.getId());
            SupManager supManager1 = (SupManager) query.uniqueResult();
            session.saveOrUpdate(supManager1);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public SupManager getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM SupManager G WHERE G.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        SupManager supManager = (SupManager) query.uniqueResult();
        session.close();
        return supManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SupManager> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<SupManager> supManagerList = session.createCriteria(SupManager.class).list();
        session.close();
        return supManagerList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(SupManager.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAll() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM SupManager").executeUpdate();
        tx.commit();
        return false;
    }
}
