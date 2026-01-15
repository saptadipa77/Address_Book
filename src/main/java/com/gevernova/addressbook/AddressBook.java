package com.gevernova.addressbook;
import java.util.*;
public class AddressBook {
    private List<Contact> contactList = new ArrayList<>();
    public void addContact(Contact contact) {

            contactList.add(contact);
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
    public List<Contact> getContactList() {
        return contactList;
    }
}
