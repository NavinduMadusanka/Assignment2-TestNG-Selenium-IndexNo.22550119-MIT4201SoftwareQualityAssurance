package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuantityCheckHeadlessTestCaseEbay {
    WebDriver driver;

    // Locator for the Product Status element
    @FindBy(xpath = "//*[@id='qtyAvailability']/span[2]")
    WebElement StatusElement;

    public QuantityCheckHeadlessTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to check product Status
    public boolean checkProductStatus() {
        // Add logic to check other status if necessary
        return StatusElement.isDisplayed();
    }
}