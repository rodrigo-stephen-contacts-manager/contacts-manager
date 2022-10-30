import contacts.Contact;
import contacts.ContactList;
import utils.Input;
import utils.Print;

import java.util.ArrayList;

public class userOptionMethods {

    // METHOD TO DISPLAY ALL CONTACTS IN CONTACTLIST --------------------------------->
    public static void viewContacts(ContactList newContactList){
        Print.displayContacts(newContactList.getContacts());
    }

    // METHOD TO ADD A CONTACT TO CONTACTLIST ---------------------------------------->
    public static ContactList addContact(ContactList newContactList, Input input){
        System.out.printf("%n------------------------------%nAdding Contact%n------------------------------%n");
        String name = input.getString("Enter a name:");
        Long phoneNumber = input.getPhoneNumber("Enter a phone number:");
        String email = input.getString("Enter an email:");
        if(!newContactList.hasContact(name, phoneNumber, email)) {
            Contact contact = new Contact(name, phoneNumber, email);
            newContactList.addContact(contact);
            System.out.printf("------------------------------%nContact Successfully Added%n------------------------------%n%n");
        } else {
            if (input.yesNo("Contact already exists. Do you wish to add a different contact? Y|N: ")) {
                return addContact(newContactList, input);
            }
            System.out.printf("%n");
        }
        return newContactList;
    }

    // METHOD TO SEARCH FOR CONTACT BY NAME AND DISPLAY LIST OF RESULTS ------------------------------>
    public static void searchContact(ContactList newContactList, Input input){
        ArrayList<Contact> searchedContactList = newContactList.searchContacts(input.getString("Enter a name to search for the contact: "));
        Print.displayContacts(searchedContactList);
    }

    // METHOD TO DELETE CONTACT FROM CONTACTLIST ----------------------------------------------------->
    public static ContactList deleteContact(ContactList newContactList, Input input){
        ArrayList<Contact> contacts = newContactList.getContacts();
        Print.displayContactsWithIndex(contacts);
        int userChoice = input.getInt(1, contacts.size(), "Enter the number of the contact you wish to delete: ");
        newContactList.deleteContact(contacts.get(userChoice - 1));
        return newContactList;
    }
}
