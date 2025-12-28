package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Epic("Alerts, Frame & Windows")
    @Feature("Alerts")
    @Story("Подтверждение alert")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка подтверждения alert")
    @Test
    public void shouldAcceptAlert() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.navigate();
        alertsPage.clickAlertButton();
        alertsPage.acceptAlert();
    }

    @Epic("Alerts, Frame & Windows")
    @Feature("Alerts")
    @Story("Отклонение alert")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отклонения alert")
    @Test
    public void shouldDismissAlert() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.navigate();
        alertsPage.clickConfirmButton();
        alertsPage.dismissAlert();
        String result = alertsPage.getConfirmResult();
        Assert.assertTrue(result.contains("Cancel"));
    }

    @Epic("Alerts, Frame & Windows")
    @Feature("Alerts")
    @Story("Работа с prompt")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка работы с prompt alert")
    @Test
    public void shouldHandlePrompt() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.navigate();
        alertsPage.clickPromptButton();
        alertsPage.sendTextToPrompt("Test User");
        String result = alertsPage.getPromptResult();
        Assert.assertTrue(result.contains("Test User"));
    }

}

