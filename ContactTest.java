package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import Test.Contact; - Was part of the Junit Test creation but shows error

class ContactTest {
	
	// test for working contact creation
	@Test
	void testContactCalss() {
		Contact newContact = new Contact("1001", "Adam", "West", "1231231231", 
				"123 Gotham St. Muskogee, OK 74401");
		assertTrue(newContact.getFirstName().equals("Adam"));
		assertTrue(newContact.getLastName().equals("West"));
		assertTrue(newContact.getId().equals("1001"));
		assertTrue(newContact.getPhone().equals("1231231231"));
		assertTrue(newContact.getAddress().equals("123 Gotham St. Muskogee, OK 74401"));
	}
	// test for too long ID
	@Test
	void testContactClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10000000000", "Adam", "West", "1231231231", 
				"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for null ID
	@Test
	void testContactClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Adam", "West", "1231231231", 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for too long first name
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam1234567", "West", "1231231231", 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for null first name
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", null, "West", "1231231231", 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for too long last name
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam", "West1234567", "1231231231", 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for null last name
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam", null, "1231231231", 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for not exactly 10 characters
	@Test
	void testContactClassPhoneNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam", "West", "123123123", 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for null phone
	@Test
	void testContactCalssPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam", "West", null, 
					"123 Gotham St. Muskogee, OK 74401");
		});
	}
	// test for too long address
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam", "West", "1231231231", 
					"123 Gotham St. Muskogee, OK 74401 123456");
		});
	}
	// test for null address
	@Test
	void testContactClassAddressnull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Adam", "West", "1231231231", 
					null);
		});
	}
	// test fName setter method
	@Test
	void testContactClassSetFirstName() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		newContact.setFirstName("Starky");
		assertTrue(newContact.getFirstName().equals("Starky"));
	}
	@Test
	void testContactClassSetFirstNameTooLong() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("StarkyTooLong");
		});
	}
	@Test
	void testContactClassSetFirstNameNull() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}
	// test lName setter method
	@Test
	void testContactClassSetLastName() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		newContact.setLastName("Starky");
		assertTrue(newContact.getLastName().equals("Starky"));
	}
	@Test
	void testContactClassSetLastNameTooLong() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("StarkyTooLong");
		});
	}
	@Test
	void testContactClassSetLastNameNull() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	// test phone setter method
	@Test
	void testContactClassSetPhone() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		newContact.setPhone("3213213212");
		assertTrue(newContact.getPhone().equals("3213213212"));
	}
	@Test
	void testContactClassSetPhoneTooLong() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("3213213212222222");
		});
	}
	@Test
	void testContactClassSetPhoneNull() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}
	@Test
	void testContactClassSetPhoneTooShort() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("32132");
		});
	}
	// test address setter method
	@Test
	void testContactClassSetAddress() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		newContact.setAddress("new address 2");
		assertTrue(newContact.getAddress().equals("new address 2"));
	}
	@Test
	void testContactClassSetAddressTooLong() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("new address too long 1234567890123");
		});
	}
	@Test
	void testContactClassSetAddressNull() {
		Contact newContact = new Contact("820", "Bruce", "Stark", "3213213213", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
	

}