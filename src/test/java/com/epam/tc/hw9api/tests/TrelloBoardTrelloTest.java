package com.epam.tc.hw9api.tests;

import static com.epam.tc.hw9api.core.BoardServiceObject.getBoardInstance;
import static com.epam.tc.hw9api.core.BoardServiceObject.requestBuilder;
import static com.epam.tc.hw9api.specs.ResponseSpecifications.goodResponseSpecification;
import static com.epam.tc.hw9api.step.BoardStep.createBoard;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.StringContains.containsString;

import com.epam.tc.hw9api.beans.BoardTrello;
import com.epam.tc.hw9api.testdata.BoardDataProvider;
import io.restassured.http.Method;
import org.testng.annotations.Test;

public class TrelloBoardTrelloTest extends BaseTest {

    @Test(dataProviderClass = BoardDataProvider.class, dataProvider = "getCreateBoardData")
    public void createBoardTest(BoardTrello board) {
        BoardTrello createdBoard = getBoardInstance(
            requestBuilder()
                .setMethod(Method.POST)
                .setName(board.getName())
                .buildRequest()
                .sendBoardRequest()
                .then()
                .spec(goodResponseSpecification()));

        assertThat(createdBoard).usingRecursiveComparison().ignoringFields("id").isEqualTo(board);
    }

    @Test(dataProviderClass = BoardDataProvider.class, dataProvider = "getUpdateBoardData")
    public void changeBoardNameTest(BoardTrello newBoard, String newName) {
        BoardTrello createdBoard = createBoard(newBoard);

        BoardTrello updatedBoard = getBoardInstance(
            requestBuilder()
                .setMethod(Method.PUT)
                .setId(createdBoard.getId())
                .setName(newName)
                .buildRequest()
                .sendBoardRequest()
                .then()
                .spec(goodResponseSpecification()));

        assertThat(updatedBoard.getName()).isEqualTo(newName);
    }

    @Test(dataProviderClass = BoardDataProvider.class, dataProvider = "getCreateBoardData")
    public void deleteBoardTest(BoardTrello board) {
        BoardTrello createdBoard = createBoard(board);

        requestBuilder()
            .setMethod(Method.DELETE)
            .setId(createdBoard.getId())
            .buildRequest()
            .sendBoardRequest()
            .then()
            .spec(goodResponseSpecification())
            .body(containsString("_value"));
    }
}
