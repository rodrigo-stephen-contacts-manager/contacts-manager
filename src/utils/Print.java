package utils;

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
    public static void displayContacts() {
        System.out.println("Name | Phone number | Email");
        for (String contactInfo : ContactIO.readLines()) {
            System.out.printf("%s",contactInfo);
        }
    }
    // Method to print single contact

}
