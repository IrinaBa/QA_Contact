package com.telran.contact.tests;

import com.telran.contact.models.User;
import com.telran.contact.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatAccountTest extends TestBase {
    //precondition: user should be slogged out

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

    }

    @Test
    public void registrationPositiveTest() {
        //click on the link LOGIN
        app.getUser().registration();
        //assert the button Sign out display
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test
    public void registrationNegativeTestWithInvalidEmail() {
        app.getUser().registrationNegative();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
