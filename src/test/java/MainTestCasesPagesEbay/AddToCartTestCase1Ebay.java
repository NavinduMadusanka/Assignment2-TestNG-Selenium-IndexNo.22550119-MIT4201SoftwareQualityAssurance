package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import SubPagesTestCasesEbay.HomePageTestCaseEbay;
import SubPagesTestCasesEbay.ProductPageTestCaseEbay;
import SubPagesTestCasesEbay.ResultSearchPageTestCaseEbay;
import Utils.ExcelFileHandlerUtilsTestCaseEbay;
import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTestCase1Ebay extends MainPageTestCaseEbay {

    @BeforeTest
    public void setup() { setUpBrowser(); }

    @Test
    public void SearchAndBuyInfinixPhone() {

        HomePageTestCaseEbay homePage = new HomePageTestCaseEbay(driver);
        ResultSearchPageTestCaseEbay searchResultsPage = new ResultSearchPageTestCaseEbay(driver);
        ProductPageTestCaseEbay productPage = new ProductPageTestCaseEbay(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testcasesdataebay/TestCasesDataEbay.xlsx";
        String sheetName = "TestCasesDataEbay";

        // Initialize ExcelUtils
        ExcelFileHandlerUtilsTestCaseEbay excel = new ExcelFileHandlerUtilsTestCaseEbay(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(0, 1); // Row 0, Column 1

        // Step 1: Search for Infinix phone
        homePage.searchFor(mobileBrand);
        setReportName("Add To Cart Test Case 1 Ebay");
        startTest("Add To Cart Test Case 1 Ebay");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Successful Search Test Case Ebay 1");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        // Step 2: Select the first product
        double actualValue = searchResultsPage.assertPrice();
        double expectedPrice = 150;
        test = extent.createTest("Now Price is comparing", "Now Price is comparing");

        try {
            String screenshotPath5 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Price Comparison Test Case 1 Ebay");
            Assert.assertTrue(actualValue <= expectedPrice, "Price of the first item exceeds the expected value! Actual: $" + actualValue + ", Expected: $" + expectedPrice);
            test.pass("Price is within the expected range.").addScreenCaptureFromPath(screenshotPath5);
        } catch (AssertionError e) {
            // Capture screenshot on failure
            String screenshotPath4 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Price Comparison Test Case 1 Ebay");
            test.fail("Assertion failed: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath4);
            throw e; // Rethrow to terminate the test
        }
        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "First Result Taken Test Case 1 Ebay");
        test.pass("System Successfully searched the item and select the first result").addScreenCaptureFromPath(screenshotPath2);

        // Write data back to the Excel file
        excel.setCellData(0, 2, "Infinix Hot 50 Factory Unlocked 256GB Internal Memory GSM Cell Phone GR", excelFilePath);

        // Step 3: Proceed to add To Cart
        test = extent.createTest("Successfully Add to Cart", "System Successfully Add the item to Cart");
        String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Add To Cart Test Case 1 Ebay");
        test.pass("System Successfully Add the item to Cart").addScreenCaptureFromPath(screenshotPath3);

        // Close workbook
        excel.closeWorkbook();
    }
}
