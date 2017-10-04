package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private String directory;
    private String filename;

    //don't forget to handle the exceptions

    public FileHandler(String directory, String filename){
        this.directory = directory;
        this.filename = filename;
    }

    public void writeToFile(List<String> contents) {
        try {
            Files.write(Paths.get(directory, filename), contents);
        }
        catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException{

    // Path to resources/info.txt
        Path path = Paths.get("contacts", "addContact.txt");       // files
        System.out.println(path.toAbsolutePath());

        if (!Files.exists(path.getParent())) {
            Files.createDirectory(path.getParent());
        }
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        // Helper methods // static methods
        //List<String> groceries = Arrays.asList("coffee,3", "tea,5", "sugar,6");
        List<String> contacts = new ArrayList<>();
//        contacts.add("coffee,3");
//        contacts.add("tea,4");
//        contacts.add("sugar,5");

        // serialization  object -> text / deserialization text -> object

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contact name");
        String contactName = scanner.nextLine();
        System.out.println("Enter contact number");
        String phoneNum = scanner.nextLine();
        contacts.add(contactName + " | " + phoneNum);

        Files.write(path, contacts, StandardOpenOption.APPEND);  // write several lines to a file

//        Create a method for retrieving file contents as a List of Strings

        List<String> mySavedContacts = Files.readAllLines(path); // read all the lines from a file
        System.out.println("Name | Phone number\n" +
                "---------------\n " + mySavedContacts + "\n");

    }


}
