package com.address.booksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public ArrayList<personDetails> contactList = new ArrayList<personDetails>();

    public void writeData() {
        StringBuffer empBuffer = new StringBuffer();
        contactList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get("addressBook-file.txt"), empBuffer.toString().getBytes());

        } catch (IOException e) {

        }
    }

    public void readData() {
        try {
            Files.lines(new File("addressBook-file.txt").toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));

        } catch (IOException e) {

        }
    }

    public void addContact(){
        System.out.println("Enter the contact details.....");
        int i = 0;
        String firstName=null;
        while (i == 0){
            System.out.println("Enter the first name: ");
            firstName = sc.next();
            if (checkExists(firstName)){
                System.out.println("Name already exists..");
            }
            else {
                i = 1;
            }
        }



        System.out.println("Enter the last name: ");
        String lastName = sc.next();
        System.out.println("Enter the address: ");
        String address = sc.next();
        System.out.println("Enter the city: ");
        String city = sc.next();
        System.out.println("Enter the state: ");
        String state = sc.next();
        System.out.println("Enter the zip code: ");
        String zip = sc.next();
        System.out.println("Enter the email: ");
        String email = sc.next();
        System.out.println("Enter the phone no: ");
        String phoneNumber = sc.next();

        contactList.add(new personDetails(firstName,lastName,address,city,state,zip,email,phoneNumber));

    }

    public void displayRecord()
    {
        if (contactList.isEmpty())
        {
            System.out.println("No Records!!!");
        }
        else {
            for (personDetails contact : contactList) {
                System.out.println(contact);
            }
        }

    }

    public boolean editContact(String Name)
    {
        int flag = 0;
        for(personDetails contact: contactList)
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
    public boolean deleteContact(String name) {
        int flag = 0;
        for(personDetails contact: contactList)
        {
            if(contact.getFirstName().equals(name))
            {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    public boolean checkExists(String name)
    {
        int flag=0;
        for (personDetails contact: contactList)
        {
            if (contact.getFirstName().equals(name))
            {
                flag=1;
                break;
            }
        }
        if (flag==1)
        {
            return true;
        }
        return false;
    }

    public void sortPersonDetails() {
        int i = 0;
        while (i == 0) {
            System.out.println("Person details sort by :\n" + "1. City\n" + "2. State\n" + "3. Name\n" + "4. Zip");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Sort.sortPersonByCity(contactList);
                    break;
                case 2:
                    Sort.sortPersonByState(contactList);
                    break;
                case 3:
                    Sort.sortByPersonName(contactList);
                    break;
                case 4:
                    Sort.sortByZip(contactList);
                    break;
                case 5:
                    i=1;
                    break;
                default:
                    System.out.println("Enter valid option....");
            }
        }
    }
}



