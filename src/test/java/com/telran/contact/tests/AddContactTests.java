package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.tests.TestBase;
import com.telran.contact.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromDataProvider(String name, String lName, String telephone, String mail, String adress, String descr) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastname(lName)
                .setTelefon(telephone)
                .setMail(mail)
                .setAdress(adress)
                .setDescription(descr));
        app.getContact().clickOnSaveButtonWithAction();

    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class,enabled = false)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButtonWithAction();
    }

    @AfterMethod()
    public void postCondition() {
        app.getContact().removeContact();
    }

}
