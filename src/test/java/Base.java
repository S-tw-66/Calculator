import Pageeobject.HomePage;
//import Pageeobject.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
//import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v123.input.model.TouchPoint;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.print.DocFlavor;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Base {
    //    public static WebDriver driver;
//    public static AppiumDriver driver;
    public static AndroidDriver driver;
    public static JavascriptExecutor js;
    public static ChromeOptions options;
    public static ExtentReports extent;
    public static String reportPath = "C:\\Users\\shai6\\Desktop\\Automation course\\project\\class_28\\src\\testData\\Report.html";
    public static String configPath = "C:\\Users\\shai6\\Desktop\\Automation course\\project\\class_28\\src\\testData\\config.xml";
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static DesiredCapabilities configuration;
    HomePage homePage;


    //    LoginPage loginPage;
    @BeforeAll
    public static void setUp() throws Exception {
        spark = new ExtentSparkReporter(reportPath);
        spark.config().setTheme(Theme.DARK);
////        options = new ChromeOptions();
////        options.addArguments("--incognito");
////        driver = new ChromeDriver(options);
        extent = new ExtentReports();
        extent.attachReporter(spark);


//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        ----------------------------------------
//        configuration = new DesiredCapabilities();
//        configuration.setCapability("platformName", "android");
//        configuration.setCapability("appium:deviceName", "Android Device");
//        configuration.setCapability("appium:appPackage", "com.android.chrome");
//        configuration.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
//        configuration.setCapability("appium:noReset", true);
//        configuration.setCapability("appium:newCommandTimeout", 120);
//        configuration.setCapability("appium:hideKeyboard", true);
//        configuration.setCapability("appium:automationName", "UiAutomator2");
//        configuration.setCapability("appium:dontStopAppOnReset", true);
//
//        driver = new AndroidDriver(new URL("http://localhost:4723"), configuration);
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//        System.out.println("Application started");
        //*****************************
        configuration = new DesiredCapabilities();
        configuration.setCapability("platformName", "android");
        configuration.setCapability("appium:deviceName", "Android Device");
        configuration.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
        configuration.setCapability("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator");
//        configuration.setCapability("appium:noReset", true);
        configuration.setCapability("appium:newCommandTimeout", 120);
        configuration.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723"), configuration);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Application started");
    }


    @BeforeEach
    public void initTest() {
        homePage = new HomePage(driver);
//        loginPage = new LoginPage(driver);
    }

    @AfterAll
    public static void after() {
        driver.quit();
        extent.flush();
    }

    /// צילום מסך
    public void screenshot(String imageName) throws IOException {
        String path = "C:\\Users\\shai6\\Desktop\\Automation course\\project\\class_28\\src\\testData\\";
        File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        test.info(MediaEntityBuilder.createScreenCaptureFromPath(imageName + ".png").build());
        img.renameTo(new File(path + imageName + ".png"));
    }

    public static String readFromFile(String keyData, String pathName) throws ParserConfigurationException, IOException, SAXException {
        String data = "";
        try {
            // Load the XML file
            File xmlFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            // Normalize the document
            doc.getDocumentElement().normalize();
            // Extract values from XML
            data = doc.getElementsByTagName(keyData).item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

