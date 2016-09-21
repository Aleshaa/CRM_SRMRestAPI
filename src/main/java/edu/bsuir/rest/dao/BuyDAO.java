package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.Buy;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public class BuyDAO implements IDao<Buy> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(Buy element) throws Exception {

        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;

    }

    @Override
    public boolean addList(List<Buy> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Buy buy:elements) {
            session.beginTransaction();
            session.save(buy);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(Buy element) throws Exception {
        session = sessionFactory.openSession();
        Buy buy;
        buy = (Buy) session.load(Buy.class, element.getId());
        tx = session.getTransaction();
        buy = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(buy);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<Buy> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Buy buy:elements) {
            session.beginTransaction();
            String hql = "FROM Buy C WHERE C.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", buy.getId());
            Buy buy1 = (Buy) query.uniqueResult();
            session.saveOrUpdate(buy1);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public Buy getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Buy C WHERE C.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Buy client = (Buy) query.uniqueResult();
        session.close();
        return client;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Buy> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Buy> ClientList = session.createCriteria(Buy.class).list();
        session.close();
        return ClientList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Buy.class, id);
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
        session.createQuery("DELETE FROM Buy").executeUpdate();
        tx.commit();
        return false;
    }
}
