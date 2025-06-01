package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResepMakananPage extends BasePage {

    public ResepMakananPage(WebDriver driver) {
        super(driver);
    }

    private By resepMakananMenu = By.xpath("//a[@href='/app/resep-makanan']");
    private By backButton = By.xpath("//a[contains(@href, '/app/resep-makanan')]");
    private By berandaButton = By.xpath("/html/body/div/div[2]/a[1]");

    public void openResepMakanan() {
        click(resepMakananMenu);
        pause(1000);
    }

    public void openKategori(String namaKategori) {
        By kategoriButton = By.xpath("//h3[contains(text(), '" + namaKategori + "')]/ancestor::div[contains(@class, 'flex')][1]//button[contains(text(), 'Lihat Resep')]");

        click(kategoriButton);
        pause(1000);
        click(backButton);
        pause(1000);
    }

    public void openSemuaResep() {
        click(By.xpath("//button[contains(text(), 'Lihat Semua')]"));
        pause(1000);
        click(backButton);
        pause(1000);
    }

    public void kembaliKeBeranda() {
        click(berandaButton);
        pause(1000);
    }
}
