package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingHeadlessTestCaseEbay {
    WebDriver driver;

    // Locator for the Product Status element
    @FindBy(xpath = "//*[@id='mainContent']/div/div[8]/div/div/div/div[1]/div/div/div/div[2]/div/div[1]/span[3]")
    WebElement StatusElement;

    public ShippingHeadlessTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to check product Status
    public boolean checkProductStatus() {
        // Add logic to check other status if necessary
        return StatusElement.isDisplayed();
    }
}
