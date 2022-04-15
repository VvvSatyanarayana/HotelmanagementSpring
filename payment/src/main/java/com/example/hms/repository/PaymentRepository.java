package com.example.hms.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.entity.Payment;


@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	List<Payment> findAll();
}