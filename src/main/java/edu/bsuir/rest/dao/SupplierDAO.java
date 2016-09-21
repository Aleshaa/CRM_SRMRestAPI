package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class SupplierDAO implements IDao<Supplier> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(Supplier element) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean addList(List<Supplier> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Supplier supplier:elements) {
            session.beginTransaction();
            session.save(supplier);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(Supplier element) throws Exception {
        session = sessionFactory.openSession();
        Supplier supplier;
        supplier = (Supplier) session.load(Supplier.class, element.getId());
        tx = session.getTransaction();
        supplier = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(supplier);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<Supplier> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Supplier supplier:elements) {
            session.beginTransaction();
            String hql = "FROM Supplier G WHERE G.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", supplier.getId());
            Supplier supplier1 = (Supplier) query.uniqueResult();
            session.saveOrUpdate(supplier1);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public Supplier getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Supplier G WHERE G.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Supplier supplier = (Supplier) query.uniqueResult();
        session.close();
        return supplier;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Supplier> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Supplier> supplierList = session.createCriteria(Supplier.class).list();
        session.close();
        return supplierList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Supplier.class, id);
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
        session.createQuery("DELETE FROM Supplier").executeUpdate();
        tx.commit();
        return false;
    }
}
