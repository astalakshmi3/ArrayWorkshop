package astalakshmi.example;

import java.util.Scanner;

public class ContactArray {


       // public static class ContatcManagementAppImpl {

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String[] contactArray = new String[10];
                int numberOfContacts = 0;
                while (true) {
                    System.out.println("==== Contact Management App ====");
                    System.out.println("1. Add Contact");
                    System.out.println("2. Find a Contact");
                    System.out.println("3. List all Contacts");
                    System.out.println("4. Delete a Contact");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int input = sc.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println("-----Creating a Contact-----");
                            numberOfContacts = createContact(contactArray,numberOfContacts,sc);
                            break;
                        case 2:
                            System.out.println("------Finding a contact-----");
                            findContact(contactArray,numberOfContacts,sc);
                            break;
                        case 3:
                            listAllContact(contactArray,numberOfContacts);
                            break;
                        case 4:
                            numberOfContacts = deleteContact(contactArray,numberOfContacts,sc);
                            break;
                        case 5:
                            System.out.println("Exit");
                            return;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }

            }

            public static int createContact(String[] contactArray, int arraySize, Scanner sc){
                // resizing the array, if its full (since we dont have dynamic resizing in array - we need to manually resize it when its full)
                if (arraySize == contactArray.length) {
                    String[] newArr = new String[contactArray.length * 2];
                    for (int i = 0; i < contactArray.length; i++) {
                        newArr[i] = contactArray[i];
                    }
                    contactArray = newArr;
                }
                for (int i = arraySize; i < contactArray.length; i++) {
                    System.out.println("Name : ");
                    String name = sc.next();
                    System.out.println("Phone Number : ");
                    String phoneNumber = sc.next();
                    contactArray[i] = name + "|" + phoneNumber;
                    System.out.println("Contact Created ==> " + contactArray[i]);
                    arraySize++;
                    System.out.println("Do you want to continue creating contact ? ( Yes / No )");
                    String choice = sc.next();
                    if (!choice.equalsIgnoreCase("Yes")) {
                        break;
                    }
                    // If array is now full, resize again
                    if (arraySize == contactArray.length) {
                        String[] newArr2 = new String[contactArray.length * 2];
                        for (int j = 0; j < contactArray.length; j++) {
                            newArr2[j] = contactArray[j];
                        }
                        contactArray = newArr2;
                    }
                }
                return arraySize;
            }

            public static void findContact(String[] contactArray, int arraySize, Scanner sc){
                System.out.println("Enter name or number to find : ");
                String choice = sc.next();
                boolean found = false;
                for (int i = 0; i < arraySize; i++) {
                    if (contactArray[i] != null && contactArray[i].contains(choice)) {
                        System.out.println("Found from Repository --  " + contactArray[i]);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Cannot find the contact in the repository");
                }
            }

            public static void listAllContact(String[] contactArray, int arraySize){
                if (arraySize == 0) {
                    System.out.println("No contacts in the repository.");
                    return;
                }else {
                    System.out.println("List of Contacts stored in the repository.");
                    for (int i = 0; i < arraySize; i++) {
                        System.out.println((i + 1) + ". " + contactArray[i]);
                    }
                }
            }

            public static int deleteContact(String[] contactArray, int arraySize, Scanner sc) {
                System.out.println("Enter name or phone number to delete : ");
                String choiceToDelete = sc.next();
                int index = -1;
                for (int i = 0; i < arraySize; i++) {
                    if (contactArray[i] != null && contactArray[i].contains(choiceToDelete)) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    System.out.println("Cannot find the contact in the repository to delete");
                    return arraySize;
                }

                System.out.println("Deleting: " + contactArray[index]);

                if (arraySize > 0 && index >= 0 && index < arraySize) {
                    for (int i = index; i < arraySize - 1; i++) {
                        contactArray[i] = contactArray[i + 1];
                    }
                    contactArray[arraySize - 1] = null;
                    arraySize--;
                }
                return arraySize;
            }
        }
