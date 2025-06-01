

import org.example.pages.MainMenuPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pages.LoginPage;
import org.example.pages.InfoKesehatanPage;
import org.example.pages.PlantBasedArticlePage;

public class NavigationTest {
    @Test
    public void testInfoKesehatanToArticleAndBack() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Buka halaman login
        driver.get("https://nutriplate.id/app/login");

        // Inisialisasi login dan login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("newemail@gmail.com", "Cek123@gmail.com");

        // Tunggu login selesai
        Thread.sleep(3000);

        // Inisialisasi halaman-halaman lainnya
        MainMenuPage home = new MainMenuPage(driver);
        InfoKesehatanPage info = new InfoKesehatanPage(driver);
        PlantBasedArticlePage article = new PlantBasedArticlePage(driver);

        // Navigasi dari Home → Info Kesehatan → Artikel
        home.clickInfoKesehatan();
        Thread.sleep(2000);

        info.clickPlantBasedArticle();
        Thread.sleep(2000);

        System.out.println("Opened Article URL: " + article.getCurrentUrl());

        // Kembali ke Info Kesehatan
        driver.navigate().back();
        Thread.sleep(1000);

        // Kembali ke Home lewat bottom nav
        info.clickHomeFromBottomNav();
        Thread.sleep(2000);

        // Tutup browser
        driver.quit();
    }
}
