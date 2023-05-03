package com.prowings.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prowings.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
