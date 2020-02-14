package com.spring_hib.crud.service;

import java.util.List;

import com.spring_hib.crud.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id); //get customer by id

	public void deleteCustomer(int id);
}
