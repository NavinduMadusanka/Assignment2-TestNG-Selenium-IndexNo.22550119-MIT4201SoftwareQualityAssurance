package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import SupportiveTestCasesEbay.ExcelFileHandlerTestCaseEbay;
import SupportiveTestCasesEbay.ScreenShotsCaptureTestCaseEbay;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import SubPagesTestCasesEbay.HomePageTestCaseEbay;
import SubPagesTestCasesEbay.ResultSearchPageTestCaseEbay;
import SubPagesTestCasesEbay.ProductPageTestCaseEbay;

public class SearchBuyItNowTestCaseEbay extends MainPageTestCaseEbay {

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
        setReportName("Buy It Now Scenario- Test Case 3");
        startTest("Buy It Now Scenario- Test Case 3");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "SuccessfulSearch");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        // Step 2: Select the first product
        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "FirstResultTaken");
        test.pass("System Successfully searched the item and select  the first result").addScreenCaptureFromPath(screenshotPath2);

        // Write data back to the Excel file
        excel.setCellData(1, 2, "Samsung Selected", excelFilePath);

        // Step 3: Proceed to Buy It Now
        productPage.buyItNow();
        test = extent.createTest("Successfully click on Buy It Now", "System Successfully  click on Buy It Now");
        String screenshotPath3 = ScreenShotsCaptureTestCaseEbay.takeScreenshot(driver, "BuyItNow");
        test.pass("System Successfully  click on Buy It Now").addScreenCaptureFromPath(screenshotPath3);

        // Close workbook
        excel.closeWorkbook();
    }
}
