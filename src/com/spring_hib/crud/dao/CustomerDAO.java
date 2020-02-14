package com.spring_hib.crud.dao;

import java.util.List;

import com.spring_hib.crud.entity.Customer;

//basically DAO is the interface containing all
// the required methods definitions.

public interface CustomerDAO {

	//get all the customers (List of  customers )
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id); //for the single customer by id

	public void deleteCustomer(int id);
	
}
