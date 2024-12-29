package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import SubPagesTestCasesEbay.JobsPortalPageTestCaseEbay;
import SubPagesTestCasesEbay.HomePageTestCaseEbay;
import Utils.ExcelFileHandlerUtilsTestCaseEbay;
import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindJobsInPortalTestCase6Ebay extends MainPageTestCaseEbay {

    @Test
    public void careersInfoAssertion() {

        HomePageTestCaseEbay homePage = new HomePageTestCaseEbay(driver);
        JobsPortalPageTestCaseEbay careersPage = new JobsPortalPageTestCaseEbay(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testcasesdataebay/TestCasesDataEbay.xlsx";
        String sheetName = "TestCasesDataEbay";

        // Initialize ExcelUtils
        ExcelFileHandlerUtilsTestCaseEbay excel = new ExcelFileHandlerUtilsTestCaseEbay(excelFilePath, sheetName);

        // Read data
        String expectedTitle = excel.getCellData(1, 1); // Row 1, Column 1
        System.out.println("Expected Page Title: " + expectedTitle); // Debug statement

        setReportName("Find Jobs In Portal Test Case 6 Ebay");
        startTest("Find Jobs In Portal Test Case 6 Ebay");

        // Get the actual page title from the careers page operations
        String actualPageTitle = careersPage.careersOperations();
        test = extent.createTest("IT & Technical Operations Page Title Verification", "IT & Technical Operations Page Title Verification");

        try {
            // Capture a screenshot before performing the assertion
            String screenshotPath1 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Page Title Verification Test Case 6 Ebay");

            // Assert the titles and log success in Extent Report
            Assert.assertEquals(actualPageTitle, expectedTitle, "Title Matching");
            test.pass("Assertion Passed: Titles are Matching").addScreenCaptureFromPath(screenshotPath1);

        } catch (AssertionError e) {
            // Capture a screenshot on failure
            String screenshotPath2 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Page Title Comparison Failure Test Case 6 Ebay");

            // Log failure in Extent Report
            test.fail("Assertion failed: Titles are not Matching...Looks like Engineering page not loaded ->>> Expected: " + expectedTitle + ", Actual: " + actualPageTitle + ". Exception: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath2);

            // Rethrow the AssertionError to terminate the test and mark it as failed
            throw e;
        }

        // Close workbook
        excel.closeWorkbook();
    }
}
