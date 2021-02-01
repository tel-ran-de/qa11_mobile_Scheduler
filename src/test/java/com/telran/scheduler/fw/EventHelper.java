package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EventHelper extends HelperBase{

    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isIconSortOptionsPresent() {
        return isElementPresent(By
                .xpath("//*[@recourse-id='com.example.svetlana.scheduler:id/sort_options']"));
    }

    public void initEventCreation() {
        tap(By.id("fab_main"));
    }

    public void tapOnPencillButton() {
        tap(By.id("fab_add_event"));
    }

    public void fillCreationForm(String eventTitle) {

        type(By.id("info_title_input"), eventTitle);
    }
}
