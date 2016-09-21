package edu.bsuir.rest.controller;

import edu.bsuir.rest.model.Supplier;
import edu.bsuir.rest.model.status.Status;
import edu.bsuir.rest.services.SupplierService;
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
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    private static final Logger logger = Logger.getLogger(SupplierController.class);

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public @ResponseBody
    List<Supplier> getSuppliers() {
        List<Supplier> supplierList = null;
        try {
            logger.info("GET Request for Suppliers");
            supplierList = supplierService.getSupplierList();
        } catch (Exception e) {
            logger.debug("GET Request");
            e.printStackTrace();
            return supplierList;
        }
        return supplierList;
    }

    @RequestMapping(value = "/supplier/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Supplier getSupplier(@PathVariable("id") int id) {
        Supplier supplier = null;
        try {
            logger.info("GET Request for Supplier by ID");
            supplier = supplierService.getSupplierById(id);
            if (supplier == null) {
                supplier = new Supplier();
                logger.info("Supplier with such ID doesn't exit");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            supplier = new Supplier();
            return supplier;
        }
        return supplier;
    }


    @RequestMapping(value = "/supplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addSupplier(@RequestBody Supplier supplier) {
        try {
            supplierService.addSupplier(supplier);
            return new Status(200, "Supplier added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addSuppliers(@RequestBody List<Supplier> suppliers) {
        try {
            supplierService.addSuppliers(suppliers);
            return new Status(200, "Suppliers added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/supplier/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updSupplier(@RequestBody Supplier supplier) {
        try {
            supplierService.updateSupplier(supplier);
            return new Status(200, "Supplier update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updSuppliers(@RequestBody List<Supplier> suppliers) {
        try {
            supplierService.updateSuppliers(suppliers);
            return new Status(200, "Suppliers update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delSuppliers() {
        try {
            supplierService.deleteAllSupplier();
            return new Status(200, "Suppliers deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "supplier/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delSupplier(@PathVariable("id") int id) {

        try {
            supplierService.deleteSupplier(id);
            return new Status(200, "Supplier deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
