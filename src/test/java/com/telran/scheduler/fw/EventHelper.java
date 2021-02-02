package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class EventHelper extends HelperBase {

    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isIconSortOptionsPresent() {
        return isElementPresent(By
                .xpath("//*[@resource-id='com.example.svetlana.scheduler:id/nav_list_fr_fab_container']"));
    }

    public void initEventCreation() {
        tap(By.id("fab_main"));
    }

    public void tapOnPencillButton() {
        tap(By.id("fab_add_event"));
    }

    public void fillCreationForm(String eventTitle, String type, int breaks, String wage) {

        swipeRightToLeft();

        type(By.id("info_title_input"), eventTitle);
        type(By.id("info_type_input"), type);
        hideKeyboard();

        if (breaks > 0) {
            for (int i = 0; i < breaks; i++) {
                tapOnBreakButton();
            }
        }
        editWage(wage);

    }

    private void editWage(String wage) {
        tap(By.id("info_wage_edit"));
        type(By.id("info_wage_input"), wage);
        hideKeyboard();
        tap(By.id("info_wage_save"));
    }

    private void tapOnBreakButton() {
        tap(By.id("info_break_plus_btn"));
    }

    public void save() {
        tap(By.id("info_save_btn"));
    }

    public void selectDate(String type, String month, String dayOfMonth) {
        if (!getSelectedMonth().equals(month)) {
            if (type.equals("past")) {
                swipeToRightUntilNeededMonth(month);
                if (!getSelectedDayOfMonth().equals(dayOfMonth)) {
                    swipeToRightUntilNeededDayOfMonth(dayOfMonth);
                }
            } else if (type.equals("future")) {
                swipeToLeftUntilNeededMonth(month);
                if (!getSelectedDayOfMonth().equals(dayOfMonth)) {
                    swipeToLeftUntilNeededDayOfMonth(dayOfMonth);
                }
            }
        } else if (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            if (type.equals("past")) {
                swipeToRightUntilNeededDayOfMonth(dayOfMonth);
            } else if (type.equals("future")) {
                swipeToLeftUntilNeededDayOfMonth(dayOfMonth);
            }
        }
    }

    private String getSelectedMonth() {
        WebElement element = driver.findElement(By.id("date_container_layout"));
        return element.findElement(By
                .xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']"))
                .getText();
    }

    private String getSelectedDayOfMonth() {
        WebElement selectedDate = driver.findElement(By.id("date_container_layout"));
        return selectedDate.findElement(By
                .xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']"))
                .getText();
    }

    private void swipeToRightUntilNeededDayOfMonth(String dayOfMonth) {
        while (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            moveElementToRight(By.id("info_viewPager"));
            getSelectedDayOfMonth();
        }
    }

    private void swipeToLeftUntilNeededDayOfMonth(String dayOfMonth) {
        while (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedDayOfMonth();
        }
    }

    private void swipeToRightUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)) {
            moveElementToRight(By.id("info_viewPager"));
            getSelectedMonth();
        }
    }

    private void swipeToLeftUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)) {
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedMonth();
        }
    }

    private void moveElementToLeft(By locator) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.5);
        int y = size.height / 5;

        WebElement element = driver.findElement(locator);

        action.longPress(PointOption.point(rightPoint, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(leftPoint, y))
                .release()
                .perform();
    }

    private void moveElementToRight(By locator) {

        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.5);
        int y = size.height / 5;

        WebElement element = driver.findElement(locator);

        action.longPress(PointOption.point(leftPoint, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(rightPoint, y))
                .release()
                .perform();
    }

    public boolean isEventPresent() {
        waitForElement(By.id("row_container_main"), 20);
        return isElementPresent(By.id("row_container_main"));
    }

}
