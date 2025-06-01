package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoKesehatanPage {
    private WebDriver driver;
    private By plantBasedArticle = By.xpath("//a[contains(@href, '/app/info-kesehatan') and contains(., 'Plant-Based Nutrition Guide')]");
    private By navHome = By.xpath("/html/body/div/div[2]/a[1]");

    public InfoKesehatanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlantBasedArticle() {
        driver.findElement(plantBasedArticle).click();
    }

    public void clickHomeFromBottomNav() {
        driver.findElement(navHome).click();
    }
}
