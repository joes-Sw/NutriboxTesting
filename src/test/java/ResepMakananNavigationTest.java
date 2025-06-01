import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pages.LoginPage;
import org.example.pages.ResepMakananPage;

import java.time.Duration;

public class ResepMakananNavigationTest {

    WebDriver driver;
    LoginPage loginPage;
    ResepMakananPage resepMakananPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://nutriplate.id/app/login");
        loginPage = new LoginPage(driver);
        loginPage.login("newemail@gmail.com", "Cek123@gmail.com");
        resepMakananPage = new ResepMakananPage(driver);
    }

    @Test
    public void testNavigasiKategoriResep() {
        resepMakananPage.openResepMakanan();

        resepMakananPage.openKategori("Makan Pagi");
        resepMakananPage.openKategori("Makan Siang");
        resepMakananPage.openKategori("Makan Malam");
        resepMakananPage.openSemuaResep();

        resepMakananPage.kembaliKeBeranda();

        Assertions.assertTrue(driver.getCurrentUrl().contains("/app"), "Seharusnya kembali ke beranda");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
