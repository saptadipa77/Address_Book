package com.gevernova.addressbook;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
   public static void main(String[] args) {
       System.out.println("Welcome to the address book");
       while (true) {
           System.out.println("\n--- MAIN MENU ---");

           System.out.println("1. Add Contact to Book");
           System.out.println("2.Edit Contact");
           System.out.println("3.Delete Contact");
           System.out.println("4.View Contacts in AddressBook");
           System.out.println("5.Add multiple AddressBooks to the system");
           System.out.println("6.Search Person by location");
           System.out.println("7.View Persons by location");
           System.out.println("8.Count Persons by location");
           System.out.println("9.Sort entries by Person's name");
           Scanner sc = new Scanner(System.in);
           int choice = sc.nextInt();
           AddressBook obj = new AddressBook();

           switch (choice) {

               case 1:{
                   String firstName, lastName, address, city, state, email;
                   int zip, phoneNumber;
                   System.out.println("Enter First Name:");
                   firstName = sc.next();
                   System.out.println("Enter Last Name:");
                   lastName = sc.next();
                   System.out.println("Enter Address:");
                   address = sc.next();
                   System.out.println("Enter City:");
                   city = sc.next();
                   System.out.println("Enter State:");
                   state = sc.next();
                   System.out.println("Enter Email:");
                   email = sc.next();
                   System.out.println("Enter Zip Code:");
                   zip = sc.nextInt();
                   System.out.println("Enter Phone Number:");
                   phoneNumber = sc.nextInt();
                   obj.addContact(new Contact(firstName,lastName,address,city,state,email,zip,phoneNumber));
               }

               case 2:{
                   String firstName;
                   firstName = sc.next();
                   obj.editContact(firstName,sc);
               }

               case 3:{
                   String firstName;
                   firstName = sc.next();
                   obj.deleteContact(firstName);
               }

               case 4:{
                   obj.getContactList();
               }

               case 5:{
                   System.out.print("Name: ");
                   addressBookMap.put(sc.next(), new AddressBook());
               }

               case 6:{

                   System.out.print("Enter location: ");
                   String loc = sc.next();
                   addressBookMap.values().stream()
                               .flatMap(book -> book.getContactList().stream())
                               .filter(c -> c.getCity().equalsIgnoreCase(loc) || c.getState().equalsIgnoreCase(loc))
                               .forEach(System.out::println);

               }
               case 7:{
                   Map<String, List<Contact>> cityView = addressBookMap.values().stream()
                           .flatMap(book -> book.getContactList().stream())
                           .collect(Collectors.groupingBy(Contact::getCity));
                   cityView.forEach((city, list) -> System.out.println(city + ": " + list));
               }
               case 8:{
                   System.out.print("Enter location to count: ");
                   String loc = sc.next();
                   long count = addressBookMap.values().stream()
                           .flatMap(book -> book.getContactList().stream())
                           .filter(c -> c.getCity().equalsIgnoreCase(loc) || c.getState().equalsIgnoreCase(loc))
                           .count();
                   System.out.println("Total: " + count);
               }

               case 9:{
                   System.out.println("Enter your choice of sorting category");
                   int ch=sc.nextInt();
                   obj.sortEntries(ch);
               }

               default:{
                   System.out.println("Invalid choice.");
               }
           }
       }
   }
   }

