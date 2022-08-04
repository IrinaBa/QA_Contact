package com.telran.contact.fw;

import com.telran.contact.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:contacts) {
            if(el.getText().contains(text))
                return true;
        }
        return false;
    }

    public void addContact() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        fillContactForm(new Contact()
                .setName("Irina")
                .setLastname("Lagerfeld")
                .setTelefon("115-20-167" + i)
                .setMail("Karl" + i + "@gmail.com")
                .setAdress("Berlin")
                .setDescription("Karl - krasavchik"));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contacts) {
        type(By.cssSelector("input:nth-child(1)"), contacts.getName());
        type(By.cssSelector("input:nth-child(2)"), contacts.getLastname());
        type(By.cssSelector("input:nth-child(3)"), contacts.getTelefon());
        type(By.cssSelector("input:nth-child(4)"), contacts.getMail());
        type(By.cssSelector("input:nth-child(5)"), contacts.getAdress());
        type(By.cssSelector("input:nth-child(6)"), contacts.getDescription());
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));

    }

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }return 0;
    }

    public void removeContact() {
        if(!isContactListEmpty()){
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[contains(.,'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }
    public void clickOnAddLink(){
        click(By.xpath("//a[contains(text(),'ADD')]"));
    }public void clickOnSaveButtonWithAction() {
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }
}
