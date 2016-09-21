package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.ClientDAO;
import edu.bsuir.rest.model.Client;
import edu.bsuir.rest.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDAO;

    @Override
    public boolean addClient(Client client) throws Exception {
        return clientDAO.add(client);
    }

    @Override
    public boolean addClients(List<Client> clients) throws Exception {
        return clientDAO.addList(clients);
    }

    @Override
    public boolean updateClient(Client client) throws Exception {
        return clientDAO.update(client);
    }

    @Override
    public boolean updateClients(List<Client> clients) throws Exception {
        return clientDAO.updateList(clients);
    }

    @Override
    public Client getClientById(int id) throws Exception {
        return clientDAO.getById(id);
    }

    @Override
    public List<Client> getClientList() throws Exception {
        return clientDAO.getList();
    }

    @Override
    public boolean deleteClient(int id) throws Exception {
        return clientDAO.delete(id);
    }

    @Override
    public boolean deleteAllClient() throws Exception {
        return deleteAllClient();
    }
}
