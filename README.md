<div align="center">
  <h1>Nutribox - Uji Otomatisasi Web (UI Testing)</h1>
</div>
<hr>

<p>
  Repositori ini berisi serangkaian skrip uji otomatisasi antarmuka pengguna (UI) untuk aplikasi web <b>Nutribox</b>. Proyek ini dibangun menggunakan <b>Java</b> dengan <b>Selenium WebDriver</b> untuk mengotomatiskan interaksi browser dan mengikuti pola desain <b>Page Object Model (POM)</b> untuk keterbacaan dan pemeliharaan kode yang lebih baik.
</p>

<br>

<h2>📝 Deskripsi Proyek</h2>
<p>
  Tujuan dari proyek ini adalah untuk memverifikasi fungsionalitas utama dari aplikasi web Nutribox secara otomatis. Pengujian mencakup alur kerja krusial seperti login pengguna, manajemen profil, dan navigasi di seluruh aplikasi untuk memastikan setiap fitur berfungsi seperti yang diharapkan.
</p>

<h2>✨ Fitur yang Diuji</h2>
<p>Skrip pengujian yang ada mencakup beberapa skenario utama:</p>
<ul>
  <li><b>Otentikasi Pengguna:</b> Memastikan pengguna dapat login dan logout dari aplikasi dengan sukses.</li>
  <li><b>Manajemen Profil:</b> Menguji fungsionalitas untuk melihat dan mengedit detail profil pengguna.</li>
  <li><b>Navigasi Aplikasi:</b> Memverifikasi bahwa navigasi antara halaman-halaman utama berfungsi dengan benar, seperti:
    <ul>
      <li>Beranda ke Info Kesehatan.</li>
      <li>Info Kesehatan ke Artikel Spesifik.</li>
      <li>Beranda ke Resep Makanan.</li>
    </ul>
  </li>
  <li><b>Interaksi Halaman:</b> Menguji interaksi di dalam halaman, seperti melihat kategori resep.</li>
</ul>

<h2>🛠️ Tumpukan Teknologi</h2>
<ul>
  <li><b>Bahasa Pemrograman:</b> Java</li>
  <li><b>Framework Otomatisasi:</b> Selenium WebDriver</li>
  <li><b>Alat Build & Manajemen Dependensi:</b> Apache Maven</li>
  <li><b>Framework Pengujian:</b> TestNG / JUnit (tergantung konfigurasi di <code>pom.xml</code>)</li>
  <li><b>Pola Desain:</b> Page Object Model (POM)</li>
</ul>

<h2>📂 Struktur Proyek</h2>
<p>Struktur proyek diatur untuk memisahkan logika halaman dari skrip pengujian, sesuai dengan praktik terbaik Page Object Model.</p>
<pre style="background-color: #f6f8fa; padding: 15px; border-radius: 5px; border: 1px solid #dfe2e5;">
<code>
NutriboxTesting/
├── .idea/                          # Direktori konfigurasi IntelliJ IDEA
├── src
│   ├── main
│   │   ├── java/org/example/
│   │   │   ├── pages/
│   │   │   │   ├── BasePage.java              #Kelas ini berisi fungsionalitas umum yang digunakan di banyak halaman, seperti inisialisasi WebDriver, method untuk explicit wait, dan method untuk mengklik tombol navigasi
│   │   │   │   ├── EditProfilePage.java       #Mewakili halaman login. Isinya adalah locator untuk kolom username, kolom password, dan tombol login.
│   │   │   │   ├── HomePage.java              #Mewakili halaman utama setelah pengguna berhasil login. Isinya bisa berupa method untuk memverifikasi bahwa login berhasil dan untuk berinteraksi dengan menu utama.
│   │   │   │   ├── InfoKesehatanPage.java     #Mengelola halaman daftar artikel "Info Kesehatan".
│   │   │   │   ├── LoginPage.java             #Mewakili halaman login dan mendefinisikan elemen-elemen untuk otentikasi.
│   │   │   │   ├── MainMenuPage.java          #Mewakili komponen navigasi utama (misalnya, bottom bar) yang berisi menu antar halaman.
│   │   │   │   ├── PlantBasedArticlePage.java #Mewakili halaman detail sebuah artikel spesifik untuk verifikasi konten.
│   │   │   │   ├── ProfilePage.java           #Mewakili halaman profil yang menampilkan data pengguna untuk diverifikasi.
│   │   │   │   └── ResepMakananPage.java      #Mewakili halaman yang menampilkan daftar "Resep Makanan" dan elemen interaksinya.
│   │   │   └── Main.java
│   │   └── resources/
│   └── test
│       └── java/
│           ├── EditProfileTest.java              #Berisi skenario pengujian untuk fungsionalitas login dan logout
│           ├── LoginLogoutTest.java              #Berisi skenario untuk menguji fungsionalitas edit profil, seperti mengubah nama atau foto profil, lalu memverifikasi bahwa perubahannya berhasil disimpan.
│           ├── NavigationTest.java               #Menguji alur navigasi antar halaman. Skenario ini memverifikasi pengguna bisa berpindah dari Beranda ke laman Info Kesehatan, membuka sebuah artikel, dan kembali lagi ke Beranda.
│           └── ResepMakananNavigationTest.java   #Skrip tes yang lebih spesifik untuk menguji navigasi di dalam fitur resep makanan, seperti mencari resep, memfilter, dan membuka detail resep.
├── target/                         # Direktori output build dari Maven
├── .gitignore                      # File untuk mengabaikan file yang tidak perlu dilacak Git
└── pom.xml                         # File konfigurasi Maven (dependensi dan build)
</code>
</pre>

<h2>⚙️ Prasyarat</h2>
<p>Sebelum Anda dapat menjalankan pengujian, pastikan sistem Anda memiliki:</p>
<ul>
  <li><b>Java Development Kit (JDK):</b> Versi 11 atau yang lebih baru.</li>
  <li><b>Apache Maven:</b> Terinstal dan dikonfigurasi di PATH sistem Anda.</li>
  <li><b>Browser Web:</b> Google Chrome atau Mozilla Firefox.</li>
  <li><b>WebDriver:</b>
    <ul>
      <li>Unduh WebDriver yang sesuai dengan browser dan versi Anda (misalnya, <code>ChromeDriver</code> untuk Chrome).</li>
      <li>Pastikan file executable WebDriver berada di direktori yang terdaftar dalam PATH sistem Anda, atau atur path-nya secara manual di dalam kode.</li>
    </ul>
  </li>
</ul>

<h2>🚀 Instalasi & Menjalankan Tes</h2>
<p>Ikuti langkah-langkah ini untuk menjalankan skrip pengujian di lingkungan lokal Anda.</p>
<ol>
  <li>
    <b>Clone Repositori</b>
    <pre style="background-color: #f6f8fa; padding: 15px; border-radius: 5px; border: 1px solid #dfe2e5;">
<code class="language-bash">
git clone https://github.com/joes-Sw/NutriboxTesting.git
cd NutriboxTesting
</code>
    </pre>
  </li>
  <li>
    <b>Jalankan Tes menggunakan Maven</b>
    <p>Buka terminal atau command prompt di direktori root proyek dan jalankan perintah Maven berikut:</p>
    <pre style="background-color: #f6f8fa; padding: 15px; border-radius: 5px; border: 1px solid #dfe2e5;">
<code class="language-bash">
mvn clean test
</code>
    </pre>
    <p>Perintah ini akan secara otomatis:</p>
    <ul>
      <li>Membersihkan proyek dari build sebelumnya (<code>clean</code>).</li>
      <li>Mengunduh semua dependensi yang didefinisikan di <code>pom.xml</code>.</li>
      <li>Mengompilasi kode sumber dan kode tes.</li>
      <li>Menjalankan semua skrip pengujian yang berada di dalam direktori <code>src/test/java</code>.</li>
    </ul>
    <p>Anda akan melihat browser terbuka secara otomatis dan melakukan serangkaian tindakan sesuai dengan skenario pengujian. Hasil tes akan ditampilkan di terminal setelah eksekusi selesai.</p>
  </li>
</ol>

<h2>📄 Page Objects yang Tersedia</h2>
<p>Proyek ini telah mengimplementasikan beberapa Page Object untuk memodelkan halaman-halaman di aplikasi web Nutribox:</p>
<table style="width:100%; border-collapse: collapse;">
  <tr style="background-color: #f6f8fa;">
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>BasePage</code></td>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>EditProfilePage</code></td>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>HomePage</code></td>
  </tr>
  <tr>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>InfoKesehatanPage</code></td>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>LoginPage</code></td>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>MainMenuPage</code></td>
  </tr>
  <tr style="background-color: #f6f8fa;">
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>PlantBasedArticlePage</code></td>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>ProfilePage</code></td>
    <td style="padding: 8px; border: 1px solid #dfe2e5;"><code>ResepMakananPage</code></td>
  </tr>
</table>
