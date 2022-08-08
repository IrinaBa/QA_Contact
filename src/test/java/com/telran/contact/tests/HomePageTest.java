package com.telran.contact.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{

    @Test
    public void openHomePage(){
        System.out.println("Site is opened!");

       // System.out.println("Component Form: "+ isComponentFormPresent());
        //isElementFormPresent(By.cssSelector("div:nth-child(2)>div>div"));



    }@Test
    public void headerPhonebook(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
    }
    //a[contains(text(),'')]
    @Test
    public void headerHome(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//a[contains(text(),'HOME')]")));
    }@Test
    public void headerAbout(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//a[contains(text(),'ABOUT')]")));
    }@Test
    public void headerLogin(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//a[contains(text(),'LOGIN')]")));
    }
}
