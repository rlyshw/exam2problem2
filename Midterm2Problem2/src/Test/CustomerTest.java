/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rlyshw.customer.model.Customer;

/**
 * @author rlysh_000
 *
 */
public class CustomerTest {

	/**
	 * @throws java.lang.Exception
	 */
	Customer john;
	Customer invalidZip;
	@Before
	public void setUp() throws Exception {
		john = new Customer("John","Smith","A","Male","123 Apple Lane","Nebraska","12345","Faketown");
		invalidZip = new Customer("","","asdfasdf","","","","1abf49","");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		john = null;
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		assertSame("John",john.getFirstName().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getMiddleInitial()}.
	 */
	@Test
	public void testGetMiddleInitial() {
		assertSame("A",john.getMiddleInitial().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		assertSame("Smith",john.getLastName().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getGender()}.
	 */
	@Test
	public void testGetGender() {
		assertSame("Male",john.getGender().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getAddress()}.
	 */
	@Test
	public void testGetAddress() {
		assertSame("123 Apple Lane", john.getAddress().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getCity()}.
	 */
	@Test
	public void testGetCity() {
		assertSame("Faketown",john.getCity().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getState()}.
	 */
	@Test
	public void testGetState() {
		assertSame("Nebraska",john.getState().get());
	}

	/**
	 * Test method for {@link com.rlyshw.customer.model.Customer#getZip()}.
	 */
	@Test
	public void testGetZip() {
		assertSame("12345",john.getZip().get());
		assertNull(invalidZip.getZip());
	}

}
