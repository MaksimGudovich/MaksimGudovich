package com.epam.tc.hw9api.testdata;

import com.epam.tc.hw9api.beans.ListTrello;
import org.testng.annotations.DataProvider;

public class ListDataProvider {

    @DataProvider
    public static Object[][] getCreateListData() {
        ListTrello list = new ListTrello();
        list.setName("Test list");

        return new  Object[][] {{list}};
    }

    @DataProvider
    public static Object[][] getUpdateListData() {
        ListTrello list = new ListTrello();
        list.setName("Test list");

        return new  Object[][] {{list, "New test list"}};
    }
}
