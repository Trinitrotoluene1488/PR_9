package com.demoqa.base;

import com.demoqa.utils.Attachments;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        prepareEnvironmentFile();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null && !result.isSuccess()) {
            Attachments.attachScreenshot(driver, "Failure screenshot");
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private void prepareEnvironmentFile() {
        try {
            Path allureResultsDir = Paths.get("target/allure-results");
            Files.createDirectories(allureResultsDir);
            Path envFile = allureResultsDir.resolve("environment.properties");
            Map<String, String> env = new HashMap<>();
            env.put("OS", "Windows 11");
            env.put("jdk.version", "17");
            env.put("browser", "Chrome 130");
            env.put("selenium", "4.38.0");
            env.put("testng", "7.10.2");
            StringBuilder content = new StringBuilder();
            for (Map.Entry<String, String> entry : env.entrySet()) {
                content.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
            }
            Files.write(envFile, content.toString().getBytes());
        } catch (Exception e) {
            System.err.println("Failed to create environment.properties: " + e.getMessage());
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}

