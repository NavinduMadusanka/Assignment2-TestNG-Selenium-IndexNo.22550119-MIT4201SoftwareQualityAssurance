package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageTestCaseEbay {
    WebDriver driver;

    // Locators
    @FindBy(id = "atcBtn_btn_1") // Add to Cart button
    WebElement addToCartButton;

    @FindBy(id = "watchBtn_btn_1") // Proceed to checkout button
    WebElement addToWatchList;

    @FindBy(id = "binBtn_btn_1") // Proceed to Buy It Now
    WebElement buyItNow;

    @FindBy(id = "wrong element") // Proceed to Buy It Now
    WebElement wrongElement;

    // Constructor to initialize elements
    public ProductPageTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods Used in Products Page
    public void buyItNow() {
        buyItNow.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void addToWatchList() {
        addToWatchList.click();
    }

    public void wrongElementTest() {
        wrongElement.click();
    }
}
