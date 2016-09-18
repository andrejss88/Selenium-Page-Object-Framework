package com.github.dataproviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Andre on 9/18/2016.
 */
public class UserDetailsProvider {

    @DataProvider(name = "dummyUserDetails")
    public static Object[][] createData1() {
        return new Object[][]{
                {"user1", "email1", "pass1"},
                {"user2", "email2", "pass2"}
        };
    }

    //ado-TODO: implement another data provider that fetches data from XLS
}
