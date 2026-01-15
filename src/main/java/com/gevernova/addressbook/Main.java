package com.gevernova.addressbook;
import java.util.*;
public class Main {
   public static void main(String[] args) {
       System.out.println("Welcome to the address book");
       while (true) {
           System.out.println("\n--- MAIN MENU ---");

           System.out.println("1. Add Contact to Book");
           System.out.println("2.Edit Contact");
           System.out.println("3.Delete Contact");
           System.out.println("4.View Contacts in AddressBook");
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
               default:{
                   System.out.println("Invalid choice.");
               }
           }
       }
   }
   }

