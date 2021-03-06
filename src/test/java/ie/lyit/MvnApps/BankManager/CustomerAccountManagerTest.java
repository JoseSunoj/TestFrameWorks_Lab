/**
 * 
 */
package ie.lyit.MvnApps.BankManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * In eclipse Run As Junit-5
 * 
 * @author Sunoj Jose
 *
 */
public class CustomerAccountManagerTest {

	private CustomerAccountManager manager;
	private Customer aCustomer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Begins Tests for CustomerAccountManager.");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finished All Tests for CustomerAccountManager.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		manager = new CustomerAccountManager();
		aCustomer = new Customer("Sunoj Jose", "12345678");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		manager = null;
		aCustomer = null;
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#addCustomer(java.lang.String, java.lang.String)}.
	 */
	@RepeatedTest(value = 5)
	public void testAddCustomer() {
		manager.addCustomer("Sunoj Jose", "12345678");
		assertEquals(1, manager.customers.size());
		assertFalse(manager.customers.isEmpty());
	}

	/**
	 * Test method-1 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	@DisplayName("Should Not Create Customer Object for null values")
	public void testValidateCustomer() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer(null, null);
		});
	}

	/**
	 * Test method-2 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 * 
	 */
	@Test
	@DisplayName("Should Not Create Customer Object for null values/ wrong argument types")
	public void testValidateCustomerTwo() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer(null, "1");
		});
	}

	/**
	 * Test method-3 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 * 
	 */
	@Test
	@DisplayName("Should Not Create Customer Object for wrong argument types")
	public void testValidateCustomerThree() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer("Sunoj Jose", "abcdefgh");
		});
	}

	/**
	 * Test method- 4 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 * 
	 */
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	@ParameterizedTest
	@CsvSource({ "1", "123", "abcd1234", "6789aBCD", "123456789" })
	public void testValidateCustomerFour(String value) {
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.addCustomer("Sunoj Jose", value);
		});
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#verifyCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	@DisplayName("Should Not allow duplicate entries.")
	public void testVerifyCustomer() {
		manager.customers.put(aCustomer, 0.0);
		Assertions.assertThrows(RuntimeException.class, () -> {
			manager.verifyCustomer(aCustomer);
		});
	}

	/**
	 * Test method-1 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#deposit(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	@DisplayName("Should Not allow deposit operation for amount less than 1.")
	public void testDeposit() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			manager.deposit(aCustomer, 0.0);
		});
	}

	/**
	 * Test method-2 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#deposit(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	@DisplayName("Should allow deposit operation for amount more than 0.")
	public void testDepositOne() {
		manager.deposit(aCustomer, 1000.0);
		assertEquals(1000.0, manager.customers.get(aCustomer));
	}

	/**
	 * Test method-1 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#withdraw(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	@DisplayName("Should not allow withdraw operation for amount more than available value.")
	public void testWithdraw() {
		manager.deposit(aCustomer, 1000.0);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			manager.withdraw(aCustomer, 1001.0);
		});
	}

	/**
	 * Test method-2 for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#withdraw(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	@DisplayName("Should allow withdraw operation for amount upto available value.")
	public void testWithdrawOne() {
		manager.deposit(aCustomer, 1000.0);
		assertTrue(manager.customers.get(aCustomer) == 1000.0);
		manager.withdraw(aCustomer, 1000.0);
		assertEquals(0.0, manager.customers.get(aCustomer));

	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#getBalanceInfo(ie.lyit.MvnApps.BankManager.Customer)}.
	 */

	@Test
	public void testGetBalanceInfo() {
		manager.deposit(aCustomer, 100.0);
		assertTrue(manager.getBalanceInfo(aCustomer) == 100.0);
		manager.withdraw(aCustomer, 100.0);
		assertFalse(manager.getBalanceInfo(aCustomer) == 100.0);
	}

}
