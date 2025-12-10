package astalakshmi.example;

import java.util.ArrayList;

public class ContactDAO {

    // Store contacts as one string: name|mobile
    ArrayList<String> contacts = new ArrayList<>();

    // Add contact
    public void addContact(String name, String mobile) {
        String contact = name + "|" + mobile;
        contacts.add(contact);
    }

    // Return all contacts
    public ArrayList<String> getAllContacts() {
        return contacts;
    }

    public String searchByMobile(String searchMobile) {
        for (String c : contacts) {
            String[] parts = c.split("\\|");
            String contactMobile = parts[1];

            String mobile = "";
            if (contactMobile.equals(mobile)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<String> searchByName(String searchName) {
        return null;
    }
    }


