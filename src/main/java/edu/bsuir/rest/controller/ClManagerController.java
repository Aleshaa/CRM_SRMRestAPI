package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.ClManager;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.ClManagerService;
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
public class ClManagerController {

    @Autowired
    ClManagerService clManagerService;

    private static final Logger logger = Logger.getLogger(ClManagerController.class);

    @RequestMapping(value = "/clManagers", method = RequestMethod.GET)
    public @ResponseBody
    List<ClManager> getClManagers() {
        List<ClManager> clManagerList = null;
        try {
            logger.info("GET Request for ClManagers");
            clManagerList = clManagerService.getClManagerList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return clManagerList;
        }
        return clManagerList;
    }

    @RequestMapping(value = "/clManager/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ClManager getClManager(@PathVariable("id") int id) {
        ClManager clManager = null;
        try {
            logger.info("GET Request for ClManager by ID");
            clManager = clManagerService.getClManagerById(id);
            if (clManager == null) {
                clManager = new ClManager();
                logger.info("ClManager with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            clManager = new ClManager();
            return clManager;
        }
        return clManager;
    }


    @RequestMapping(value = "/clManager", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addClManager(@RequestBody ClManager clManager) {
        try {
            clManagerService.addClManager(clManager);
            return new Status(200, "ClManager added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clManagers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addClManagers(@RequestBody List<ClManager> clManagers) {
        try {
            clManagerService.addClManagers(clManagers);
            return new Status(200, "ClManagers added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clManager/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updClManager(@RequestBody ClManager clManager) {
        try {
            clManagerService.updateClManager(clManager);
            return new Status(200, "ClManager update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clManagers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updClManagers(@RequestBody List<ClManager> clManagers) {
        try {
            clManagerService.updateClManagers(clManagers);
            return new Status(200, "ClManagers update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/clManagers", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delClManagers() {
        try {
            clManagerService.deleteAllClManager();
            return new Status(200, "ClManagers deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "clManager/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delClManager(@PathVariable("id") int id) {

        try {
            clManagerService.deleteClManager(id);
            return new Status(200, "ClManager deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
