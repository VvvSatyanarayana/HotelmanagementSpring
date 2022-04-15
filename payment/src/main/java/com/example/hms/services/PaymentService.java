package com.example.hms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.entity.Payment;
import com.example.hms.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository erepo;
	
	public Payment savePayment(Payment emp) {
		return erepo.save(emp);
	}
	
	public List<Payment> getAllPayment() {
     return erepo.findAll();     
    }

    public Payment getPaymentById(int id) {
       Optional<Payment> op=erepo.findById(id);
        if(op.isPresent()) {
            return op.get();
        }else {
            return null;
        }
        
    }

    public Payment updatePayment(Payment payment) {
       
        return erepo.save(payment);
        
    }

    public String deletePayment(int id) {
     
        erepo.deleteById(id);
        return "SUCCESS";
    }
}