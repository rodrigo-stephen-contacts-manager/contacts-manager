package contacts;

import utils.ContactIO;

import java.util.ArrayList;

public class ContactList {

    // Instance variables
    private ArrayList<Contact> contacts;


    // GETTERS AND SETTERS--------------------------------->
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    // Constructors
    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }



    // Methods
    // INITIALIZE LIST------------------------------------------>
    public ContactList() {
        ArrayList<String> contactStrings = new ArrayList<>();
        contactStrings.addAll(ContactIO.readLines());
        for(String contactString : contactStrings){
            //CONVERTS FROM STRING TO CONTACT, ADDS CONTACT BACK TO CONTACTS........
            contacts.add(convertedToContact(contactString));
        }
    }

    //METHOD THAT CONVERTS STRING TO CONTACT--------------------->
    private Contact convertedToContact(String contactString){
        String[] strSplit = contactString.split("%");
        Contact splitContact = new Contact(strSplit[0],Long.parseLong(strSplit[1]),strSplit[2]);
        return splitContact;
    }

    // Save list
    // TAKING CONTACTS ARRAY AND WRITING IT TO THE CONTACTS.TXT-------------------->
    private String convertedToString(Contact contact){
        String conjoined = (contact.getName() + "%" + contact.getPhoneNumber() + "%" + contact.getEmail());
        return conjoined;
    }




    // CRUD Methods
    // Add contact

    // Get all contacts

    // Update contact

    // Delete contact

    // Other methods
    // Get contact by name

    // Check if contact exists by name

}
