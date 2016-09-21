package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.Buy;
import edu.bsuir.rest.model.Good;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class GoodDAO implements IDao<Good> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(Good element) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean addList(List<Good> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Good good:elements) {
            session.beginTransaction();
            session.save(good);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(Good element) throws Exception {
        session = sessionFactory.openSession();
        Good good;
        good = (Good) session.load(Good.class, element.getId());
        tx = session.getTransaction();
        good = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(good);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<Good> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Good good:elements) {
            session.beginTransaction();
            String hql = "FROM Good G WHERE G.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", good.getId());
            Good good1 = (Good) query.uniqueResult();
            session.saveOrUpdate(good1);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public Good getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Good G WHERE G.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Good good = (Good) query.uniqueResult();
        session.close();
        return good;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Good> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Good> goodList = session.createCriteria(Good.class).list();
        session.close();
        return goodList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Good.class, id);
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
        session.createQuery("DELETE FROM Good").executeUpdate();
        tx.commit();
        return false;
    }
}
