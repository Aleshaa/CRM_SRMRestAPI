package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.Sell;
import edu.bsuir.rest.model.Sell;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class SellDAO implements IDao<Sell> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(Sell element) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean addList(List<Sell> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Sell sell:elements) {
            session.beginTransaction();
            session.save(sell);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(Sell element) throws Exception {
        session = sessionFactory.openSession();
        Sell sell;
        sell = (Sell) session.load(Sell.class, element.getId());
        tx = session.getTransaction();
        sell = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(sell);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<Sell> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Sell sell:elements) {
            session.beginTransaction();
            String hql = "FROM Sell G WHERE G.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", sell.getId());
            Sell sell1 = (Sell) query.uniqueResult();
            session.saveOrUpdate(sell1);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public Sell getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Sell G WHERE G.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Sell sell = (Sell) query.uniqueResult();
        session.close();
        return sell;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Sell> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Sell> sellList = session.createCriteria(Sell.class).list();
        session.close();
        return sellList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Sell.class, id);
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
        session.createQuery("DELETE FROM Sell").executeUpdate();
        tx.commit();
        return false;
    }
}
