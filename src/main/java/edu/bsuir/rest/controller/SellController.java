package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.Sell;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.SellService;
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
public class SellController {

    @Autowired
    SellService sellService;

    private static final Logger logger = Logger.getLogger(SellController.class);

    @RequestMapping(value = "/sells", method = RequestMethod.GET)
    public @ResponseBody
    List<Sell> getSells() {
        List<Sell> sellList = null;
        try {
            logger.info("GET Request for Sells");
            sellList = sellService.getSellList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return sellList;
        }
        return sellList;
    }

    @RequestMapping(value = "/sell/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Sell getSell(@PathVariable("id") int id) {
        Sell sell = null;
        try {
            logger.info("GET Request for Sell by ID");
            sell = sellService.getSellById(id);
            if (sell == null) {
                sell = new Sell();
                logger.info("Sell with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            sell = new Sell();
            return sell;
        }
        return sell;
    }


    @RequestMapping(value = "/sell", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addSell(@RequestBody Sell sell) {
        try {
            sellService.addSell(sell);
            return new Status(200, "Sell added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/sells", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addSells(@RequestBody List<Sell> sells) {
        try {
            sellService.addSells(sells);
            return new Status(200, "Sells added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/sell/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updSell(@RequestBody Sell sell) {
        try {
            sellService.updateSell(sell);
            return new Status(200, "Sell update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/sells", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updSells(@RequestBody List<Sell> sells) {
        try {
            sellService.updateSells(sells);
            return new Status(200, "Sells update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/sells", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delSells() {
        try {
            sellService.deleteAllSell();
            return new Status(200, "Sells deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "sell/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delSell(@PathVariable("id") int id) {

        try {
            sellService.deleteSell(id);
            return new Status(200, "Sell deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
