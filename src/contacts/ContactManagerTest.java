package contacts;

import utils.ContactIO;
import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class ContactManagerTest {

    public static void main(String[] args) {

        // Test contact

//        Contact testContact = new Contact("Rodrigo", 5555555L, "testEmail@email.com");
//        System.out.printf("Name: %s%nPhone: %s%nEmail: %s%n%n", testContact.getName(), testContact.getPhoneNumber(), testContact.getEmail());
//        testContact.setName("Steve");
//        testContact.setPhoneNumber(5555556L);
//        testContact.setEmail("testEmail2@email.com");
//        System.out.printf("Name: %s%nPhone: %s%nEmail: %s%n%n", testContact.getName(), testContact.getPhoneNumber(), testContact.getEmail());

        // Test contactlist

        // Test print methods
//        Print.appOptions();
//        Print.displayContacts();

        // Test CRUD methods
        List<String> contactsToAdd = new ArrayList<>();
        contactsToAdd.add("Mason 5555557 testEmail3@email.com");
        ContactIO.addLines(contactsToAdd);

        Print.displayContacts();

    }
}
