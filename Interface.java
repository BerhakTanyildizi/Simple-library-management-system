import java.util.Scanner;

public class Interface {
    public int secim;

    // Ana menü arayüzü
    public void Arayuz() {
        System.out.println("=========================================");
        System.out.println("Kutuphane Yonetim Sistemi");
        System.out.println("=========================================");
        System.out.println("1. Kitaplari Listele");
        System.out.println("2. Yeni Kitap Ekle");
        System.out.println("3. Kitap Sil");
        System.out.println("4. Kitap Ara (ISBN)");
        System.out.println("5. Uye Listele");
        System.out.println("6. Yeni Uye Ekle");
        System.out.println("7. Uye Sil");
        System.out.println("8. Uye Ara");
        System.out.println("9. Kitap Odunc Al");
        System.out.println("10. Kitap Iade Et");
        System.out.println("11. Cikis");
        System.out.println("=========================================");

        System.out.print("Bir secim yapiniz: ");
        Scanner scanner = new Scanner(System.in);
        secim = scanner.nextInt(); // Kullanıcının seçim yapması
    }
}
