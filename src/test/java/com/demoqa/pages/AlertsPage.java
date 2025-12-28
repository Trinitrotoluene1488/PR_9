package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    private By alertButton = By.id("alertButton");
    private By confirmButton = By.id("confirmButton");
    private By promptButton = By.cssSelector("#promtButton");
    private By confirmResult = By.id("confirmResult");
    private By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Alerts page")
    public void navigate() {
        driver.get("https://demoqa.com/alerts");
    }

    @Step("Click alert button")
    public void clickAlertButton() {
        click(alertButton);
    }

    @Step("Accept alert")
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            throw new RuntimeException("Alert not present", e);
        }
    }

    @Step("Dismiss alert")
    public void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            throw new RuntimeException("Alert not present", e);
        }
    }

    @Step("Send text to alert prompt: {text}")
    public void sendTextToPrompt(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
        } catch (Exception e) {
            throw new RuntimeException("Alert not present", e);
        }
    }

    @Step("Click confirm button")
    public void clickConfirmButton() {
        click(confirmButton);
    }

    @Step("Click prompt button")
    public void clickPromptButton() {
        click(promptButton);
    }

    @Step("Get confirm result text")
    public String getConfirmResult() {
        if (isElementPresent(confirmResult)) {
            return getText(confirmResult);
        }
        return "";
    }

    @Step("Get prompt result text")
    public String getPromptResult() {
        if (isElementPresent(promptResult)) {
            return getText(promptResult);
        }
        return "";
    }

}

