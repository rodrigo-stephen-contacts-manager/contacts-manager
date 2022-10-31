import contacts.Contact;
import contacts.ContactList;
import utils.Input;
import utils.Print;

import java.util.ArrayList;

public class userOptionMethods {

    // METHOD TO DISPLAY ALL CONTACTS IN CONTACTLIST --------------------------------->
    public static void viewContacts(ContactList contactList){
        Print.displayContacts(contactList.getContacts());
    }

    // METHOD TO ADD A CONTACT TO CONTACTLIST ---------------------------------------->
    public static ContactList addContact(ContactList contactList, Input input){
        System.out.printf("%n------------------------------%nAdding Contact%n------------------------------%n%n");
        String name = input.getString("Enter a name: ");
        Long phoneNumber = input.getPhoneNumber("Enter a phone number (only numbers, 7 or 10 digits accepted): ");
        String email = input.getString("Enter an email: ");
        if(!contactList.hasContact(name, phoneNumber, email)) {
            Contact contact = new Contact(name, phoneNumber, email);
            contactList.addContact(contact);
            System.out.printf("%n------------------------------%nContact Successfully Added%n------------------------------%n%n");
        } else {
            if (input.yesNo("Contact already exists. Do you wish to add a different contact? Y|N: ")) {
                return addContact(contactList, input);
            }
            System.out.printf("%n");
        }
        return contactList;
    }

    // METHOD TO SEARCH FOR CONTACT BY NAME AND DISPLAY LIST OF RESULTS ------------------------------>
    public static void searchContact(ContactList contactList, Input input){
        ArrayList<Contact> searchedContactList = contactList.searchContacts(input.getString("Enter a name to search for the contact: "));
        Print.displayContacts(searchedContactList);
    }

    // METHOD TO DELETE CONTACT FROM CONTACTLIST ----------------------------------------------------->
    public static ContactList deleteContact(ContactList contactList, Input input){
        ArrayList<Contact> contacts = contactList.getContacts();
        Print.displayContactsWithIndex(contacts);
        int userChoice = input.getInt(1, contacts.size(), "Enter the number of the contact you wish to delete: ");
        contactList.deleteContact(contacts.get(userChoice - 1));
        return contactList;
    }
}
