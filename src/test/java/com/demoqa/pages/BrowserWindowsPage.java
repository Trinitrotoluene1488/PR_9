package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    private By newTabButton = By.id("tabButton");
    private By newWindowButton = By.id("windowButton");
    private By newWindowMessageButton = By.id("messageWindowButton");
    private By sampleHeading = By.id("sampleHeading");

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Browser Windows page")
    public void navigate() {
        driver.get("https://demoqa.com/browser-windows");
    }

    @Step("Click new tab button")
    public void clickNewTabButton() {
        click(newTabButton);
    }

    @Step("Click new window button")
    public void clickNewWindowButton() {
        click(newWindowButton);
    }

    @Step("Click new window message button")
    public void clickNewWindowMessageButton() {
        click(newWindowMessageButton);
    }

    @Step("Switch to new tab")
    public void switchToNewTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @Step("Switch to main window")
    public void switchToMainWindow(String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }

    @Step("Close current tab")
    public void closeCurrentTab() {
        driver.close();
    }

    @Step("Get sample heading text")
    public String getSampleHeading() {
        if (isElementPresent(sampleHeading)) {
            return getText(sampleHeading);
        }
        return "";
    }

    @Step("Get current window handle")
    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

}

