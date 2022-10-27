package utils;

import contacts.Contact;
import contacts.ContactList;

import java.util.ArrayList;

public class Print {

    // Constructors
    public Print() {
    }

    // Methods
    //METHOD TO PRINT APPLICATION------------------------------------>
    public static void appOptions(){
        System.out.println("""
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):
                        """);
    }

    // METHOD TO PRINT ALL CONTACTS -------------------------------->

    public static void displayContacts(ArrayList<Contact> contacts) {
        System.out.println("Name                          | Phone number | Email");
        System.out.println("------------------------------+--------------+------------------------------");
        for (Contact contact : contacts) {
            System.out.printf("%-30s|  %10s  | %s%n",contact.getName(),contact.getPhoneNumber(),contact.getEmail());
        }
    }

    public static void displayContactsWithIndex(ArrayList<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.printf("%d: %-30s|  %10s  | %s%n", (i + 1), contact.getName(),contact.getPhoneNumber(),contact.getEmail());
        }
    }

}
