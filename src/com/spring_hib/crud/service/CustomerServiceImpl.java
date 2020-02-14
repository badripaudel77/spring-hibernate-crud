package com.spring_hib.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring_hib.crud.dao.CustomerDAO;
import com.spring_hib.crud.entity.Customer;

//indicating that it is service layer
@Service  
public class CustomerServiceImpl implements CustomerService {

	//inject customerdao because service depends on dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional 	// add the @Transactional so that all the 
	//steps getTransactions, session..

	public List<Customer> getCustomers() {
		
		//delegates call to DAO
		return customerDAO.getCustomers();
	
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
     
		customerDAO.saveCustomer(theCustomer);	
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
        //delegate it to the dao
		customerDAO.deleteCustomer(id);
	}
}
