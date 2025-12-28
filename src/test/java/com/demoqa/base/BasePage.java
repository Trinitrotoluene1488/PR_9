package com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean isElementPresent(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }

    protected void click(By locator) {
        WebElement element = waitForElement(locator);
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

