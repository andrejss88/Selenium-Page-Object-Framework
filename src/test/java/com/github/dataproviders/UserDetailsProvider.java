package com.github.dataproviders;

import org.testng.annotations.DataProvider;

import static com.github.dataproviders.CSVProvider.getCSVData;

public class UserDetailsProvider {

    @DataProvider(name = "dummyUserDetails")
    public static Object[][] getUserDetails() {
        return new Object[][]{
                {"user1", "email1", "pass1"},
                {"user2", "email2", "pass2"}
        };
    }

    @DataProvider(name="loginData")
    public static Object[][] loginData() {
        return getCSVData("loginDetails.csv");
    }



}
