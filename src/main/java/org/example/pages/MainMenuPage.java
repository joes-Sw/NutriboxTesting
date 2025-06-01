package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenuPage {
    private WebDriver driver;
    private By infoKesehatanButton = By.xpath("//a[@href='/app/info-kesehatan']");

    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInfoKesehatan() {
        driver.findElement(infoKesehatanButton).click();
    }
}
