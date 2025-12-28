package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.BrowserWindowsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Epic("Alerts, Frame & Windows")
    @Feature("Browser Windows")
    @Story("Открытие новой вкладки")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка открытия новой вкладки, переключения контекста, проверки содержимого и закрытия")
    @Test
    public void shouldOpenNewTab() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.navigate();
        String mainWindow = browserWindowsPage.getCurrentWindowHandle();
        browserWindowsPage.clickNewTabButton();
        browserWindowsPage.switchToNewTab();
        String heading = browserWindowsPage.getSampleHeading();
        Assert.assertTrue(heading.contains("sample"));
        browserWindowsPage.closeCurrentTab();
        browserWindowsPage.switchToMainWindow(mainWindow);
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
    }

}

