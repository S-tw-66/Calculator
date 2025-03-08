package Pageeobject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    By titleStudent = By.cssSelector(".saFormHeaderProd");
    By student = By.linkText("Student");
    By teaching = By.linkText("Teaching Assistant");
    By here = By.linkText("here");
    By instructor = By.cssSelector("#ibox_form_body > div > ul > li:nth-child(3) > a");
    By classId = By.cssSelector(".ip_valid_inidicator #id");
    By emptyElement = By.cssSelector(".__validate");
    By titleLogClassId = By.cssSelector("._hint");
    By firstName = By.cssSelector("#firstname.__required");
    By titleLogFirstName = By.cssSelector("._hint");
    By titleLogUEmail = By.cssSelector("._hint");
    By email = By.cssSelector("#email.__required");
    By classKey = By.cssSelector(".ip_text_field #join_password");
    By lastName = By.cssSelector(".ip_valid_inidicator #lastname");
    By displayNames = By.cssSelector("#last_space_first");
    By emailConfirm = By.cssSelector(".ip_valid_inidicator #email_confirm");
    By password = By.cssSelector(".ip_text_field #password1");
    By passwordConfirm = By.cssSelector(".ip_text_field #password2");
    By secretQuestion = By.cssSelector("[name='secret_question']");
    By questionAnswer = By.cssSelector("#secret_answer");
    By submit = By.cssSelector("[type='submit']");
    By robot = By.cssSelector(".recaptcha-checkbox-border");
    By seven = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07");
    By five = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05");
    By plus = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add");
    By minus = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub");
    By multiply = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul");
    By divide = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String VerifyHeader() {
        return getText(titleStudent);
    }

    public HomePage clickStudent() {
        click(student);
        return this;
    }

    public HomePage clickAndWrite(String test) {
        click(classId);
        writeText(classId, test);
        return this;
    }

    public HomePage clickEmptyElement() {
        click(emptyElement);
        return this;
    }

    public String checkValidClassId() {
        return getText(titleLogClassId);
    }

    public HomePage clickOnFieldUserName() {
        click(firstName);
        click(emptyElement);
        return this;
    }

    public String checkLogFirstName() {
        return getText(titleLogFirstName);
    }

    public HomePage clickOnFieldUEmailAndWrite(String text) {
        click(email);
        writeText(email, text);
        click(emptyElement);
        return this;
    }

    public String checkLogEmail() {
        return getText(titleLogUEmail);
    }

    /// לטפל
    public HomePage createNewStudent() {
        writeText(classId,"2222");
//        driver.findElement(By.cssSelector(".ip_valid_inidicator #id")).sendKeys("2222");
        writeText(classKey,"1996");
//        driver.findElement(By.cssSelector(".ip_text_field #join_password")).sendKeys("1996");
        writeText(firstName,"shai");
//        driver.findElement(By.cssSelector(".ip_valid_inidicator #firstname")).sendKeys("shai");
        writeText(lastName,"twito");
//        driver.findElement(By.cssSelector(".ip_valid_inidicator #lastname")).sendKeys("twito");
        click(displayNames);
//        driver.findElement(By.cssSelector("#last_space_first")).click();
        writeText(email,"she@gmail.com");
//        driver.findElement(By.cssSelector(".ip_valid_inidicator #email")).sendKeys("she@gmail.com");
        writeText(emailConfirm,"she@gmail.com");
//        driver.findElement(By.cssSelector(".ip_valid_inidicator #email_confirm")).sendKeys("she@gmail.com");
        writeText(password,"=zD/TP/n8rRFH3i");
//        driver.findElement(By.cssSelector(".ip_text_field #password1")).sendKeys("=zD/TP/n8rRFH3i");
        writeText(passwordConfirm,"=zD/TP/n8rRFH3i");
//        driver.findElement(By.cssSelector(".ip_text_field #password2")).sendKeys("=zD/TP/n8rRFH3i");
        select(secretQuestion,"14");
//        Select selectValue = new Select(driver.findElement(By.cssSelector("[name='secret_question']")));
//        selectValue.selectByValue("14");
        writeText(questionAnswer,"love");
//        driver.findElement(By.cssSelector("#secret_answer")).sendKeys("love");
//        driver.findElement(By.cssSelector(".cancel")).click();
        driver.switchTo().frame(driver.findElement(By.name("a-nm5qaraete19")));
        click(robot);
        click(submit);
//        driver.findElement(By.cssSelector("[type='submit']")).click();
        return this;
    }

    public String nameTub() {
        return driver.getTitle();
    }


    public HomePage verifyLinkStudent() {
        click(student);
        return this;
    }
    public HomePage verifyLinkTeaching(){
        click(teaching);
        return this;
    }
    public HomePage verifyLinkInstructor() {
        click(instructor);
        return this;
    }
    public HomePage verifyLinkHere() {
        click(here);
        return this;
    }

    public void switchTestSeven(String value) {
        switch (value) {
            case "1":
                click(seven);
                break;
            case "2":
                click(seven);
                break;
            case "3":
                click(seven);
                break;
            case "4":
                click(seven);
                break;
            case "5":
                click(seven);
                break;
            case "6":
                click(seven);
                break;
            case "7":
                click(seven);
                break;
            case "8":
                click(seven);
                break;
            case "9":
                click(seven);
                break;
            case "0":
                click(seven);
                break;
            default:
                System.out.println("is not found");
        }

    }
    public void switchTestFive(String value) {
        switch (value) {
            case "1":
                click(five);
                break;
            case "2":
                click(five);
                break;
            case "3":
                click(five);
                break;
            case "4":
                click(five);
                break;
            case "5":
                click(five);
                break;
            case "6":
                click(five);
                break;
            case "7":
                click(five);
                break;
            case "8":
                click(five);
                break;
            case "9":
                click(five);
                break;
            case "0":
                click(five);
                break;
            default:
                System.out.println("is not found");
        }

    }
    public void plus(){
        click(plus);
    }
    public void minus(){
        click(minus);
    }
    public void multiply(){
        click(multiply);
    }
    public void divide(){
        click(divide);
    }
    public List<Runnable> getOperations() {
        List<Runnable> operations = new ArrayList<>();
        operations.add(this::plus);
        operations.add(this::minus);
        operations.add(this::multiply);
        operations.add(this::divide);
        return operations;
    }
}