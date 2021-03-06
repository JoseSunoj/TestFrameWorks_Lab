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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Sunoj Jose
 *
 */
class CustomerTest {

	private Customer customer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test Begins for Customer Calss.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Finished Tests for Customer Class.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("Sunoj Jose", "12345678");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		customer = null;
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.Customer#Customer(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCustomer() {
		customer = new Customer("Evan", "01123456");
		assertTrue(customer != null);
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.Customer#getName()}.
	 */
	@Test
	void testGetName() {
		assertTrue(customer.getName() != null);
		assertEquals(customer.getName(), "Sunoj Jose");
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.Customer#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		customer.setName("John Doe");
		assertTrue(customer.getName() != null);
		assertEquals(customer.getName(), "John Doe");
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.Customer#getAcNumber()}.
	 */
	@Test
	void testGetAcNumber() {
		assertTrue(customer.getAcNumber() != null);
		assertEquals(customer.getName(), "Sunoj Jose");
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.Customer#setAcNumber(java.lang.String)}.
	 */
	@Test
	void testSetAcNumber() {
		customer.setAcNumber("22222222");
		assertTrue(customer.getAcNumber() != null);
		assertEquals(customer.getAcNumber(), "22222222");
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.Customer#validateName()}.
	 */
	@Test
	void testValidateName() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			customer.setName(null);
			customer.validateName();
		});
	}

	/**
	 * Test method for
	 * {@link ie.lyit.MvnApps.BankManager.Customer#validateAcNumber()}.
	 */
	@Test
	void testValidateAcNumber() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			customer.setAcNumber(null);
			customer.validateAcNumber();
		});
	}
	@Timeout(value = 5)
	@ParameterizedTest
	@CsvSource({ "1", "123", "abcd1234", "6789aBCD", "123456789", "/" })
	void testValidateAcNumber(String value) {
		Assertions.assertThrows(RuntimeException.class, () -> {
			customer.setAcNumber(value);
			customer.validateAcNumber();
		});
	}

	/**
	 * Test method for {@link ie.lyit.MvnApps.BankManager.Customer#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(customer.toString(), "Customer [name=Sunoj Jose, acNumber=12345678]");
	}

}
