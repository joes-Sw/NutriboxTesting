
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pages.LoginPage;
import org.example.pages.HomePage;

import java.time.Duration;

public class LoginLogoutTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void loginAndLogoutTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://nutriplate.id/app/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        // Perform login
        loginPage.login("Cek123@gmail.com", "Cek123@gmail.com");

        // Tunggu halaman dashboard
        Thread.sleep(3000);
        Assertions.assertTrue(homePage.isLoggedIn(), "User should be logged in");

        // Perform logout
        homePage.logout();

        // Tunggu redirect
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"), "User should be redirected to login after logout");

        driver.quit();
    }
}
