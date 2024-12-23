package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import SubPagesTestCasesEbay.CheckProductPageConditionsTestCaseEbay;
import SubPagesTestCasesEbay.HomePageTestCaseEbay;
import SubPagesTestCasesEbay.ProductPageTestCaseEbay;
import SubPagesTestCasesEbay.ResultSearchPageTestCaseEbay;
import Utils.ExcelFileHandlerUtilsTestCaseEbay;
import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckProductConditionsTestCase5Ebay extends MainPageTestCaseEbay {

    @BeforeTest
    public void setup() {
        setUpBrowser();
    }

    @Test
    public void SearchAndBuyInfinixPhone() {

        HomePageTestCaseEbay homePage = new HomePageTestCaseEbay(driver);
        ResultSearchPageTestCaseEbay searchResultsPage = new ResultSearchPageTestCaseEbay(driver);
        ProductPageTestCaseEbay productPage = new ProductPageTestCaseEbay(driver);
        CheckProductPageConditionsTestCaseEbay checkConditionsPage = new CheckProductPageConditionsTestCaseEbay(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testcasesdata/TestCasesDataEbay.xlsx";
        String sheetName = "TestCasesDataEbay";

        // Initialize ExcelUtils
        ExcelFileHandlerUtilsTestCaseEbay excel = new ExcelFileHandlerUtilsTestCaseEbay(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(1, 1); // Row 1, Column 1

        // Step 1: Search for Infinix phone
        homePage.searchFor(mobileBrand);
        setReportName("Check Product Conditions Test Case 5 Ebay");
        startTest("Check Product Conditions Test Case 5 Ebay");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Successful Search Test Case 5 Ebay");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "First Result Taken Test Case 5 Ebay");
        test.pass("System Successfully searched the item and select the first result").addScreenCaptureFromPath(screenshotPath2);

        // Step 4: Check product conditions on the product page
        boolean conditionsMet = checkConditionsPage.checkProductConditions();
        if (conditionsMet) {
            test = extent.createTest("Product Conditions Verified", "All product conditions are met.");
            String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Product Conditions Verified Test Case 5 Ebay");
            test.pass("All product conditions are met").addScreenCaptureFromPath(screenshotPath3);
        } else {
            test = extent.createTest("Product Conditions Verification Failed", "Not all product conditions are met.");
            String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Product Conditions Not Met Test Case 5 Ebay");
            test.fail("Not all product conditions are met").addScreenCaptureFromPath(screenshotPath3);
        }

        // Write data back to the Excel file
        excel.setCellData(1, 2, "Infinix is a good phone", excelFilePath);

        // Close workbook
        excel.closeWorkbook();
    }
}