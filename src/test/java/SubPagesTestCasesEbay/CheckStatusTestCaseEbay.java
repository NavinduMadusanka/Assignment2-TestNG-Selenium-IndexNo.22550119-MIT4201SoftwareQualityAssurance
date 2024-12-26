package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckStatusTestCaseEbay {
    WebDriver driver;

    // Locator for the Product Status element
    @FindBy(xpath = "//*[@id='mainContent']/div/div[2]/div/div/div/a/span")
    WebElement StatusElement;

    public CheckStatusTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to check product Status
    public boolean checkProductStatus() {
        // Add logic to check other status if necessary
        return StatusElement.isDisplayed();
    }
}