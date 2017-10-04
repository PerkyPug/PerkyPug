import util.FileHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class FileHandlerTest {

//    Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter contact name");
//    String contactName = scanner.nextLine();
//        System.out.println("Enter contact number");
//    String phoneNum = scanner.nextLine();
//        contacts.add(contactName + " | " + phoneNum);
    FileHandler contactsFile = new FileHandler("contacts", "addContact.txt");

    ArrayList<String> contents = new ArrayList<>();

    //...
    contactsFile.writeToFile(contents);
}
