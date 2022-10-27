import contacts.Contact;
import contacts.ContactList;
import utils.Input;
import utils.Print;

public class userOptionMethods {
    public static void viewContacts(ContactList newContactList){
        Print.displayContacts(newContactList);
    }
    public static ContactList addContact(ContactList newContactList, Input input){
        String name = input.getString("Enter a name:");
        Long phoneNumber = input.getPhoneNumber("Enter a phone number:");
        String email = input.getString("Enter an email:");
        // Write a method that takes user input and converts it to a Contact
        // Once we have the contact object, we will call the method addContact()
        Contact contact = new Contact(name,phoneNumber,email);
        newContactList.addContact(contact);
        return newContactList;
    }
    public static void searchContact(ContactList newContactList, Input input){
        Contact searchedContact = newContactList.searchContacts(input.getString("Enter a name to search for the contact: "));
        // Write method to print single contact on screen

    }
    public static ContactList deleteContact(ContactList newContactList, Input input){
        // Write a little code to either print all contacts with numbers for user to choose
        // Delete user choice from list
        return newContactList;
    }

}
