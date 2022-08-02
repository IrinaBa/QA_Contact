package com.telran.contact.models;

public class Contact {
    private  String name;
    private  String lastname;
    private  String telefon;
    private  String mail;
    private  String adress;
    private  String description;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Contact setTelefon(String telefon) {
        this.telefon = telefon;
        return this;
    }

    public Contact setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Contact setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
}

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getTelefon() {
        return telefon;
    }
    public String getMail() {
        return mail;
    }
    public String getAdress() {
        return adress;
    }
    public String getDescription() {
        return description;
    }
}
