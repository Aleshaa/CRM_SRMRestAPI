package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.Client;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */

@Controller
@RequestMapping("/rest")
public class ClientController {

    @Autowired
    ClientService clientService;

    private static final Logger logger = Logger.getLogger(ClientController.class);

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public @ResponseBody
    List<Client> getClients() {
        List<Client> clientList = null;
        try {
            logger.info("GET Request for Clients");
            clientList = clientService.getClientList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return clientList;
        }
        return clientList;
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Client getClient(@PathVariable("id") int id) {
        Client client = null;
        try {
            logger.info("GET Request for Client by ID");
            client = clientService.getClientById(id);
            if (client == null) {
                client = new Client();
                logger.info("Client with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            client = new Client();
            return client;
        }
        return client;
    }


    @RequestMapping(value = "/client", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addClient(@RequestBody Client client) {
        try {
            clientService.addClient(client);
            return new Status(200, "Client added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addClients(@RequestBody List<Client> clients) {
        try {
            clientService.addClients(clients);
            return new Status(200, "Clients added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updClient(@RequestBody Client client) {
        try {
            clientService.updateClient(client);
            return new Status(200, "Client update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clients", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updClients(@RequestBody List<Client> clients) {
        try {
            clientService.updateClients(clients);
            return new Status(200, "Clients update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clients", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delClients() {
        try {
            clientService.deleteAllClient();
            return new Status(200, "Clients deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delClient(@PathVariable("id") int id) {

        try {
            clientService.deleteClient(id);
            return new Status(200, "Client deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
