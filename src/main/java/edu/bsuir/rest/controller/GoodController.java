package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.Good;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.GoodService;
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
public class GoodController {

    @Autowired
    GoodService goodService;

    private static final Logger logger = Logger.getLogger(GoodController.class);

    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public @ResponseBody
    List<Good> getGoods() {
        List<Good> goodList = null;
        try {
            logger.info("GET Request for Goods");
            goodList = goodService.getGoodList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return goodList;
        }
        return goodList;
    }

    @RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Good getGood(@PathVariable("id") int id) {
        Good good = null;
        try {
            logger.info("GET Request for Good by ID");
            good = goodService.getGoodById(id);
            if (good == null) {
                good = new Good();
                logger.info("Good with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            good = new Good();
            return good;
        }
        return good;
    }


    @RequestMapping(value = "/good", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addGood(@RequestBody Good good) {
        try {
            goodService.addGood(good);
            return new Status(200, "Good added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addGoods(@RequestBody List<Good> goods) {
        try {
            goodService.addGoods(goods);
            return new Status(200, "Goods added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/good/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updGood(@RequestBody Good good) {
        try {
            goodService.updateGood(good);
            return new Status(200, "Good update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/goods", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updGoods(@RequestBody List<Good> goods) {
        try {
            goodService.updateGoods(goods);
            return new Status(200, "Goods update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/goods", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delGoods() {
        try {
            goodService.deleteAllGood();
            return new Status(200, "Goods deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "good/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delGood(@PathVariable("id") int id) {

        try {
            goodService.deleteGood(id);
            return new Status(200, "Good deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
