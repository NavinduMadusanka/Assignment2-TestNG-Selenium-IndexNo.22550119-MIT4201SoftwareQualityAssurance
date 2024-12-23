package SubPagesTestCasesEbay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckProductPageConditionsTestCaseEbay {
    WebDriver driver;

    By buyItNow = By.xpath("//*[@id='item4bfb4f6c70']/div/div[2]/div[3]/div[1]/div[2]/span");
    By freeShipping = By.xpath("//*[@id='item4bfb4f6c70']/div/div[2]/div[3]/div[1]/div[3]/span");
    By fromUnitedStates = By.xpath("//*[@id='item4bfb4f6c70']/div/div[2]/div[3]/div[1]/div[4]/span");
    By freeReturns = By.xpath("//*[@id='item4bfb4f6c70']/div/div[2]/div[3]/div[1]/div[5]/span");

    public CheckProductPageConditionsTestCaseEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkProductConditions() {
        WebElement buyItNowElement = driver.findElement(buyItNow);
        WebElement freeShippingElement = driver.findElement(freeShipping);
        WebElement fromUnitedStatesElement = driver.findElement(fromUnitedStates);
        WebElement freeReturnsElement = driver.findElement(freeReturns);

        return buyItNowElement.isDisplayed() && freeShippingElement.isDisplayed() &&
                fromUnitedStatesElement.isDisplayed() && freeReturnsElement.isDisplayed();
    }
}