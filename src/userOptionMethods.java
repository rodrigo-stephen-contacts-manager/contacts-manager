import contacts.Contact;
import contacts.ContactList;
import utils.Input;
import utils.Print;

import java.util.ArrayList;

public class userOptionMethods {
    public static void viewContacts(ContactList newContactList){
        Print.displayContacts(newContactList.getContacts());
    }
    public static ContactList addContact(ContactList newContactList, Input input){
        String name = input.getString("Enter a name:");
        Long phoneNumber = input.getPhoneNumber("Enter a phone number:");
        String email = input.getString("Enter an email:");
        Contact contact = new Contact(name,phoneNumber,email);
        newContactList.addContact(contact);
        return newContactList;
    }
    public static void searchContact(ContactList newContactList, Input input){
        ArrayList<Contact> searchedContactList = newContactList.searchContacts(input.getString("Enter a name to search for the contact: "));
        Print.displayContacts(searchedContactList);
    }
    public static ContactList deleteContact(ContactList newContactList, Input input){
        // Write a little code to either print all contacts with numbers for user to choose
        // Delete user choice from list
        ArrayList<Contact> contacts = newContactList.getContacts();
        Print.displayContactsWithIndex(contacts);
        int userChoice = input.getInt(1, contacts.size(), "Enter the number of the contact you wish to delete: ");
        newContactList.deleteContact(contacts.get(userChoice - 1));
        return newContactList;
    }

}
