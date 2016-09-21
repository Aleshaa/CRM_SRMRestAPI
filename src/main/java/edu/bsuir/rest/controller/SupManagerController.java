package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.SupManager;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.SupManagerService;
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
public class SupManagerController {

    @Autowired
    SupManagerService supManagerService;

    private static final Logger logger = Logger.getLogger(SupManagerController.class);

    @RequestMapping(value = "/supManagers", method = RequestMethod.GET)
    public @ResponseBody
    List<SupManager> getSupManagers() {
        List<SupManager> supManagerList = null;
        try {
            logger.info("GET Request for SupManagers");
            supManagerList = supManagerService.getSupManagerList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return supManagerList;
        }
        return supManagerList;
    }

    @RequestMapping(value = "/supManager/{id}", method = RequestMethod.GET)
    public @ResponseBody
    SupManager getSupManager(@PathVariable("id") int id) {
        SupManager supManager = null;
        try {
            logger.info("GET Request for SupManager by ID");
            supManager = supManagerService.getSupManagerById(id);
            if (supManager == null) {
                supManager = new SupManager();
                logger.info("SupManager with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            supManager = new SupManager();
            return supManager;
        }
        return supManager;
    }


    @RequestMapping(value = "/supManager", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addSupManager(@RequestBody SupManager supManager) {
        try {
            supManagerService.addSupManager(supManager);
            return new Status(200, "SupManager added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/supManagers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addSupManagers(@RequestBody List<SupManager> supManagers) {
        try {
            supManagerService.addSupManagers(supManagers);
            return new Status(200, "SupManagers added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/supManager/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updSupManager(@RequestBody SupManager supManager) {
        try {
            supManagerService.updateSupManager(supManager);
            return new Status(200, "SupManager update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/supManagers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updSupManagers(@RequestBody List<SupManager> supManagers) {
        try {
            supManagerService.updateSupManagers(supManagers);
            return new Status(200, "SupManagers update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/supManagers", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delSupManagers() {
        try {
            supManagerService.deleteAllSupManager();
            return new Status(200, "SupManagers deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "supManager/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delSupManager(@PathVariable("id") int id) {

        try {
            supManagerService.deleteSupManager(id);
            return new Status(200, "SupManager deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
