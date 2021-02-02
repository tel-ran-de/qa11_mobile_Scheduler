package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.event().isIconSortOptionsPresent()) {
            app.user().login(new User().email("Neuer@gmail.com").password("Neuer2021"));
        }
    }

    @Test
    public void eventCreationTest() throws InterruptedException {
        app.event().initEventCreation();

        app.event().tapOnPencillButton();
        Thread.sleep(10000);

        app.event().fillCreationForm("Event", "1", 3, "50");

        app.event().save();

        //isElementPresent
    }

    @Test
    public void eventCreationChangeDataTest() throws InterruptedException {
        app.event().initEventCreation();

        app.event().tapOnPencillButton();
        Thread.sleep(10000);

        app.event().selectDate("past","FEBRUARY","1");

        app.event().fillCreationForm("Event", "1", 0, "50");

        app.event().save();

        Assert.assertTrue(app.event().isEventPresent());

        //isElementPresent
    }


}
