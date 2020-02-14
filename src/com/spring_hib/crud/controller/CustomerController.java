package com.spring_hib.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_hib.crud.entity.Customer;
import com.spring_hib.crud.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	/*
	 * -- inject dao to our customer controller -- spring will scan for the class
	 * that implements CustomerDAO interface through @Repository annotation
	 * 
	 * -- means CustomerController is dependent on customerDAO, so we need to inject
	 * it.
	 * 
	 * -- @Autowired private CustomerDAO customerDAO;
	 */
	//CustomerController is dependent on the CustomerService class.
	@Autowired
	private CustomerService customerService;

	/*
	 * -- @GetMapping request handles only Get requests like url , and reject POST
	 * method. -- its the short for @RequestMapping(path="/processForm", method=
	 * RequestMethod.GET) -- @GetMapping("/list") -- @PostMapping("/list")
	 */
	@GetMapping("/list")
	public String ListCustomers(Model theModel) {
		/*
		 * -- get customers from DAO -- List<Customer> customers =
		 * customerDAO.getCustomers();
		 * 
		 */
		// get customers from service
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model so that we can use it later in view page by
		// accessing customers attribute name given(first param)
		theModel.addAttribute("customersList", customers); // name, value pair [first name is anything we like ]

		return "list-customers";
	}

	// handle showFormForAdd mapping to add the customer
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		
		// create Customer
		Customer theCustomer = new Customer();

		// add customer to the model
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	// handle saveCustomer
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer
		customerService.saveCustomer(theCustomer);

		// redirect it to the list page
		return "redirect:/customer/list";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("custId") int id, Model theModel) {

		// get customer for that id from service layer
		Customer customer = customerService.getCustomer(id);

		// set it as attribute in model to use it in "customer-form"
		theModel.addAttribute("customer", customer);

		// show that data in form field
		// return "redirect:/customer/showFormForAdd";
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("custId") int id) {

		// delete the customer
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";

	}
}