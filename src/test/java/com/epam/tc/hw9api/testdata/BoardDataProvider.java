package com.epam.tc.hw9api.testdata;

import com.epam.tc.hw9api.beans.BoardTrello;
import org.testng.annotations.DataProvider;

public class BoardDataProvider {

    @DataProvider
    public static Object[][] getCreateBoardData() {
        BoardTrello board = new BoardTrello();
        board.setName("Test Board");

        return new  Object[][] {{board}};
    }

    @DataProvider
    public static Object[][] getUpdateBoardData() {
        BoardTrello board = new BoardTrello();
        board.setName("Test Board");

        return new  Object[][] {{board, "New test Board"}};
    }
}
