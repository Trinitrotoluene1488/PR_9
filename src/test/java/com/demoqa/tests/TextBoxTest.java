package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.TextBoxPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Epic("Elements")
    @Feature("Text Box")
    @Story("Отправка формы с валидными данными")
    @Owner("John Doe")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка успешной отправки формы Text Box на DemoQA")
    @Test
    public void shouldSubmitValidData() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.navigate();
        textBoxPage.fillFullName("John Doe");
        textBoxPage.fillEmail("john.doe@example.com");
        textBoxPage.fillCurrentAddress("123 Main Street, City, Country");
        textBoxPage.fillPermanentAddress("456 Oak Avenue, City, Country");
        textBoxPage.submit();
        Assert.assertTrue(textBoxPage.isOutputDisplayed());
        Assert.assertTrue(textBoxPage.getOutputName().contains("John Doe"));
        Assert.assertTrue(textBoxPage.getOutputEmail().contains("john.doe@example.com"));
        Assert.assertTrue(textBoxPage.getOutputCurrentAddress().contains("123 Main Street"));
        Assert.assertTrue(textBoxPage.getOutputPermanentAddress().contains("456 Oak Avenue"));
    }

    @Epic("Elements")
    @Feature("Text Box")
    @Story("Валидация email адреса")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка валидации невалидного email адреса")
    @Test
    public void shouldValidateInvalidEmail() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.navigate();
        textBoxPage.fillFullName("John Doe");
        textBoxPage.fillEmail("invalid-email");
        textBoxPage.fillCurrentAddress("123 Main Street, City, Country");
        textBoxPage.fillPermanentAddress("456 Oak Avenue, City, Country");
        textBoxPage.submit();
        String emailOutput = textBoxPage.getOutputEmail();
        Assert.assertTrue(emailOutput.isEmpty());
    }

}

