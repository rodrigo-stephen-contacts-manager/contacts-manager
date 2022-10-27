import contacts.Contact;
import contacts.ContactList;
import utils.Input;
import utils.Print;

public class ContactManagerApplication {

    private static void runApplication() {
        // Initial read of the file to populate the contact list
        Input input = new Input();
        ContactList newContactList = new ContactList();
        int userChoice;
        do {
            Print.appOptions();
            userChoice = input.getInt(1, 5);
            switch (userChoice) {
                case 1:
                    userOptionMethods.viewContacts(newContactList);
                    break;
                case 2:
                    newContactList = userOptionMethods.addContact(newContactList, input);
                    break;
                case 3:
                    userOptionMethods.searchContact(newContactList, input);
                    break;
                case 4:
                    newContactList = userOptionMethods.deleteContact(newContactList, input);
                    break;
                default:
                    break;
            }


        } while(!(userChoice == 5));
        // print out options and run the application

        // when user finishes, ask if they want to save
        // and save if the user wants to
        if(input.yesNo("Do you wish to save the changes you made? Y|N: ")) {
            newContactList.saveList();
        }
    }

    public static void main(String[] args) {
        runApplication();
    }
}
