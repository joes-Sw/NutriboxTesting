import org.example.pages.ProfilePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pages.LoginPage;
import org.example.pages.HomePage;
import org.example.pages.EditProfilePage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfileTest {
    @Test
    public void testEditProfileFullFlow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Setup awal
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://nutriplate.id/app/login");

            // Login
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.login("Cek123@gmail.com", "Cek123@gmail.com");

            // Navigasi ke profil
            homePage.goToProfile();

            // Klik ikon edit profil
            ProfilePage profilePage = new ProfilePage(driver);
            profilePage.clickEditProfile();

            // Isi form edit profil
            EditProfilePage editProfilePage = new EditProfilePage(driver);
            editProfilePage.setName("newname@gmail.com");
            editProfilePage.setEmail("newemail@gmail.com");
            editProfilePage.setBirthDate("2000-01-01");
            editProfilePage.setHeight("175");
            editProfilePage.setWeight("70");
            editProfilePage.setDiseaseHistory("asma");
            editProfilePage.clickSaveChanges();

            Thread.sleep(3000); // Sebaiknya diganti wait eksplisit

        } catch (Exception e) {
            e.printStackTrace(); // Cetak error ke console jika ada masalah
        } finally {
            driver.quit(); // Pastikan browser ditutup meski test gagal
        }
    }
}
