package com.gevernova.addressbook;
import java.util.*;
public class AddressBook {
    private List<Contact> contactList = new ArrayList<>();
    public void addContact(Contact contact) {

        if (contactList.stream().anyMatch(c -> c.equals(contact))) { // UC 7 [cite: 42, 44]
            System.out.println("Contact already exists.");
        } else {
            contactList.add(contact);
        }
    }

    public void editContact(String name, Scanner sc) {
        contactList.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(c -> {
                    System.out.println("Enter new City:");
                    c.setCity(sc.next());
                    System.out.println("Contact updated.");
                }, () -> System.out.println("Contact not found."));
    }
    public void deleteContact(String name) {
        contactList.removeIf(c -> c.getFirstName().equalsIgnoreCase(name));
    }
    public List<Contact> getContactList() {
        return contactList;
    }

    public void sortEntries(int choice) {
        Comparator<Contact> comp = switch (choice) {
            case 1 -> Comparator.comparing(Contact::getFirstName);
            case 2 -> Comparator.comparing(Contact::getCity);      // UC 12
            case 3 -> Comparator.comparing(Contact::getState);     // UC 12
            case 4 -> Comparator.comparing(Contact::getZip);       // UC 12
            default -> Comparator.comparing(Contact::getFirstName);
        };
        contactList.stream().sorted(comp).forEach(System.out::println);
    }
}
