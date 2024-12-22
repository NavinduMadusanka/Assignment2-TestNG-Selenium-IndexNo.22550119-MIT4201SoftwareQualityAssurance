package SubPagesTestCasesEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;
public class ResultSearchPageTestCaseEbay {
    WebDriver driver;

    // Locator for the first product in the search results
    @FindBy(xpath = "//*[@id=\"item3b5e5fb14b\"]/div/div[2]/a/div/span")
    WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"item3b5e5fb14b\"]/div/div[2]/div[5]/div[1]/div[1]/span")
    WebElement itemPrice;

    // Constructor to initialize elements
    public ResultSearchPageTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method Used In Products Page
    public void selectFirstProduct() {

        String mainWindowHandle = driver.getWindowHandle();
        firstProduct.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public double assertPrice (){
        String priceText = itemPrice.getText();
        System.out.println("Price of the first item: " + priceText);
        double actualPrice = Double.parseDouble(priceText.replace("$", "").replace(",", ""));
        System.out.println("Parsed Price: " + actualPrice);
        return actualPrice;
    }
}
