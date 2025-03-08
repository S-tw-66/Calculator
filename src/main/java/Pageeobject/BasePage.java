package Pageeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Select selectValue;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public String getText(By elementLocation){
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }
    public void click(By elementLocation){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }
    public void writeText(By elementLocation, String text){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).sendKeys(text);
    }
    public void select (By elementLocation ,String selectByValue){
        waitVisibility(elementLocation);
        selectValue = new Select(driver.findElement(elementLocation));
        selectValue.selectByValue(selectByValue);
    }


    public void waitVisibility(By by){
        try{
            Thread.sleep(1000); // wait for 5 seconds
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
