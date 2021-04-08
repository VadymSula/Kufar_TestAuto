package tests.android;

import core.InitialDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class ListenerTest implements ITestListener {
    @Attachment("Screenshot on failure")
    private byte[] makeScreenshotOnFailure(String testName) {
        return ((TakesScreenshot) InitialDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private void takeScreenshot() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                ((TakesScreenshot) InitialDriver.getDriver())
                .getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment("Screenshot of failed step", byteArrayInputStream);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }
}
