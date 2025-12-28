package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownloadPage extends BasePage {

    private By downloadButton = By.id("downloadButton");
    private By uploadButton = By.id("uploadFile");
    private By uploadedFilePath = By.id("uploadedFilePath");

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Upload and Download page")
    public void navigate() {
        driver.get("https://demoqa.com/upload-download");
    }

    @Step("Download file")
    public void downloadFile() {
        click(downloadButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Upload file: {filePath}")
    public void uploadFile(String filePath) {
        WebElement fileInput = driver.findElement(uploadButton);
        fileInput.sendKeys(filePath);
    }

    @Step("Get uploaded file path text")
    public String getUploadedFilePath() {
        if (isElementPresent(uploadedFilePath)) {
            return getText(uploadedFilePath);
        }
        return "";
    }

}

