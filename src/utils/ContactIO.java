package utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContactIO {

    // INSTANCE VARIABLES--------------------------------------->
    private final static Path CONTACTSPATH = Paths.get("data","contacts.txt");
    // Getters and Setters

    public Path getContactsPath() {
        return CONTACTSPATH;
    }

    // CONSTRUCTORS--------------------------------------------->
    public ContactIO() {
    }


    // CRUD METHODS------------------------------------------->
    // READ................................
        public static List<String> readLines() {
        List<String> contacts;
        try {
            contacts = Files.readAllLines(CONTACTSPATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }


    // ADD.........................................
        public static void addLines(List<String> lines) {
        try {
            Files.write(CONTACTSPATH, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeLines(List<String> lines) {
        try {
            Files.write(CONTACTSPATH, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // UPDATE....................................
//    private static void updateContact(String contactToUpdate) {
//        List<String> updatedContact = new ArrayList<>();
//        for (String name : readLines()) {
//            if (name.equalsIgnoreCase(contactToUpdate)) {
//                updatedContact.add(name);
//            }
//        }
//        writeLines(updatedContact);
//    }

     //DELETE....................................
        private static void deleteContact(String contactToDelete) {
        List<String> updatedContacts = new ArrayList<>();
        for (String name : readLines()) {
            if (!name.equalsIgnoreCase(contactToDelete)) {
                updatedContacts.add(name);
            }
        }
        addLines(updatedContacts);
    }

}
