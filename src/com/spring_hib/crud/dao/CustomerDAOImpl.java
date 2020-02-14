package com.spring_hib.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring_hib.crud.entity.Customer;

//for the DAO impl class @Repository annotation is given
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	/*
	 * need to inject the session factory to talk to the database customerDAOImpl is
	 * dependent on sessionFactory
	 */

	@Autowired
	private SessionFactory sessionFactory;

	// add the @Transactional so that all the steps getTransactions, session..
	// commit is done by spring itself

	/*
	 * here @Transactional removed it from here becoz we have implemented service
	 * layer impl class for doing same thing as a good practice.
	 */

	@Override
	public List<Customer> getCustomers() {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the query, create HQL to select Customers (multiple) from DB
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class); // from Customer , an
																								// entity class

		// query returns the list of customers
		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		// currentSession.save(theCustomer) or currentSession.update(theCustomer);
		// this makes hibernate to work behind the scene to update if exitsting customer
		// or to insert if empty behind the scene
		currentSession.saveOrUpdate(theCustomer);
	}
	
	@Override
	public Customer getCustomer(int id) {

		// getting current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve that customer from the db using that id
		Customer theCustomer = session.get(Customer.class, id);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		// getting current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//actually delete the customer using HQL
		Query<?> query = currentSession.createQuery("delete from Customer where id=:theId");
		query.setParameter("theId",id);
		query.executeUpdate();
		System.out.println("delete done ? ");
		
	}
}
