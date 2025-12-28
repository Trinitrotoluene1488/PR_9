package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {

    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressTextArea = By.id("currentAddress");
    private By permanentAddressTextArea = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputName = By.id("name");
    private By outputEmail = By.id("email");
    private By outputCurrentAddress = By.cssSelector("#output #currentAddress");
    private By outputPermanentAddress = By.cssSelector("#output #permanentAddress");
    private By emailError = By.cssSelector("input.userEmail.field-error");
    private By outputDiv = By.id("output");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Text Box page")
    public void navigate() {
        driver.get("https://demoqa.com/text-box");
    }

    @Step("Fill full name field with: {name}")
    public void fillFullName(String name) {
        sendKeys(fullNameInput, name);
    }

    @Step("Fill email field with: {email}")
    public void fillEmail(String email) {
        sendKeys(emailInput, email);
    }

    @Step("Fill current address field with: {address}")
    public void fillCurrentAddress(String address) {
        sendKeys(currentAddressTextArea, address);
    }

    @Step("Fill permanent address field with: {address}")
    public void fillPermanentAddress(String address) {
        sendKeys(permanentAddressTextArea, address);
    }

    @Step("Submit the form")
    public void submit() {
        click(submitButton);
    }

    @Step("Verify output is displayed")
    public boolean isOutputDisplayed() {
        return isElementPresent(outputDiv);
    }

    @Step("Get output name text")
    public String getOutputName() {
        if (isElementPresent(outputName)) {
            return getText(outputName);
        }
        return "";
    }

    @Step("Get output email text")
    public String getOutputEmail() {
        if (isElementPresent(outputEmail)) {
            return getText(outputEmail);
        }
        return "";
    }

    @Step("Get output current address text")
    public String getOutputCurrentAddress() {
        if (isElementPresent(outputCurrentAddress)) {
            return getText(outputCurrentAddress);
        }
        return "";
    }

    @Step("Get output permanent address text")
    public String getOutputPermanentAddress() {
        if (isElementPresent(outputPermanentAddress)) {
            return getText(outputPermanentAddress);
        }
        return "";
    }

    @Step("Verify email error is displayed")
    public boolean isEmailErrorPresent() {
        return isElementPresent(emailError);
    }

}

