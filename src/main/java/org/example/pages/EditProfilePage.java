package org.example.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfilePage {
        WebDriver driver;
        WebDriverWait wait;

        private By savechangeButton = By.xpath("/html/body/div/div/div/div[2]/div[2]/form/div[9]/button[2]");

        public EditProfilePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

    private void clearAndType(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click(); // focus
        element.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        element.sendKeys(Keys.DELETE); // delete selected
        element.sendKeys(value); // type new value
    }

    public void setName(String name) {
        clearAndType(By.cssSelector("input[placeholder='Masukkan nama']"), name);
    }

    public void setEmail(String email) {
        clearAndType(By.cssSelector("input[type='email']"), email);
    }

    public void setBirthDate(String date) {
        clearAndType(By.cssSelector("input[type='date'], input[name='birthDate']"), date);
    }

    public void setHeight(String height) {
        clearAndType(By.name("height"), height);
    }

    public void setWeight(String weight) {
        clearAndType(By.name("weight"), weight);
    }

    public void setDiseaseHistory(String text) {
        clearAndType(By.name("medicalHistory"), text);
    }
        public void clickSaveChanges() {
//            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("/html/body/div/div/div/div[2]/div[2]/form/div[9]/button[2]")));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(savechangeButton));

            // Scroll ke elemen menggunakan JavaScript (terjamin berhasil)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);

            // Tunggu elemen bisa diklik
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
            saveButton.click();
        }
}
