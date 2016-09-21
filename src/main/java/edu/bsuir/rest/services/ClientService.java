package edu.bsuir.rest.services;

import edu.bsuir.rest.model.Client;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public interface ClientService {

    boolean addClient(Client client) throws Exception;
    boolean addClients(List<Client> clients) throws Exception;
    boolean updateClient(Client client) throws Exception;
    boolean updateClients(List<Client> clients) throws Exception;
    Client getClientById(int id) throws Exception;
    List<Client> getClientList() throws Exception;
    boolean deleteClient(int id) throws Exception;
    boolean deleteAllClient() throws Exception;
}
