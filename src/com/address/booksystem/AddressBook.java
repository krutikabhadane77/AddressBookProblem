package com.address.booksystem;

import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public ArrayList<Details> contactList = new ArrayList<>();

    public void addContact(){
        System.out.println("Enter the contact details:");
        String firstName = sc.next();
        String lastName = sc.next();
        String address = sc.next();
        String city = sc.next();
        String state = sc.next();
        String zip = sc.next();
        String email = sc.next();
        String phoneNumber = sc.next();

        Details contactDetails = new Details(firstName, lastName, address, city, state, zip, email, phoneNumber);
        contactList.add(contactDetails);

    }

    public boolean editContact(String Name)
    {
        int flag = 0;
        for(Details contact: contactList)
        {
            if(contact.getFirstName().equals(Name))
            {
                System.out.println("Enter the detail which needs to be updated:");

                int ch = sc.nextInt();
                switch(ch)
                {
                    case 1:
                    {
                        System.out.println("Enter First Name: ");
                        String firstName = sc.next();
                        contact.setFirstName(firstName);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter last name: ");
                        String lastName = sc.next();
                        contact.setLastName(lastName);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter Address: ");
                        String address = sc.next();
                        contact.setAddress(address);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter City: ");
                        String city = sc.next();
                        contact.setCity(city);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter State: ");
                        String state =sc.next();
                        contact.setState(state);
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter Zip Code: ");
                        String zip = sc.next();
                        contact.setZip(zip);
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Enter Phone Number:");
                        String phoneNumber = sc.next();
                        contact.setPhoneNumber(phoneNumber);
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Enter Email: ");
                        String email = sc.next();
                        contact.setEmail(email);
                        break;
                    }

                }

                flag = 1;
                break;
            }
        }
        return flag == 1;
    }
}