package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.UploadAndDownloadPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UploadAndDownloadTest extends BaseTest {

    @Epic("Elements")
    @Feature("Upload and Download")
    @Story("Загрузка и подтверждение файла")
    @Owner("John Doe")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка загрузки файла и подтверждения пути")
    @Test
    public void shouldUploadFile() {
        UploadAndDownloadPage uploadPage = new UploadAndDownloadPage(driver);
        uploadPage.navigate();
        uploadPage.downloadFile();
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        File file = new File(downloadPath + "/sampleFile.jpeg");
        Assert.assertTrue(file.exists());
        uploadPage.uploadFile(file.getAbsolutePath());
        String uploadedPath = uploadPage.getUploadedFilePath();
        Assert.assertTrue(uploadedPath.contains("sampleFile"));
    }

}

