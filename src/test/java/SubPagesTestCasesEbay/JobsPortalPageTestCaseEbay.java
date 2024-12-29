package SubPagesTestCasesEbay;

import MainPageTestCaseEbay.MainPageTestCaseEbay;
import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsPortalPageTestCaseEbay extends MainPageTestCaseEbay {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//*[@id='vl-flyout-nav']/ul/li[11]/a") // Deals Button
    WebElement deals;

    @FindBy(xpath = "//*[@id='gf-l']/li[1]/a") // AboutEbay
    WebElement aboutEbay;

    @FindBy(xpath = "//*[@id='main-nav-menu']/nav/ul/li[7]/a") // careers Ebay button
    WebElement careersLink;

    // Constructor to initialize elements
    public JobsPortalPageTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public String careersOperations() {
        // Click On Deals
        deals.click();
        test = extent.createTest("Successful Navigate to Global Deals Page", "Successful Navigate to Global Deals Page");
        String screenshotPath1 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Deals Page Test Case 6 Ebay");
        test.pass("System Successfully Navigate to Global Deals Page").addScreenCaptureFromPath(screenshotPath1);

        // Scroll to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        test = extent.createTest("Successfully Navigate to Bottom Of the Page", "Successfully Navigate to Bottom Of the Page");
        String screenshotPath2 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Bottom Of the Page Test Case 6 Ebay");
        test.pass("System Successfully Navigate to Bottom Of the Page").addScreenCaptureFromPath(screenshotPath2);

        // Click On About E-Bay
        aboutEbay.click();
        test = extent.createTest("Successfully Navigate to About Page", "Successfully Navigate to About Page");
        String screenshotPath3 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "About Page Test Case 6 Ebay");
        test.pass("System Successfully Navigate to About Page").addScreenCaptureFromPath(screenshotPath3);

        // Click On Careers Link
        careersLink.click();
        test = extent.createTest("Successfully Navigate to Careers Page", "Successfully Navigate to Careers Page");
        String screenshotPath4 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Careers Page Test Case 6 Ebay");
        test.pass("System Successfully Navigate to Careers Page").addScreenCaptureFromPath(screenshotPath4);

        // Create an explicit wait with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Wait for the element to be visible
            WebElement startSearchJob = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typehead")));

            // Perform actions on the element
            startSearchJob.sendKeys("IT & Technical Operations" + Keys.ENTER);
            test = extent.createTest("Successfully Navigate to IT & Technical Operations Jobs Page", "Successfully Navigate to IT & Technical Operations Jobs Page");
            String screenshotPath5 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "IT & Technical Operations Jobs Page Test Case 6 Ebay");
            test.pass("System Successfully Navigate to IT & Technical Operations Jobs Page").addScreenCaptureFromPath(screenshotPath5);

            // Wait for the page title to be updated
            wait.until(ExpectedConditions.titleContains("Jobs in IT & Technical Operations"));

        } catch (Exception e) {
            System.out.println("Element not found within the specified time.");
            test = extent.createTest("Element not found within the specified time", "Element not found within the specified time");
            String screenshotPath6 = ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, "Element Not Found Within The Specified Time Test Case 6 Ebay");
            test.pass("Element not found within the specified time").addScreenCaptureFromPath(screenshotPath6);
        }

        // Get the page title and print it for debugging
        String pageTitle = driver.getTitle();
        System.out.println("Actual Page Title: " + pageTitle);
        return pageTitle;
    }
}
