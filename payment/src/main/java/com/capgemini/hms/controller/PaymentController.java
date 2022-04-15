package com.capgemini.hms.controller;

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

import com.example.hms.entity.Payment;
import com.example.hms.services.PaymentService;

@RestController
public class PaymentController {
	@GetMapping("/msg")
	public String getMessage(){
		return "hello world";
	}
	
	@Autowired
	private PaymentService eservice;
	
	@PostMapping("/savepayment")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
	System.out.println(payment);
	return new ResponseEntity<Payment>(eservice.savePayment(payment), HttpStatus.OK);
	}
	
	@GetMapping("/getallpayments")
    public List<Payment> getAllPayment() {

        return eservice.getAllPayment();
    }

    @GetMapping("/getpayment/{id}")
    public ResponseEntity<Object> getPaymentById(@PathVariable("id") int id) {

        Payment emp = eservice.getPaymentById(id);
        if (emp == null) {
            return new ResponseEntity<Object>("NO DATA FOUND!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(emp, HttpStatus.OK);
        }
    }
    
    
    
    @PutMapping("/updatepayment")
    public Payment updatePayment(@RequestBody Payment payment) {
        return eservice.updatePayment(payment);
        
    }
    
    

    @DeleteMapping("/deletepayment/{id}")
    public String deletePayment(@PathVariable("id") int id) {
        return eservice.deletePayment(id);
        
        
    }

}