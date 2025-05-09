import java.util.Scanner;
import java.time.LocalDate;

public class Main 
{
    public static void main(String[] args) {
        //Nesne Olusturma Islemleri
        BookManage bookManage = new BookManage();
        Membermanagement memberManagement = new Membermanagement();
        Bookpurchase bookPurchase = new Bookpurchase(memberManagement, bookManage);
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //Arayuz Tasarım
        while (!exit) {
            System.out.println("\n=========================================");
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
            System.out.println("11. Uye Bilgi Guncelle");
            System.out.println("12. Uye Odunc Gecmisi Goruntule");
            System.out.println("13. Cikis");
            System.out.println("=========================================");
            System.out.print("Bir secim yapiniz: ");
            int choice = scanner.nextInt();
            //Secim Gerceklestirmek Icin Switch case yapisi
            switch (choice) {
                case 1:
                    System.out.println("\n--- Kitaplari Listele ---");
                    bookManage.ListBooks();//Kitapları Listeleme
                    break;
                case 2:
                    System.out.println("\n--- Yeni Kitap Ekle ---");
                    bookManage.addBook();//Kitap ekleme
                    break;
                case 3:
                    System.out.println("\n--- Kitap Sil ---");
                    bookManage.deleteBook();//Kitap Silme
                    break;
                case 4:
                    System.out.println("\n--- Kitap Ara (ISBN) ---");
                    bookManage.researchbook();//ISBN No ile kitap arama
                    break;
                case 5:
                    System.out.println("\n--- Uye Listele ---");
                    memberManagement.listMember();//Uye Listeleme
                    break;
                case 6:
                    System.out.println("\n--- Yeni Uye Ekle ---");
                    memberManagement.addMember();//Uye Ekleme
                    break;
                case 7:
                    System.out.println("\n--- Uye Sil ---");
                    memberManagement.deleteMember();//Uye Silme
                    break;
                case 8:
                    System.out.println("\n--- Uye Ara ---");
                    memberManagement.researchMember();//Uye arama
                    break;
                case 9:
                    System.out.println("\n--- Kitap Odunc Al ---");
                    bookManage.borrowBook();//Kitap Odunc Alma
                    break;
                case 10:
                    System.out.println("\n--- Kitap Iade Et ---");
                    bookPurchase.returnBook();//Kitap Iade Etme
                    break;
                case 11:
                    System.out.println("\n--- Uye Bilgi Guncelle ---");
                    memberManagement.updateMember();//Uye Bilgi Guncelleme
                    break;
                case 12:
                    System.out.println("\n--- Uye Odunc Gecmisi Goruntule ---");
                    memberManagement.viewBorrowHistory();//Tarih Gosterme
                    break;
                case 13:
                    System.out.println("Sistemden cikis yapiliyor...");
                    exit = true;
                    break;
                default:
                    System.out.println("Gecersiz secim, lutfen tekrar deneyiniz.");
            }
        }

        scanner.close();//Scanner Kapama 
        System.out.println("Sistemden basariyla cikis yapildi.");
    }
}
