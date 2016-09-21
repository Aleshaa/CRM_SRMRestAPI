package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.Buy;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.BuyService;
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
public class BuyController {

    @Autowired
    BuyService buyService;

    private static final Logger logger = Logger.getLogger(BuyController.class);

    @RequestMapping(value = "/buys", method = RequestMethod.GET)
    public @ResponseBody
    List<Buy> getBuys() {
        List<Buy> buyList = null;
        try {
            logger.info("GET Request for Buys");
            buyList = buyService.getBuyList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return buyList;
        }
        return buyList;
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Buy getBuy(@PathVariable("id") int id) {
        Buy buy = null;
        try {
            logger.info("GET Request for Buy by ID");
            buy = buyService.getBuyById(id);
            if (buy == null) {
                buy = new Buy();
                logger.info("Buy with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            buy = new Buy();
            return buy;
        }
        return buy;
    }


    @RequestMapping(value = "/buy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addBuy(@RequestBody Buy buy) {
        try {
            buyService.addBuy(buy);
            return new Status(200, "Buy added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/buys", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addBuys(@RequestBody List<Buy> buys) {
        try {
            buyService.addBuys(buys);
            return new Status(200, "Buys added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updBuy(@RequestBody Buy buy) {
        try {
            buyService.updateBuy(buy);
            return new Status(200, "Buy update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/buys", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updBuys(@RequestBody List<Buy> buys) {
        try {
            buyService.updateBuys(buys);
            return new Status(200, "Buys update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/buys", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delBuys() {
        try {
            buyService.deleteAllBuy();
            return new Status(200, "Buys deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delBuy(@PathVariable("id") int id) {

        try {
            buyService.deleteBuy(id);
            return new Status(200, "Buy deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
