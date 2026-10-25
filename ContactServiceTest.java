package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	//create a contact and test values
	// this creates contacts with a unique ID using the ContactService addContact method
	@Test
	void testContactServiceClass() {
		ContactService.addContact("Adam", "West", "1231231231", 
				"123 Gotham St. Muskogee, OK 74401");
		//System.out.println(ContactService.contactList.get(0).getId());	used for debugging
		assertTrue(ContactService.contactList.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("Adam"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("West"));
		assertTrue(ContactService.contactList.get(0).getPhone().equals("1231231231"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("123 Gotham St. Muskogee, OK 74401"));
	}
	// confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		ContactService.addContact("Adam", "West", "1231231231", 
				"123 Gotham St. Muskogee, OK 74401");
		int size = ContactService.contactList.size();
		//System.out.println(ContactService.contactList.get(size - 1).getId());
		ContactService.deleteContact("1000000003");
		//ContactService.searchContact("1000000003");
		//System.out.println(ContactService.contactList.get(1).getId());
		assertTrue(ContactService.searchContact("1000000003") == 2);
	}
	// update first name test
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("Martha", "Barnes", "2132132132", "Avengers Ave.");
		int size = ContactService.contactList.size();
		System.out.println(ContactService.contactList.get(size - 1).getId());
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000003", "Mary");
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Mary"));
	}
	// using 1000000003 to test the rest
	// test confirming update to last name
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000003", "Kay");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Kay"));
	}
	// test confirming update to phone number
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updatePhoneNum("1000000003", "432143213");
		assertTrue(ContactService.contactList.get(target).getPhone().equals("4321432143"));
	}
	// test confirming update to address
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updateAddress("1000000003", "456 Weston St. Actor, CA 32456");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("456 Weston St. Actor, CA 32456"));
	}
	
	// test to confirm unique ID
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("49594", "George", "Strait", "5432154321", "Original Contact Address");
		ContactService.addContact(newContact);
		Contact duplicateId = new Contact("49594", "George", "Strait", "5432154321", "Duplicate Contact Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(duplicateId);
		});
	}

}