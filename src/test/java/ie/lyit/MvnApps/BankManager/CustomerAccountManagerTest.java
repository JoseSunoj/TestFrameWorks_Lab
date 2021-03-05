/**
 * 
 */
package ie.lyit.MvnApps.BankManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Sunoj Jose
 *
 */
class CustomerAccountManagerTest {

	private CustomerAccountManager manager;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		manager = new CustomerAccountManager();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#addCustomer(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddCustomer() {
		manager.addCustomer("Sunoj Jose", "12345678");
		assertEquals(1, manager.customers.size());
		assertFalse(manager.customers.isEmpty());
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	@DisplayName("Should Not Create Customer Object for null values")
	void testValidateCustomer() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer(null, null);
		});
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 * 
	 */
	@Test
	@DisplayName("Should Not Create Customer Object for null values/ wrong argument types")
	void testValidateCustomerTwo() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer(null, "1");
		});
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 * 
	 */
	@Test
	@DisplayName("Should Not Create Customer Object for wrong argument types")
	void testValidateCustomerThree() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer("Sunoj Jose", "abcdefgh");
		});
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#verifyCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	@DisplayName("Should Not allow duplicate entries.")
	void testVerifyCustomer() {
		var aCustomer = new Customer("Sunoj Jose", "12345678");
		manager.customers.put(aCustomer, 0.0);
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.verifyCustomer(aCustomer);
		});
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#deposit(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	@DisplayName("Should Not allow deposit operation for amount less than 1.")
	void testDeposit() {
		var aCustomer = new Customer("Sunoj Jose", "12345678");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			manager.deposit(aCustomer, 0.0);
		});
	}

	@Test
	@DisplayName("Should allow deposit operation for amount more than 0.")
	void testDepositOne() {
		var aCustomer = new Customer("Sunoj Jose", "12345678");
		manager.deposit(aCustomer, 1000.0);
		assertEquals(1000.0, manager.customers.get(aCustomer));
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#withdraw(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	void testWithdraw() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#getBalanceInfo(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	void testGetBalanceInfo() {
		fail("Not yet implemented"); // TODO
	}

}
