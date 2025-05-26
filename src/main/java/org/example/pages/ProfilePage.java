package org.example.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickEditProfile() {
        // XPath alternatif yang lebih toleran terhadap perubahan class
        By editIconButton = By.xpath("/html/body/div/div[1]/div[2]/div/div[1]/button");

        // Scroll & tunggu hingga tombol bisa diklik
        WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(editIconButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", editBtn);

        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
    }
}
