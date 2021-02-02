package com.telran.scheduler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAppTest extends TestBase {

    @Test
    public void testLaunchApp() {
        String version = app.getAppVersion();
        System.out.println("app opened");
        Assert.assertEquals(version, "0.0.3");
    }


}
