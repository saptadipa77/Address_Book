package com.gevernova.addressbook;
import java.util.*;
public class AddressBook {
    private List<Contact> contactList = new ArrayList<>();
    public void addContact(Contact contact) {

            contactList.add(contact);
    }
    public List<Contact> getContactList() {
        return contactList;
    }
}
