import java.util.*;
import java.text.SimpleDateFormat;

public class BookManage {
    public List<String[]> books;

    public BookManage() // Constructor
    {
        books = new ArrayList<>();
        initializeBooks(); // Kitapları başlatan fonksiyon
    }

    public void initializeBooks() {
        // Kitapları başlat
        books.add(new String[]{"Suc Ve Ceza", "Fyodor Dostoyevski", "10", "Müsait", " ", " "}); // Kitap ekleme
        books.add(new String[]{"Körlük", "Viktor Hugo", "20", "Müsait", " ", " "});
        books.add(new String[]{"Alişkanliklarin Gucu","Charles Duhigg","30","Müsait", " ", " "});
    }

    // Kitapları listele
    public void ListBooks() {
        int m = 1;
        for (String[] book : books) //Book degiskeni books arrayinin tum elemanlarini gezer
        {
            System.out.println(m++ + ". Kitap :: ");
            System.out.println("Isim: " + book[0]);  // Kitap ismi
            System.out.println("Yazar: " + book[1]);  // Yazar
            System.out.println("ISBN: " + book[2]);  // ISBN numarası
            System.out.println("Durum: " + book[3]);  // Kitap durumu (Müsait / Ödünç Alındı)
           
            if (!book[4].isEmpty()) //book[4]'ün boş olup olmadığını kontrol eder 
            {
                System.out.println("Ödünç Alan Kullanıcı: " + book[4]);  // Kullanıcı numarasını ekliyoruz
            }
            if (!book[5].isEmpty()) // book[5]'ün boş olup olmadığını kontrol eder 
            {
                System.out.println("Ödünç Alındı Tarihi: " + book[5]);  // Ödünç alma tarihini ekliyoruz
            }
            System.out.println();
        }
    }
            //  Yeni kitap ekle
    public void addBook() {
       
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kitap Ismi: ");
        String name = scanner.nextLine();
        System.out.print("Yazar: ");
        String author = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        books.add(new String[]{name, author, isbn, "Müsait", "", ""});  // Yeni Kitap book'a ekleniyor
        System.out.println("Kitap başarıyla eklendi.");
    }

    public void deleteBook() {
        // Kitap sil
        Scanner scanner = new Scanner(System.in);
        System.out.print("Silmek istediğiniz kitabin ISBN numarasini giriniz: ");
        String isbnToDelete = scanner.nextLine();  // isbnToDelete değerine kullanıcının aramak için girdiği isbn aktarılıyor
        
        Iterator<String[]> iterator = books.iterator(); // Kitapları listeleyen bir iterator oluşturuluyor
        boolean found = false;  // Kitabın bulunup bulunmadığını kontrol eden değişken
        while (iterator.hasNext()) {  // Bir sonraki kitabı alıyoruz ve 'book' adlı değişkende saklıyoruz
            String[] book = iterator.next();
            if (book[2].equals(isbnToDelete)) //Mevcut kitapların 3.indislerinde isbnToDelete degiskenini ariyoruz
            {
                iterator.remove();  // ISBN numarasına göre kitap siliniyor
                System.out.println("Kitap başarıyla silindi.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void researchbook() {
        // Kitap arama (ISBN ile)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aramak istediğiniz kitabın ISBN numarasını giriniz: ");
        String isbnToSearch = scanner.nextLine();  // isbnToSearch değeri kullanıcının aramak için girdiği isbn aktarılıyor

        boolean found = false;
        for (String[] book : books) {
            if (book[2].equals(isbnToSearch)) {  //Mevcut kitapların 3.indislerinde isbnToSearch degiskenini ariyoruz
                System.out.println("Kitap bulundu: " + book[0] + ", " + book[1] + ", ISBN: " + book[2] + ", Durum: " + book[3]);
                if (!book[4].isEmpty()) // book[4] bos mu degil mi kontrol etme
                {  
                    System.out.println("Ödünç Alindi Tarihi: " + book[5]);
                    System.out.println("Ödünç Alan Kullanici: " + book[4]);  // Kullanıcı numarasını gösterme
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Kitap bulunamadi.");
        }
    }
    // Kitap ödünç al 
    public void borrowBook() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ödünç almak istediğiniz kitabin ISBN numarasini giriniz: ");
        String isbnToBorrow = scanner.nextLine();

        System.out.print("Kullanici numaranizi giriniz: ");
        String userId = scanner.nextLine();  // Kullanıcı numarasını alıyoruz

        boolean found = false;
        for (String[] book : books) {
            if (book[2].equals(isbnToBorrow)) {  // isbnToBorrow değişkenine aktarılmış değeri book[2] ile karşılaştırıyoruz
                if (book[3].equals("Müsait")) {  // Kitap müsaitse ödünç alınabiliyor
                    book[3] = "Ödünç Alındı";  // Kitap durumu ödünç alındı olarak değişiyor
                    book[4] = userId;  // Kullanıcı numarasını kitabın bilgisine ekliyoruz

                    // Tarihi SimpleDateFormat ile almak
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Tarih formatı ayarlanıyor
                    String date = sdf.format(new Date());  // Bugünün tarihi alınıyor
                    book[5] = date;  // Ödünç alma tarihi kitap bilgisine ekleniyor
                    System.out.println("Kitap başariyla ödünç alindi.");
                    System.out.println("Ödünç Alindi Tarihi: " + book[5]);  // Ödünç alma tarihi yazdırılıyor
                    System.out.println("Ödünç Alan Kullanici Numarasi: " + book[4]);  // Ödünç alan kullanıcının numarası yazdırılıyor
                } else {
                    System.out.println("Bu kitap zaten ödünç alinmiş.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Kitap bulunamadi.");
        }
    }
}
