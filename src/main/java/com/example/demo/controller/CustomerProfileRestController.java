package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customerprofile")
public class CustomerProfileRestController {

    @Autowired
    private CustomerProfileService customerprofileService;

    @PostMapping("/create")
    public CustomerProfile createCustomerProfile(@RequestBody CustomerProfile customerprofile) {
        CustomerProfile newCustomerProfile = customerprofileService.createCustomerProfile(customerprofile);
        System.out.println("Service createCustomerProfile: " + newCustomerProfile);
        return newCustomerProfile;
    }
    @PostMapping("/createAll")
    public Iterable<CustomerProfile> createAllCustomerProfile(@RequestBody Iterable<CustomerProfile> customerprofiles) {
        Iterable<CustomerProfile> newCustomerProfiles = customerprofileService.saveAll(customerprofiles);
        System.out.println("Service createAllCustomerProfiles: " + customerprofiles);
        return newCustomerProfiles;
    }

    //----------------------------- UPDATE -----------------------------
    @PutMapping("/byId")
    public CustomerProfile updateCustomerProfile(@RequestBody CustomerProfile customerprofile) {
        if (customerprofile.getId() == null || customerprofileService.getCustomerProfileById(customerprofile.getId()) == null) {
            return null;
        }
        CustomerProfile updatedCustomerProfile = customerprofileService.updateCustomerProfile(customerprofile);
        System.out.println("Service updateCustomerProfile: " + updatedCustomerProfile);
        return updatedCustomerProfile;
    }
    //----------------------------- GET -----------------------------
    @GetMapping("/byId")
    public CustomerProfile getCustomerProfileById(@RequestParam("id") String id) {
        CustomerProfile foundCustomerProfile = customerprofileService.getCustomerProfileById (id);
        if (foundCustomerProfile == null) {
            return null;
        }
        System.out.println("Service getCustomerProfile: " + foundCustomerProfile);
        return foundCustomerProfile;
    }
    @GetMapping("/all")
    public Iterable<CustomerProfile> getAllCustomerProfiles(){
        Iterable<CustomerProfile> customerprofiles =  customerprofileService.getAllCustomerProfiles();
        System.out.println("Service getAllCustomerProfiles: " + customerprofiles);
        return customerprofiles;
    }

    //------------------ DELETE ----------------------
    @DeleteMapping("/byId")
    public void deleteById(@RequestParam("id") String id){
        CustomerProfile foundCustomerProfile = customerprofileService.getCustomerProfileById (id);
        if (foundCustomerProfile == null) {
            System.out.println( "Service getCustomerProfileById: " + id + " not found");;
        }
        customerprofileService.deleteCustomerProfile(id);
        System.out.println("Service deleteCustomerProfile: " + foundCustomerProfile);
    }
    @DeleteMapping("/all")
    public void deleteAllCustomerProfiles() {
        customerprofileService.deleteAllCustomerProfiles();
    }

}

