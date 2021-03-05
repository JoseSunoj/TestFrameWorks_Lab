/**
 * 
 */
package ie.lyit.MvnApps.BankManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	 * Test method for {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#addCustomer(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddCustomer() {
		manager.addCustomer("Sunoj Jose", "12345678");
		assertEquals(1, manager.customers.size());
		assertFalse(manager.customers.isEmpty());
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#validateCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	void testValidateCustomer() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#verifyCustomer(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	void testVerifyCustomer() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#deposit(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	void testDeposit() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#withdraw(ie.lyit.MvnApps.BankManager.Customer, java.lang.Double)}.
	 */
	@Test
	void testWithdraw() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.CustomerAccountManager#getBalanceInfo(ie.lyit.MvnApps.BankManager.Customer)}.
	 */
	@Test
	void testGetBalanceInfo() {
		fail("Not yet implemented"); // TODO
	}

}
