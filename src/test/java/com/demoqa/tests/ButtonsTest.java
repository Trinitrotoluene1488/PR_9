package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.ButtonsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Epic("Elements")
    @Feature("Buttons")
    @Story("Двойной клик на кнопке")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка двойного клика на кнопке")
    @Test
    public void shouldPerformDoubleClick() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigate();
        buttonsPage.doubleClickButton();
        String message = buttonsPage.getDoubleClickMessage();
        Assert.assertTrue(message.contains("double"));
    }

    @Epic("Elements")
    @Feature("Buttons")
    @Story("Клик правой кнопкой мыши")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка клика правой кнопкой мыши на кнопке")
    @Test
    public void shouldPerformRightClick() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigate();
        buttonsPage.rightClickButton();
        String message = buttonsPage.getRightClickMessage();
        Assert.assertTrue(message.contains("right"));
    }

    @Epic("Elements")
    @Feature("Buttons")
    @Story("Обычный клик на кнопке")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка обычного клика на кнопке")
    @Test
    public void shouldPerformClick() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigate();
        buttonsPage.clickButton();
        String message = buttonsPage.getDynamicClickMessage();
        Assert.assertTrue(message.contains("dynamic"));
    }

}

