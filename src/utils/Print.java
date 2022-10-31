package utils;

import contacts.Contact;
import contacts.ContactList;

import java.util.ArrayList;

public class Print {

    // Constructors
    public Print() {
    }

    // Methods
    //METHOD TO PRINT APPLICATION options------------------------------------>
    public static void appOptions(){
        System.out.print("""
                
                1. View contacts
                2. Add a new contact
                3. Search a contact by name
                4. Delete an existing contact
                5. Exit
                
                """);
    }

    // METHOD TO PRINT LIST OF CONTACTS -------------------------------->

    public static void displayContacts(ArrayList<Contact> contacts) {
        System.out.printf("%n             Name             |  Phone number  | Email%n");
        System.out.println("------------------------------+----------------+----------------------------");
        for (Contact contact : contacts) {
            System.out.printf("%-30s|  %-12s  | %s%n", contact.getName(), formatPhoneNumber(contact.getPhoneNumber()), contact.getEmail());
        }
        System.out.printf("------------------------------+----------------+----------------------------%n%n");
    }

    // METHOD TO PRINT LIST OF CONTACTS WITH INDEX NUMBERS --------------->
    public static void displayContactsWithIndex(ArrayList<Contact> contacts) {
        System.out.printf("%n----------------------------------------------------------------------------%n");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.printf("%d: %-30s|  %-12s  | %s%n", (i + 1), contact.getName(), formatPhoneNumber(contact.getPhoneNumber()), contact.getEmail());
        }
        System.out.printf("----------------------------------------------------------------------------%n%n");
    }

    // METHOD TO FORMAT PHONE NUMBER BY ADDING DASHES -------------------->
    private static String formatPhoneNumber(long phoneNumber) {
        String formattedNumber = "";
        String uglyNumber = Long.toString(phoneNumber);
        for(int i = 0; i < uglyNumber.length(); i++) {
            formattedNumber += uglyNumber.charAt(i);
            if(i == 2 || (i == 5 && uglyNumber.length() > 7)) {
                formattedNumber += "-";
            }
        }
        return formattedNumber;
    }
}
