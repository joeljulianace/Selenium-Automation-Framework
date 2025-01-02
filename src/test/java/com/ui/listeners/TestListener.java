package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " PASSED");
        ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
        Object testclass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
        logger.info("Capturing screenshot for the failed test case");
        String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
        logger.info("Attaching the screenshot to the HTML file");
        ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReportUtility.setUpSparkReporter("report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReportUtility.flushReport();
    }
}
