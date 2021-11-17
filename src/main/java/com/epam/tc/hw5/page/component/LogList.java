package com.epam.tc.hw5.page.component;

import com.epam.tc.hw5.util.ElementListHandler;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogList extends AbstractComponent {
    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logList;

    public LogList(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getLogList() {
        return ElementListHandler.getTextList(logList);
    }
}
