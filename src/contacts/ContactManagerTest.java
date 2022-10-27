package contacts;

import utils.ContactIO;
import utils.Input;
import utils.Print;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ContactManagerTest {

    public static void main(String[] args) {
        Input inpt = new Input();

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
//        List<String> contactsToAdd = new ArrayList<>();
//        contactsToAdd.add("Mason 5555557 testEmail3@email.com");
//        ContactIO.addLines(contactsToAdd);
//
//        Print.displayContacts();

        ContactList masterList = new ContactList();
        masterList.addContact(new Contact("Steve Pflug", 5555560L, "testEmail5@email.com"));
        Print.displayContacts(masterList.getContacts());
        masterList.addContact(new Contact("Rodrigo Marquez", 5555561L, "testEmail6@email.com"));
        Print.displayContacts(masterList.getContacts());
        ArrayList<Contact> contactsToDelete = masterList.searchContacts("Rodrigo Marquez");
        for(Contact contact : contactsToDelete) {
            System.out.println("Contact that was searched is: " + contact.getName());
            masterList.deleteContact(contact);
        }
        Print.displayContacts(masterList.getContacts());
        if(inpt.yesNo("Do you wish to save? Y|N: ")) {
            masterList.saveList();
        }
    }
}
