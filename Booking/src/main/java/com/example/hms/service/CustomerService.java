package com.example.hms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.entity.Customer;
import com.example.hms.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository erepo;
	
	public Customer saveCustomer(Customer emp) {
		return erepo.save(emp);
	}
	
	public List<Customer> getAllCustomer() {
     return erepo.findAll();     
    }

    public Customer getCustomerById(int id) {
       Optional<Customer> op=erepo.findById(id);
        if(op.isPresent()) {
            return op.get();
        }else {
            return null;
        }
        
    }

    public Customer updateCustomer(Customer customer) {
       
        return erepo.save(customer);
        
    }

    public String deleteCustomer(int id) {
     
        erepo.deleteById(id);
        return "SUCCESS";
    }
}
	




