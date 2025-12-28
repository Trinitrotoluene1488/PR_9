package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePickerPage extends BasePage {

    private By datePickerInput = By.id("datePickerMonthYearInput");
    private By dateAndTimePickerInput = By.id("dateAndTimePickerInput");

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Date Picker page")
    public void navigate() {
        driver.get("https://demoqa.com/date-picker");
    }

    @Step("Select date: {date}")
    public void selectDate(String date) {
        click(datePickerInput);
        sendKeys(datePickerInput, date);
    }

    @Step("Select date and time: {dateTime}")
    public void selectDateAndTime(String dateTime) {
        click(dateAndTimePickerInput);
        sendKeys(dateAndTimePickerInput, dateTime);
    }

    @Step("Get selected date value")
    public String getSelectedDate() {
        return driver.findElement(datePickerInput).getAttribute("value");
    }

    @Step("Get selected date and time value")
    public String getSelectedDateAndTime() {
        return driver.findElement(dateAndTimePickerInput).getAttribute("value");
    }

}

