/**
 * 
 */
package ie.lyit.MvnApps.BankManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * A Java class to manage the account details of the customers
 * 
 * @author Sunoj Jose
 *
 */
public class CustomerAccountManager {
	protected Map<Customer, Double> customers = new ConcurrentHashMap<Customer, Double>();

	/**
	 * 
	 * @param name     holds the name of the customer
	 * @param acNumber holds the account number of the customer
	 */
	public void addCustomer(String name, String acNumber) {
		var customer = new Customer(name, acNumber);
		validateCustomer(customer);
		verifyCustomer(customer);
		customers.put(customer, 0.0);

	}

	/**
	 * 
	 * @param customer holds the customer object
	 */
	protected void validateCustomer(Customer customer) {
		customer.validateName();
		customer.validateAcNumber();
	}

	/**
	 * 
	 * @param customer holds the customer object
	 */
	protected void verifyCustomer(Customer customer) {
		if (customers.containsKey(customer)) {
			throw new RuntimeException("Customer Already Exists.");
		}
	}

	/**
	 * 
	 * @param customer holds the customer object
	 * @param amount   holds an amount to deposit
	 */
	protected void deposit(Customer customer, Double amount) {
		if (amount <= 0.0) {
			throw new IllegalArgumentException("Amount must be a positive value.");
		} else {
			customers.put(customer, customers.get(customer) + amount);
		}
	}

	/**
	 * 
	 * @param customer holds the customer object
	 * @param amount   holds an amount to withdraw
	 */
	protected void withdraw(Customer customer, Double amount) {
		if (amount > customers.get(customer)) {
			throw new IllegalArgumentException("Amount exceeds the available limit.");
		} else {
			customers.put(customer, customers.get(customer) - amount);
		}

	}

	/**
	 * 
	 * @param customer holds the customer object
	 * @return the available balance in their account
	 */
	public Double getBalanceInfo(Customer customer) {
		return customers.get(customer);
	}
}
