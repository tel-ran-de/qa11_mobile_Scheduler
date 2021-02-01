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
    public void eventCreationTest() {
        app.event().initEventCreation();

        app.event().tapOnPencillButton();

        //fiilEventForm id = info_title_input
        app.event().fillCreationForm("Event");

        //confirmEventCreation
        //isElementPresent
    }


}
