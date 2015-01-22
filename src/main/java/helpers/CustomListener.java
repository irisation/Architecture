package helpers;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListener extends ExitCodeListener {

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        System.out.println(result.getMethod().getTestClass().getName() + "-" +
                result.getMethod().getMethodName() + " started at " + new Date());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        System.out.println(result.getMethod().getTestClass().getName() + "-"
                + result.getMethod().getMethodName() + " failed at " + new Date());
        SimpleDateFormat df = new SimpleDateFormat("yyyymmdd-hhmmss");

        String path = "D:/target/screenshots/" + result.getMethod().getTestClass().getName() + "/"
                + result.getMethod().getMethodName() + "_" + df.format(new Date()) + ".png";
        Actions.takeScreenshot(path);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        System.out.println(result.getMethod().getTestClass().getName() + "-"
                + result.getMethod().getMethodName() + " passed at " + new Date());
    }

}
