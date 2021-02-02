package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class EventHelper extends HelperBase{

    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isIconSortOptionsPresent() {
        return isElementPresent(By
                .xpath("//*[@resource-id='com.example.svetlana.scheduler:id/nav_list_fr_fab_container']"));
        ////*[@resource-id='com.example.svetlana.scheduler:id/nav_list_fr_fab_container']
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
        if (!getSelectedMonth().equals(month)){

            if (type.equals("past")){
                swipeToRightUntillNeededMonth(month);
            }
        }
    }

    private void swipeToRightUntillNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)){
            moveElementToRight(By.id("info_viewPager"));
            getSelectedMonth();
        }
    }

    private void moveElementToRight(By locator) {

        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.8);

        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX() * 0.2);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY)/2;

        action.longPress(PointOption.point(leftPoint, middleY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(rightPoint, middleY))
                .release()
                .perform();
    }

    private String getSelectedMonth() {
        WebElement element = driver.findElement(By.id("date_container_layout"));
        return element
                .findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']"))
                .getText();

    }

    //info_viewPager
    //date_container_layout
    //id="com.example.svetlana.scheduler:id/row_day_number_txt
    //id="com.example.svetlana.scheduler:id/row_month_txt
}
