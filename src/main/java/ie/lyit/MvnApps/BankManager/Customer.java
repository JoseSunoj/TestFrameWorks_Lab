/**
 * 
 */
package ie.lyit.MvnApps.BankManager;

/**
 * A Java class to store the basic info of the customer.
 * 
 * @author Sunoj Jose
 *
 */
public class Customer {
	private String name;
	private String acNumber;

	/**
	 * @param name     holds the name of the customer
	 * @param acNumber holds the account number
	 */
	public Customer(String name, String acNumber) {
		super();
		this.name = name;
		this.acNumber = acNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the acNumber
	 */
	public String getAcNumber() {
		return acNumber;
	}

	/**
	 * @param acNumber the acNumber to set
	 */
	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	/**
	 * a method to check whether the name is empty or not
	 */
	public void validateName() {
		if (this.name.isBlank()) {
			throw new RuntimeException("Name shuold not be empty.");
		}
	}

	/**
	 * a method to check whether the account number is empty or not
	 */

	public void validateAcNumber() {
		if (this.acNumber.isBlank()) {
			throw new RuntimeException("Account Number shuold not be empty.");
		}
		if (this.acNumber.length()!= 8) {
			throw new RuntimeException("Account Number shuold be of length 8.");
		}
		if (!this.acNumber.matches("\\d+")) {
			throw new RuntimeException("Account Number shuold contain only didgits.");
		}
	}

	/**
	 * @return a string representation of the customer object
	 */
	public String toString() {
		return "Customer [name=" + name + ", acNumber=" + acNumber + "]";
	}

}
