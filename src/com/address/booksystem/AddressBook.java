package com.address.booksystem;

import java.util.ArrayList;

public class AddressBook {

    public ArrayList<Details> contactList = new ArrayList<>();

    public  ArrayList<Details> contactList(Details d){
        contactList.add(d);
        return contactList;
    }

}