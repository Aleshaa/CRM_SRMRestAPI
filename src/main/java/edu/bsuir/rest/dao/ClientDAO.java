package edu.bsuir.rest.dao;

import edu.bsuir.rest.model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public class ClientDAO implements IDao<Client> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean add(Client element) throws Exception {

        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.save(element);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean addList(List<Client> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Client Client:elements) {
            session.beginTransaction();
            session.save(Client);
            tx.commit();
        }
        session.close();

        return true;
    }

    @Override
    public boolean update(Client element) throws Exception {
        session = sessionFactory.openSession();
        Client Client;
        Client = (Client) session.load(Client.class, element.getId());
        tx = session.getTransaction();
        Client = element;
        tx = session.beginTransaction();
        session.saveOrUpdate(Client);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateList(List<Client> elements) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        for(Client Client:elements) {
            session.beginTransaction();
            String hql = "FROM Client C WHERE C.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", Client.getId());
            Client client = (Client) query.uniqueResult();
            session.saveOrUpdate(Client);
            session.close();
            tx.commit();
        }
        session.close();
        return true;
    }

    @Override
    public Client getById(int id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Client C WHERE C.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Client client = (Client) query.uniqueResult();
        session.close();
        return client;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Client> ClientList = session.createCriteria(Client.class).list();
        session.close();
        return ClientList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Client.class, id);
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
        session.createQuery("DELETE FROM Client").executeUpdate();
        tx.commit();
        return false;
    }
}
