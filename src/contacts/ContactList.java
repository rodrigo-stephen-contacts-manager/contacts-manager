package contacts;

import utils.ContactIO;

import java.util.ArrayList;

public class ContactList {

    // INSTANCE VARIABLES ----------------------------------------------------------->
    private ArrayList<Contact> contacts;


    // GETTERS AND SETTERS----------------------------------------------------------->
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    // CONSTRUCTORS ------------------------------------------------------------------->
    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
    // DEFAULT CONSTRUCTOR THAT READS CONTACTLIST FROM TXT FILE ----------------------->
    public ContactList() {
        contacts = new ArrayList<>();
        ArrayList<String> contactStrings = new ArrayList<>();
        contactStrings.addAll(ContactIO.readLines());
        for(String contactString : contactStrings){
            //CONVERTS FROM STRING TO CONTACT, ADDS CONTACT BACK TO CONTACTS........
            contacts.add(convertedToContact(contactString));
        }
    }


    // CRUD METHODS ------------------------------------------------------------------->
    // ADD CONTACT ....................................................................
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    // DELETE CONTACT .................................................................
    public void deleteContact(Contact contact){
        contacts.remove(contact);
    }

    // METHOD THAT WRITES CONTENTS OF CONTACTLIST TO CONTACTS.TXT FILE ---------------->
    public void saveList(){
        ArrayList<String> contactStrings = new ArrayList<>();
        for(Contact contact : contacts){
           contactStrings.add(convertedToString(contact));
        }
        ContactIO.writeLines(contactStrings);
    }

    // METHOD THAT CHECKS TO SEE IF CONTACT ALREADY IN LIST --------------------------->
    public boolean hasContact(String name, Long phoneNumber, String email) {
        for(Contact contact : contacts) {
            if(contact.getName().equalsIgnoreCase(name) && contact.getPhoneNumber().equals(phoneNumber) && contact.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    // METHOD THAT RETURNS LIST OF CONTACTS BY NAME QUERY ----------------------------->
    public ArrayList<Contact> searchContacts(String name){
        ArrayList<Contact> listWithContacts = new ArrayList<>();
        for (Contact contact : contacts){
            if(contact.getName().toUpperCase().contains(name.toUpperCase())) {
               listWithContacts.add(contact);
            }
        }
        return listWithContacts;
    }

    // METHOD THAT CONVERTS STRING TO CONTACT------------------------------------------>
    private Contact convertedToContact(String contactString){
        String[] strSplit = contactString.split("%");
        Contact splitContact = new Contact(strSplit[0],Long.parseLong(strSplit[1]),strSplit[2]);
        return splitContact;
    }
    // METHOD THAT CONVERTS CONTACT TO STRING WITH CORRECT FORMATTING ----------------->
    private String convertedToString(Contact contact){
        String conjoined = (contact.getName() + "%" + contact.getPhoneNumber() + "%" + contact.getEmail());
        return conjoined;
    }


}
