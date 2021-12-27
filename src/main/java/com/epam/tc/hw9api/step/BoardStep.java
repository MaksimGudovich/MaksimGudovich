package com.epam.tc.hw9api.step;

import static com.epam.tc.hw9api.core.BoardServiceObject.getBoardInstance;
import static com.epam.tc.hw9api.core.BoardServiceObject.requestBuilder;
import static com.epam.tc.hw9api.specs.ResponseSpecifications.goodResponseSpecification;

import com.epam.tc.hw9api.beans.BoardTrello;
import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import java.util.List;

public class BoardStep {

    @Step("Create board")
    public static BoardTrello createBoard(BoardTrello board) {
        ValidatableResponse response = requestBuilder()
            .setMethod(Method.POST)
            .setName(board.getName())
            .buildRequest()
            .sendBoardRequest()
            .then();

        response.assertThat().spec(goodResponseSpecification());

        return getBoardInstance(response);
    }

    @Step("Change board name")
    public static BoardTrello changeBoardName(BoardTrello board, String name) {
        ValidatableResponse response = requestBuilder()
            .setMethod(Method.PUT)
            .setId(board.getId())
            .setName(name)
            .buildRequest()
            .sendBoardRequest()
            .then();

        response.assertThat().spec(goodResponseSpecification());

        return getBoardInstance(response);
    }

    @Step("Delete board")
    public static void deleteBoard(BoardTrello board) {
        requestBuilder()
            .setMethod(Method.DELETE)
            .setId(board.getId())
            .buildRequest()
            .sendBoardRequest()
            .then()
            .spec(goodResponseSpecification());
    }

    @Step("Delete all boards")
    public static void deleteAllBoards() {
        List<BoardTrello> boardList = requestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendAllBoardRequest()
            .as(new TypeRef<List<BoardTrello>>() {
            });

        boardList.forEach(BoardStep::deleteBoard);
    }
}
