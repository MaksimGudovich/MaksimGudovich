package com.epam.tc.hw9api.core;

import static com.epam.tc.hw9api.constants.Constants.ALL_BOARDS_URI;
import static com.epam.tc.hw9api.constants.Constants.BOARDS_URI;

import com.epam.tc.hw9api.beans.BoardTrello;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

public class BoardServiceObject extends BaseTrelloServiceObject {

    public BoardServiceObject(Method requestMethod, Map<String, String> queryParams,
                              Map<String, String> pathParams) {
        super(requestMethod, queryParams, pathParams);
    }

    public static BoardRequestBuilder requestBuilder() {
        return new BoardRequestBuilder();
    }

    public static BoardTrello getBoardInstance(ValidatableResponse response) {
        return response.extract().body().as(BoardTrello.class);
    }

    public Response sendBoardRequest() {
        return sendRequest(BOARDS_URI);
    }

    public Response sendAllBoardRequest() {
        return sendRequest(ALL_BOARDS_URI);
    }

    public static class BoardRequestBuilder extends BaseRequestBuilder<BoardServiceObject, BoardRequestBuilder> {
        @Override
        public BoardServiceObject buildRequest() {
            return new BoardServiceObject(requestMethod, queryParams, pathParams);
        }
    }
}
