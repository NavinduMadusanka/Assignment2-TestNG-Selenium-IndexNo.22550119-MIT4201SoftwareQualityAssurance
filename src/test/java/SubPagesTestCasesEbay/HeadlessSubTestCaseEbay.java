package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadlessSubTestCaseEbay {
    WebDriver driver;

    // Locator for the Product Status element
    @FindBy(xpath = "//*[@id='null']/div/span/span[1]/span")
    WebElement StatusElement;

    public HeadlessSubTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to check product Status
    public boolean checkProductStatus() {
        // Add logic to check other status if necessary
        return StatusElement.isDisplayed();
    }
}
