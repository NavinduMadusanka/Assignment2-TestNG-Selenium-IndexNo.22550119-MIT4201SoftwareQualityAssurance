package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePageTestCaseEbay {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "gh-ac") // Search input field
    WebElement searchBox;

    @FindBy(id = "gh-btn") // Search button
    WebElement searchButton;

    // Constructor to initialize elements
    public HomePageTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void searchFor(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
}