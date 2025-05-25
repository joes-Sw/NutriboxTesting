package org.example.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By profileMenu = By.xpath("//a[@href='/app/profile']");
    private By logoutButton = By.xpath("//button[contains(text(),'Logout')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProfile() {
        driver.findElement(profileMenu).click();
    }

    public void logout() {
        goToProfile();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));

        // Scroll ke elemen menggunakan JavaScript (terjamin berhasil)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutBtn);

        // Tunggu elemen bisa diklik
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }

    public boolean isLoggedIn() {
        return driver.getCurrentUrl().contains("/app");
    }
}
