import util.FileHandler;
import util.Input;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandlerTest {
    static Input input = new Input();
    public static void main(String[] args) throws IOException {
        FileHandler contactsFile = new FileHandler("contacts", "addContact.txt");
        Scanner scanner = new Scanner(System.in);
        List<String> contacts = contactsFile.readAllContents(); // read all the lines from a file

    do {

        System.out.println("What would you like to do?\n" +
                "\n" +
//                "0 - exit\n" +
                "1 - View All contacts\n" +
                "2 - Add a new contact\n" +
                "3 - Search a contact by name\n" +
                "4 - Delete an existing contact.\n" +
                "5 - Exit\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");

        int option = Integer.parseInt(scanner.nextLine());
        int optionNum = 0;
        switch (option) {
            case 1:
                optionNum = 1;
                System.out.println("View All contacts = " + optionNum);
                System.out.println("Name | " + "Phone number\n" + "---------------------------");
                printAllContacts(contactsFile);
                break;
            case 2:
                optionNum = 2;
                addContacts(contactsFile);
                break;
            case 3:
                optionNum = 3;
                searchContacts(contactsFile);
                break;
            case 4:
                optionNum = 4;
                deleteContacts(contactsFile, contacts);
                break;
            case 5:
                System.out.println(" Goodbye ");
                break;
            default:
                optionNum = Integer.parseInt("Invalid month");
                break;
        }
        System.out.println(optionNum);

        System.out.println("Would you like to continue? y/n");
    }   while (input.yesNo(""));
        System.out.println("Goodbye");
    }

    public static void printAllContacts(FileHandler contactsFile) throws IOException {
        List<String> myFriendsNameAndNumber = contactsFile.readAllContents(); // read all the lines from a file
        for (String names: myFriendsNameAndNumber) {
            String[] numbers = names.split(",");
            System.out.println("Name: " + numbers[0] + " Phone Number: "  + numbers[1]);
        }
    }

    public static void addContacts(FileHandler contactsFile) throws IOException {
        List<String> myContacts = new ArrayList<>();
        System.out.println("Enter contacts name here: ");
        String myContactsName = input.getString("");
        System.out.println("Enter contacts number here:");
        String phoneNumber = input.getString("");
        myContacts.add(myContactsName + "," + phoneNumber);
        contactsFile.writeToFile(myContacts, true);
        printAllContacts(contactsFile);
    }

    public static void searchContacts(FileHandler contactsFile) throws IOException {
        List<String> myContacts = contactsFile.readAllContents(); // read all the lines from a file
        String myContactsName = input.getString("Search name");
        for (String names: myContacts) {
            if(names.contains(myContactsName)){
            System.out.println(names);
            }
        }
    }
//
    public static void deleteContacts(FileHandler contactsFile, List<String> removeContact) throws IOException {
        String removeContactsName = input.getString("Search name to delete");
        if (input.yesNo("Are you sure you want to delete this contact?")) {
            removeContact.removeIf(contact -> contact.contains(removeContactsName));
            System.out.println("Removing: " + removeContactsName);
            contactsFile.writeToFile(removeContact, false);
        }
    }
    
    
    
}