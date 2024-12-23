package MainTestCasesPagesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import SubPagesTestCasesEbay.HomePageTestCaseEbay;
import SubPagesTestCasesEbay.ProductPageTestCaseEbay;
import SubPagesTestCasesEbay.ResultSearchPageTestCaseEbay;
import Utils.ExcelFileHandlerUtilsTestCaseEbay;
import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToWatchListTestCase2Ebay extends MainPageTestCaseEbay {

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
        ExcelFileHandlerUtilsTestCaseEbay excel = new ExcelFileHandlerUtilsTestCaseEbay(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(1, 1); // Row 1, Column 1

        // Step 1: Search for Samsung phone
        homePage.searchFor(mobileBrand);
        setReportName("Add To Watch List Test Case 2 Ebay");
        startTest("Add To Watch List Test Case 2 Ebay");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Successful Search Test Case 2 Ebay");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        // Step 2: Select the first product
        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "First Result Taken Test Case 2 Ebay");
        test.pass("System Successfully searched the item and select the first result").addScreenCaptureFromPath(screenshotPath2);

        // Write data back to the Excel file
        excel.setCellData(1, 2, "Samsung is the good phone", excelFilePath);

        // Step 3: Proceed to addToWatchList
        productPage.addToWatchList();
        test = extent.createTest("Successful Add to watch list", "System Successfully Add the item to watch list");
        String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Add To Watch List Test Case 2 Ebay");
        test.pass("System Successfully Add the item to watch list").addScreenCaptureFromPath(screenshotPath3);

        // Close workbook
        excel.closeWorkbook();
    }
}
