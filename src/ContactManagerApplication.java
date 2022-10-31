import contacts.Contact;
import contacts.ContactList;
import utils.Input;
import utils.Print;

public class ContactManagerApplication {

    // METHOD THAT INSTANTIATES INPUT AND CONTACT LIST
    // ALSO CONTAINS MAIN DO/WHILE LOOP FOR CLI OPTIONS --------------------->
    private static void runApplication() {
        // Initial read of the file to populate the contact list
        Input input = new Input();
        ContactList contactList = new ContactList();
        int userChoice;
        do {
            Print.appOptions();
            userChoice = input.getInt(1, 5, "Enter option: ");
            switch (userChoice) {
                case 1 -> userOptionMethods.viewContacts(contactList);
                case 2 -> contactList = userOptionMethods.addContact(contactList, input);
                case 3 -> userOptionMethods.searchContact(contactList, input);
                case 4 -> contactList = userOptionMethods.deleteContact(contactList, input);
                default -> {
                }
            }

        } while(!(userChoice == 5));
        // print out options and run the application

        // when user finishes, ask if they want to save
        // and save if the user wants to
        if(input.yesNo("Do you wish to save the changes you made? Y|N: ")) {
            contactList.saveList();
            System.out.printf("%nAll Changes Saved%n");
        } else {
            System.out.printf("%nAll Changes Discarded%n");
        }
    }

    // MAIN METHOD --------------------------------------------------------------->
    public static void main(String[] args) {
        runApplication();
    }
}
