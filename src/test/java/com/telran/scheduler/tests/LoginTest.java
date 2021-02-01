package com.telran.scheduler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws InterruptedException {
        app.user().login("Neuer@gmail.com", "Neuer2021");
        Thread.sleep(10000);
        Assert.assertTrue(app.event().isIconSortOptionsPresent());

    }
}
