package com.example.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.entity.Customer;
import com.example.hms.service.CustomerService;


@RestController
public class CustomerController {
	
	@GetMapping("/msg")
	public String getMessage(){
		return "hello world";
	}
	
	@Autowired
	private CustomerService eservice;
	
	@PostMapping("/savecustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
	System.out.println(customer);
	return new ResponseEntity<Customer>(eservice.saveCustomer(customer), HttpStatus.OK);
	}
	
	@GetMapping("/getallcustomers")
    public List<Customer> getAllCustomer() {

        return eservice.getAllCustomer();
    }

    @GetMapping("/getcustomer/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id) {

        Customer emp = eservice.getCustomerById(id);
        if (emp == null) {
            return new ResponseEntity<Object>("NO DATA FOUND!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(emp, HttpStatus.OK);
        }
    }
    
    
    
    @PutMapping("/updatecustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return eservice.updateCustomer(customer);
        
    }
    
    

    @DeleteMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        return eservice.deleteCustomer(id);
        
        
    }

}