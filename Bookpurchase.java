import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bookpurchase {
    //Nesne olusturma
    private Membermanagement memberManagement; 
    private BookManage bookManage;  

    // Constructor, memberManagement ve bookManage nesnelerini alarak sınıfı başlatır
    public Bookpurchase(Membermanagement memberManagement, BookManage bookManage) {
        this.memberManagement = memberManagement;
        this.bookManage = bookManage;
    }

    // Kitap iade fonksiyonu
    public void returnBook() {
        Scanner scanner = new Scanner(System.in);  // Kullanıcıdan veri almak için Scanner nesnesi
        
        // Üye numarasını al
        System.out.print("Kitap iade etmek isteyen üyenin numarasını giriniz: ");
        String memberNumber = scanner.nextLine();  // Kullanıcıdan üye numarasını al

        // Kitap ISBN numarasını al
        System.out.print("İade etmek istediğiniz kitabın ISBN numarasını giriniz: ");
        String bookISBN = scanner.nextLine();  // Kullanıcıdan kitap ISBN numarasını al
        
        // Kitap bulunup durumu güncelleniyor
        boolean bookFound = false;
        for (String[] book : bookManage.books) {  // Kitapları döngüyle kontrol et
            if (book[2].equals(bookISBN) && book[3].equals("Ödünç Alındı")) {  // Kitap ödünç alınmışsa
                // Kitap durumu "Müsait" olarak güncelle
                book[3] = "Müsait";  // Kitap durumunu "Müsait" yap

                // Tarihi SimpleDateFormat ile almak
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Tarih formatını belirle
                String returnDate = sdf.format(new Date());  // Bugünün tarihini al
                book[5] = returnDate;  // Kitabın iade tarihini ekle
                
                // İade işlemine dair kullanıcıya bilgi ver
                System.out.println("Kitap başarıyla iade edildi.");
                System.out.println("İade Tarihi: " + returnDate);  // İade tarihini yazdır

                // Üye ödünç geçmişinden kitabı kaldır
                for (String[] member : memberManagement.members) {  // Üyeleri kontrol et
                    if (member[2].equals(memberNumber)) {  // Üye numarası eşleşiyorsa
                        member[4] = member[4].replace(book[0] + " (" + bookISBN + "), ", "");  // Kitap geçmişinden çıkar
                        System.out.println("Üye ödünç geçmişi güncellendi.");  // Güncelleme işlemi yapıldığını bildir
                        break;  // Döngüden çık
                    }
                }
                bookFound = true;  // Kitap bulundu, işlemi tamamla
                break;  // Döngüden çık
            }
        }

        if (!bookFound) {  // Kitap bulunamadıysa
            System.out.println("Kitap bulunamadı veya kitap zaten iade edilmemiş.");
        }
    }
}
