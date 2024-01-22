package BasePage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.DriverManager;

public class BasePage {
	
	public BasePage() {

    }

    protected void clickElement(By by) {

        DriverManager.getDriver().findElement(by).click();
    }

    protected void enterInput(By by, String key) {

        DriverManager.getDriver().findElement(by).sendKeys(key);
    }

    protected WebElement getElement(By key) {

        return DriverManager.getDriver().findElement(key);
    }

    protected List<WebElement> getElements(By key) {

        return DriverManager.getDriver().findElements(key);
    }


    protected WebElement presenceOfElement(final By elementLocation) {

        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    protected void visibilityOfElement(final By elementLocation) {

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected WebElement elementToBeClickable(final By elementLocation) {

        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    protected void implicitWait() {

        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void MaximizeTheWindow() {

        DriverManager.getDriver().manage().window().maximize();
    }


}
