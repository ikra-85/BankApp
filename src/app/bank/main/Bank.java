package app.bank.main;

import java.util.ArrayList;

import app.bank.customers.Customer;

public class Bank {
	ArrayList<Customer> customers = new ArrayList<>();
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
		
	}

	public Customer getCustomer(int account) {
		return customers.get(account);
	}

	ArrayList<Customer> getCustomers(){
		return customers;
	}
}
