package com.epam.tc.hw6.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    //    @Override
    //    public void onTestFailure(ITestResult result) {
    //        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
    //        attachScreenShot(driver);
    //    }
    //
    //    @Attachment(type = "image/png", fileExtension = ".png")
    //    private byte[] attachScreenShot(WebDriver webDriver) {
    //        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    //    }
}
