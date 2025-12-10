package astalakshmi.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactDAO dao = new ContactDAO();

        while (true) {

            System.out.println("=== Contact Management ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Mobile: ");
                    String mobile = sc.nextLine();

                    dao.addContact(name, mobile);
                    System.out.println("Contact added!\n");
                    break;

                case 2:
                    ArrayList<String> allContacts = dao.getAllContacts();

                    if (allContacts.isEmpty()) {
                        System.out.println("No contacts yet.\n");
                    } else {
                        System.out.println("All Contacts:");
                        for (String c : allContacts) {
                            System.out.println(c);  // prints name|mobile
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }
}
