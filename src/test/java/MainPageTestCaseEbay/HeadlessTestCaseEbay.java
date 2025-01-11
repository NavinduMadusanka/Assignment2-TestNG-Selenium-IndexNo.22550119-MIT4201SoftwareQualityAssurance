package MainPageTestCaseEbay;

import Utils.ScreenShotsCaptureUtilsTestCaseEbay;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HeadlessTestCaseEbay {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private String reportFileName;

    @BeforeSuite
    public void setUp() {
        // Create a unique file name for the Extent Report
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportFileName = "ExtentReport_" + timestamp + ".html"; // Default report name

        // Set up ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    /**
     * Set a custom name for the Extent Report.
     * @param customName The custom name for the report.
     */
    public void setReportName(String customName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportFileName = customName + "_" + timestamp + ".html";

        // Reinitialize ExtentSparkReporter with the new name
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    /**
     * Start a test in Extent Report with a given name.
     *
     * @param testName Name of the test case.
     */
    public void startTest(String testName) {
        test = extent.createTest(testName);
    }

    @BeforeClass
    public void setUpBrowser() {
        // Set up ChromeOptions to use headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        // Initialize the ChromeDriver with the options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenShotsCaptureUtilsTestCaseEbay.takeScreenshot(driver, result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
