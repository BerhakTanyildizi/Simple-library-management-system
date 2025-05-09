import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Kütüphane Yönetim Sistemi ===");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Kitap Ödünç Al");
            System.out.println("4. Kitap İade Et");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Satır sonu karakterini temizlemek için

            switch (choice) {
                case 1 -> addBookPrompt(scanner);
                case 2 -> listBooks();
                case 3 -> borrowBookPrompt(scanner);
                case 4 -> returnBookPrompt(scanner);
                case 5 -> System.out.println("Sistemden çıkılıyor...");
                default -> System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private void addBookPrompt(Scanner scanner) {
        System.out.print("Kitap başlığını girin: ");
        String title = scanner.nextLine();
        System.out.print("Yazar adını girin: ");
        String author = scanner.nextLine();
        System.out.print("ISBN numarasını girin: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);
        addBook(book);
        System.out.println("Kitap başarıyla eklendi.");
    }

    private void listBooks() {
        System.out.println("=== Kütüphanedeki Kitaplar ===");
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + (book.isAvailable() ? "Mevcut" : "Ödünç Verildi"));
        }
    }

    private void borrowBookPrompt(Scanner scanner) {
        System.out.print("Ödünç almak istediğiniz kitabın ISBN numarasını girin: ");
        String isbn = scanner.nextLine();

        Book book = findBookByISBN(isbn);
        if (book != null) {
            if (book.isAvailable()) {
                book.borrow();
                System.out.println("Kitap başarıyla ödünç alındı.");
            } else {
                System.out.println("Bu kitap şu anda ödünçte.");
            }
        } else {
            System.out.println("ISBN numarasıyla eşleşen bir kitap bulunamadı.");
        }
    }

    private void returnBookPrompt(Scanner scanner) {
        System.out.print("İade etmek istediğiniz kitabın ISBN numarasını girin: ");
        String isbn = scanner.nextLine();

        Book book = findBookByISBN(isbn);
        if (book != null) {
            if (!book.isAvailable()) {
                book.returnBook();
                System.out.println("Kitap başarıyla iade edildi.");
            } else {
                System.out.println("Bu kitap zaten kütüphanede.");
            }
        } else {
            System.out.println("ISBN numarasıyla eşleşen bir kitap bulunamadı.");
        }
    }

    private Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.showMenu();
    }
}

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}
