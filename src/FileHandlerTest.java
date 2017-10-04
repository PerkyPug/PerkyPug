import util.FileHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandlerTest {
    public static void main(String[] args) throws IOException {
        FileHandler contactsFile = new FileHandler("contacts", "contacts.txt");
        List<String> myContacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contacts name here: ");
        String myContactsName = scanner.nextLine();
        System.out.println("Enter contacts number here:");
        String phoneNumber = scanner.nextLine();
        myContacts.add(myContactsName + "," + phoneNumber);
        contactsFile.writeToFile(myContacts);
        printAllContacts(contactsFile);
    }
    public static void printAllContacts(FileHandler contactsFile) throws IOException {
        List<String> myFriendsNameAndNumber = contactsFile.readAllContents(); // read all the lines from a file
        for (String names: myFriendsNameAndNumber) {
            String[] numbers = names.split(",");
            System.out.println("Name: " + numbers[0] + " Phone Number: "  + numbers[1]);
        }
    }
}