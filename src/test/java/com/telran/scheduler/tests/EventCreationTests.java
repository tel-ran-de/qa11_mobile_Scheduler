package com.telran.scheduler.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.event().isIconSortOptionsPresent()) {
            app.user().login("Neuer@gmail.com", "Neuer2021");
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

        app.event().selectDate();

        app.event().fillCreationForm("Event", "1", 3, "50");

        app.event().save();

        //isElementPresent
    }


}
