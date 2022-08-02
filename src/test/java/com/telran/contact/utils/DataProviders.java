package com.telran.contact.utils;

import com.telran.contact.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "123-123-123", "kan@gmail.com", "Berlin", "Hello"});
        list.add(new Object[]{"Irina", "Kan", "123-123-123", "kan@gmail.com", "Berlin", "Hello"});
        list.add(new Object[]{"Arina", "Kan", "123-123-123", "kan@gmail.com", "Berlin", "Hello"});
        list.add(new Object[]{"Andreas", "Kan", "123-123-123", "kan@gmail.com", "Berlin", "Hello"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setLastname(split[1])
                    .setTelefon(split[2])
                    .setMail(split[3])
                    .setAdress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    /*@DataProvider
    public Iterator<Object[]> addNewUserNegative(){
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{"juli@gmail.com", "ja"});
        list.add(new Object[]{"juli+1@gmail.com", "ja1"});
        list.add(new Object[]{"juli+2@gmail.com", "ja2"});
        list.add(new Object[]{"juli+3@gmail.com", "ja3"});
        return list.iterator();
    }

     */
}
