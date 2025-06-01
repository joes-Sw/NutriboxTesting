package org.example.pages;

import org.openqa.selenium.WebDriver;

public class PlantBasedArticlePage {
    private WebDriver driver;

    public PlantBasedArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
