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
            System.out.println("3. Search Contact");
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

                case 3:
                    System.out.println("Search Menu");
                    System.out.println("1. Search by Name");
                    System.out.println("2. Search by Mobile number");
                    System.out.print("Choose: ");

                    int searchOption = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    if (searchOption == 1) {
                        System.out.print("Enter the name: ");
                        String searchName = sc.nextLine();

                        ArrayList<String> results = dao.searchByName(searchName);

                        if (results.isEmpty()) {
                            System.out.println("Not Found\n");
                        } else {
                            for (String c : results) {
                                System.out.println("Found: " + c);
                            }
                            System.out.println();
                        }

                    } else if (searchOption == 2) {
                        System.out.print("Enter mobile to search: ");
                        String searchMobile = sc.nextLine();

                        String found = dao.searchByMobile(searchMobile);

                        if (found == null) {
                            System.out.println("No contact found.\n");
                        } else {
                            System.out.println("Found: " + found + "\n");
                        }

                    } else {
                        System.out.println("Invalid search option.\n");
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
