package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.HeadlessTestCaseEbay;
import SubPagesTestCasesEbay.*;
import Utils.ExcelFileHandlerUtilsTestCaseEbay;
import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShippingHeadlessTestCase9Ebay extends HeadlessTestCaseEbay {

    @BeforeTest
    public void setup() { setUpBrowser(); }

    @Test
    public void SearchAndBuyInfinixPhone() {

        HomePageTestCaseEbay homePage = new HomePageTestCaseEbay(driver);
        ResultSearchPageTestCaseEbay searchResultsPage = new ResultSearchPageTestCaseEbay(driver);
        ProductPageTestCaseEbay productPage = new ProductPageTestCaseEbay(driver);
        ShippingHeadlessTestCaseEbay checkConditionsPage = new ShippingHeadlessTestCaseEbay(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testcasesdataebay/TestCasesDataEbay.xlsx";
        String sheetName = "TestCasesDataEbay";

        // Initialize ExcelUtils
        ExcelFileHandlerUtilsTestCaseEbay excel = new ExcelFileHandlerUtilsTestCaseEbay(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(0, 1); // Row 0, Column 1

        // Step 1: Search for Infinix phone
        homePage.searchFor(mobileBrand);
        setReportName("Shipping Headless Test Case 9 Ebay");
        startTest("Shipping Headless Test Case 9 Ebay");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Successful Search Test Case 9 Ebay");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "First Result Taken Test Case 9 Ebay");
        test.pass("System Successfully searched the item and select the first result").addScreenCaptureFromPath(screenshotPath2);

        // Step 2: Check product conditions on the product page
        boolean conditionsMet = checkConditionsPage.checkProductStatus();
        if (conditionsMet) {
            test = extent.createTest("Product Shipping Check Verified", "Product Shipping is met.");
            String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Product Shipping Verified Test Case 9 Ebay");
            test.pass("Product Shipping is met").addScreenCaptureFromPath(screenshotPath3);
        } else {
            test = extent.createTest("Product Shipping Verification Failed", "Product Shipping is not met.");
            String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Product Shipping Not Met Test Case 9 Ebay");
            test.fail("Product Shipping is not met").addScreenCaptureFromPath(screenshotPath3);
        }

        // Write data back to the Excel file
        excel.setCellData(0, 2, "Infinix Hot 50 Factory Unlocked 256GB Internal Memory GSM Cell Phone GR", excelFilePath);

        // Close workbook
        excel.closeWorkbook();
    }
}
