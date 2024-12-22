package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import SubPagesTestCasesEbay.HomePageTestCaseEbay;
import SubPagesTestCasesEbay.ProductPageTestCaseEbay;
import SubPagesTestCasesEbay.ResultSearchPageTestCaseEbay;
import SupportiveTestCasesEbay.ExcelFileHandlerTestCaseEbay;
import SupportiveTestCasesEbay.ScreenShotsCaptureTestCaseEbay;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchAddToCartTestCaseEbay extends MainPageTestCaseEbay {

    @BeforeTest
    public void setup() {
        setUpBrowser();
    }

    @Test
    public void searchAndBuySamsungPhone() {

        HomePageTestCaseEbay homePage = new HomePageTestCaseEbay(driver);
        ResultSearchPageTestCaseEbay searchResultsPage = new ResultSearchPageTestCaseEbay(driver);
        ProductPageTestCaseEbay productPage = new ProductPageTestCaseEbay(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testcasesdata/TestCasesData.xlsx";
        String sheetName = "TestCasesData";

        // Initialize ExcelUtils
        ExcelFileHandlerTestCaseEbay excel = new ExcelFileHandlerTestCaseEbay(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(1, 1); // Row 1, Column 1

        // Step 1: Search for Samsung phone
        homePage.searchFor(mobileBrand);
        setReportName("Add To Cart Scenario- Test Case 1");
        startTest("Add To Cart Scenario- Test Case 1");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "SuccessfulSearch");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        // Step 2: Select the first product
        double actualValue = searchResultsPage.assertPrice();
        double expectedPrice = 200;
        test = extent.createTest("Now Price is comparing", "Now Price is comparing");

        try {
            String screenshotPath5 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "Price Comparison");
            Assert.assertTrue(actualValue <= expectedPrice, "Price of the first item exceeds the expected value! Actual: $" + actualValue + ", Expected: $" + expectedPrice);
            test.pass("Price is within the expected range.").addScreenCaptureFromPath(screenshotPath5);
        } catch (AssertionError e) {
            // Capture screenshot on failure
            String screenshotPath4 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "Price Comparison");
            test.fail("Assertion failed: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath4);
            throw e; // Rethrow to terminate the test
        }
        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "FirstResultTaken");
        test.pass("System Successfully searched the item and select  the first result").addScreenCaptureFromPath(screenshotPath2);

        // Write data back to the Excel file
        excel.setCellData(1, 2, "Samsung is the phone", excelFilePath);

        // Step 3: Proceed to add To Cart
        test = extent.createTest("Successfully Add to Cart", "System Successfully  Add the item to Cart");
        String screenshotPath3 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "AddToCart");
        test.pass("System Successfully  Add the item to Cart").addScreenCaptureFromPath(screenshotPath3);

        // Close workbook
        excel.closeWorkbook();
    }
}
