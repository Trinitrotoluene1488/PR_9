package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {

    private By doubleClickButton = By.id("doubleClickBtn");
    private By rightClickButton = By.id("rightClickBtn");
    private By clickButton = By.xpath("//button[text()='Click Me']");
    private By doubleClickMessage = By.id("doubleClickMessage");
    private By rightClickMessage = By.id("rightClickMessage");
    private By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Buttons page")
    public void navigate() {
        driver.get("https://demoqa.com/buttons");
    }

    @Step("Perform double click on button")
    public void doubleClickButton() {
        Actions actions = new Actions(driver);
        WebElement button = waitForElement(doubleClickButton);
        actions.doubleClick(button).perform();
    }

    @Step("Perform right click on button")
    public void rightClickButton() {
        Actions actions = new Actions(driver);
        WebElement button = waitForElement(rightClickButton);
        actions.contextClick(button).perform();
    }

    @Step("Click the button")
    public void clickButton() {
        click(clickButton);
    }

    @Step("Get double click message")
    public String getDoubleClickMessage() {
        if (isElementPresent(doubleClickMessage)) {
            return getText(doubleClickMessage);
        }
        return "";
    }

    @Step("Get right click message")
    public String getRightClickMessage() {
        if (isElementPresent(rightClickMessage)) {
            return getText(rightClickMessage);
        }
        return "";
    }

    @Step("Get dynamic click message")
    public String getDynamicClickMessage() {
        if (isElementPresent(dynamicClickMessage)) {
            return getText(dynamicClickMessage);
        }
        return "";
    }

}

