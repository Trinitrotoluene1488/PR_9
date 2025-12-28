package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.DatePickerPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {

    @Epic("Widgets")
    @Feature("Date Picker")
    @Story("Выбор даты")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка выбора даты и подтверждения")
    @Test
    public void shouldSelectDate() {
        DatePickerPage datePickerPage = new DatePickerPage(driver);
        datePickerPage.navigate();
        String dateToSelect = "05/01/2024";
        datePickerPage.selectDate(dateToSelect);
        String selectedDate = datePickerPage.getSelectedDate();
        Assert.assertTrue(selectedDate.contains("2024"));
    }

}

