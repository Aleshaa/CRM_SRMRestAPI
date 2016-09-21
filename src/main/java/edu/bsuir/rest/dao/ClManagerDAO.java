package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.ClManager;
import edu.bsuir.rest.model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class ClManagerDAO implements IDao<ClManager> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(ClManager element) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean addList(List<ClManager> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(ClManager clManager:elements) {
            session.beginTransaction();
            session.save(clManager);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(ClManager element) throws Exception {
        session = sessionFactory.openSession();
        ClManager clManager;
        clManager = (ClManager) session.load(ClManager.class, element.getId());
        tx = session.getTransaction();
        clManager = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(clManager);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<ClManager> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(ClManager clManagert:elements) {
            session.beginTransaction();
            String hql = "FROM ClManager C WHERE C.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", clManagert.getId());
            ClManager clManager = (ClManager) query.uniqueResult();
            session.saveOrUpdate(clManager);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public ClManager getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM ClManager C WHERE C.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        ClManager clManager = (ClManager) query.uniqueResult();
        session.close();
        return clManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ClManager> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<ClManager> clManagerList = session.createCriteria(ClManager.class).list();
        session.close();
        return clManagerList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(ClManager.class, id);
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
        session.createQuery("DELETE FROM ClManager").executeUpdate();
        tx.commit();
        return false;
    }
}
