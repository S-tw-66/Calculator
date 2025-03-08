import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v123.input.model.TouchPoint;
import org.xml.sax.SAXException;

import javax.security.auth.login.AppConfigurationEntry;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HomeTest extends Base {

    @Test
    public void test_1() {
        test = extent.createTest("test_1", "Verify header for student page");
        homePage.clickStudent();
        try {
            Assertions.assertEquals("Create a New Student Profile", homePage.VerifyHeader());
            test.pass("Title found ");
        } catch (AssertionError e) {
            test.fail("The title Not found " + e.getMessage());
        }
    }

    @Test
    public void test_2() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")).click();
        driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")).sendKeys("חדשות 12");
//        driver.pressKeyCode(AndroidKey.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

//        driver.findElement(By.linkText("לא תודה")).click();
//        driver.findElement(By.cssSelector("#com.android.chrome:id/search_box_text")).click();
//        driver.findElement(By.cssSelector(".android.widget.Button")).click();
    }
    @Test
    public void test_3() throws Exception {
        Random random = new Random();
        test = extent.createTest("test_3", "Verify calculator");
        try {
            homePage.switchTestSeven(readFromFile("num1", configPath));
            homePage.getOperations().get(0).run();
            homePage.switchTestFive(readFromFile("num2", configPath));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(1000);
            screenshot("gg");
            Assertions.assertEquals(driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText(),"12 תוצאת החישוב");
            test.pass("Calculator passed");
            homePage.switchTestSeven(readFromFile("num1", configPath));
            homePage.getOperations().get(1).run();
            homePage.switchTestFive(readFromFile("num2", configPath));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(1000);
            screenshot("hhh");
            Assertions.assertEquals(driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText(),"2 תוצאת החישוב");
            test.pass("Calculator passed");
            homePage.switchTestSeven(readFromFile("num1", configPath));
            homePage.getOperations().get(2).run();
            homePage.switchTestFive(readFromFile("num2", configPath));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(1000);
            screenshot("jj");
            Assertions.assertEquals(driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText(),"35 תוצאת החישוב");
            test.pass("Calculator passed");
            homePage.switchTestSeven(readFromFile("num1", configPath));
            homePage.getOperations().get(3).run();
            homePage.switchTestFive(readFromFile("num2", configPath));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(1000);
            screenshot("aaa");
            Assertions.assertEquals(driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText(),"1.4 תוצאת החישוב");
            test.pass("Calculator passed");
        }catch (AssertionError e){
            test.fail("Title not expected "+e.getLocalizedMessage());
        }
    }
}