package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws InterruptedException {
        app.user().login(new User().email("Neuer@gmail.com").password("Neuer2021"));
      //  Thread.sleep(10000);
        Assert.assertTrue(app.event().isIconSortOptionsPresent());

    }
}
