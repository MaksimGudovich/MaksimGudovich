package com.epam.tc.hw9api.tests;

import static com.epam.tc.hw9api.core.ListServiceObject.getListInstance;
import static com.epam.tc.hw9api.core.ListServiceObject.requestBuilder;
import static com.epam.tc.hw9api.specs.ResponseSpecifications.goodResponseSpecification;
import static com.epam.tc.hw9api.step.BoardStep.createBoard;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw9api.beans.BoardTrello;
import com.epam.tc.hw9api.beans.ListTrello;
import com.epam.tc.hw9api.core.ListServiceObject;
import com.epam.tc.hw9api.step.ListStep;
import com.epam.tc.hw9api.testdata.ListDataProvider;
import io.restassured.http.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloListTest extends BaseTest {

    private BoardTrello testBoard;

    @BeforeMethod
    public void setup() {
        testBoard = createBoard(new BoardTrello().setName("Test Board"));
    }

    @Test(dataProviderClass = ListDataProvider.class, dataProvider = "getCreateListData")
    public void createListTest(ListTrello list) {
        ListTrello createdList = getListInstance(
            requestBuilder()
                .setMethod(Method.POST)
                .setBoardId(testBoard.getId())
                .setName(list.getName())
                .buildRequest()
                .sendListRequest()
                .then()
                .spec(goodResponseSpecification()));

        assertThat(createdList).usingRecursiveComparison().ignoringFields("id", "idBoard").isEqualTo(list);
    }

    @Test(dataProviderClass = ListDataProvider.class, dataProvider = "getUpdateListData")
    public void changeListNameTest(ListTrello newList, String newName) {
        ListTrello createdList = ListStep.createList(newList, testBoard);

        ListTrello updatedList = getListInstance(
            ListServiceObject.requestBuilder()
                             .setMethod(Method.PUT)
                             .setId(createdList.getId())
                             .setName(newName)
                             .buildRequest()
                             .sendListRequest()
                             .then()
                             .spec(goodResponseSpecification()));

        assertThat(updatedList.getName()).isEqualTo(newName);
    }

}
