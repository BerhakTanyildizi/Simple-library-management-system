import java.util.Scanner;

public class Bookreturn {
    public BookManage bookManage = new BookManage();  // Kitap yönetimi
    public Membermanagement memberManage = new Membermanagement();  // Üye yönetimi

    public void returnBook() 
    {
        
        Scanner scanner = new Scanner(System.in);
        
        // Üye bilgisi al
        System.out.print("Üye numarasini giriniz: ");
        String memberNumber = scanner.nextLine();
        
        // Kitap bilgisi al
        System.out.print("İade etmek istediğiniz kitabın ISBN numarasını giriniz: ");
        String bookISBN = scanner.nextLine();
        
        // Kitap bulunup bulunmadığını kontrol et
        boolean bookFound = false;
        for (String[] book : bookManage.books)//book bookManage icindeki books arrayi icinde geziniyor 
        {
            if (book[2].equals(bookISBN) && !book[3].equals("Ödünç Alındı")) 
        //book[2] bookISBN ile book[3] ise "Müsait" uyusuyor mu kontrol ediliyor
            { 
                bookFound = true;
                // Kitap durumunu "Müsait" olarak güncelle
                book[3] = "Müsait";
                System.out.println("Kitap başarıyla iade edildi.");
                break;
            }
        }
        
        if (!bookFound) 
        {
            System.out.println("Kitap bulunamadı veya kitap zaten iade edilmiş.");
            return;
        }

        // Üye bulunup bulunmadığını kontrol et
        boolean memberFound = false;
        for (String[] member : memberManage.members) 
        {
            if (member[2].equals(memberNumber)) //memebr[2] memberNumber ile uyusuyor mu kontrol ediyoruz
            {
                memberFound = true;
                // Üye ödünç geçmişini güncelle (gerekirse burada ilgili tarih veya kitap bilgilerini sakla)
                System.out.println("Üye ödünç geçmişi güncellendi.");
                break;
            }
        }

        if (!memberFound) 
        {
            System.out.println("Üye bulunamadı.");
        }
    }
}
