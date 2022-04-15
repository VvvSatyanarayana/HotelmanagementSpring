package com.example.hms.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	List<Customer> findAll();

}