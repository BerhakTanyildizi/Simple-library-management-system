import java.util.*;

public class Membermanagement {
    public List<String[]> members;  // Üye bilgilerini tutan liste

    // Constructor: Üye listesini başlatır ve başlangıç üyelerini ekler
    public Membermanagement() {
        members = new ArrayList<>();  // Üye listesi oluşturulur
        initializeMembers();  // Başlangıç üyeleri eklenir
    }

    // Başlangıç üyelerini listeye ekler
    public void initializeMembers() {
        // Üyeler listesine örnek üyeler eklenir (İsim, Soyisim, Numara, Durum, Ödünç Geçmişi)
        members.add(new String[]{"Ahmet", "Yildirim", "100", "Aktif Uye", ""});
        members.add(new String[]{"Sevval", "Kaya", "200", "Aktif Uye", ""});
        members.add(new String[]{"Umut", "Kaplan", "300", "Aktif Uye", ""});
    }

    // Üyeleri listeleyen fonksiyon
    public void listMember() {
        int m = 1;  // Üye sırasını tutan sayaç
        for (String[] member : members) {  // Her bir üyeyi sırayla yazdır
            System.out.println(m++ + ". Üye :: ");  // Üye sırasını yazdır
            System.out.println("İsim: " + member[0] + " " + member[1]);  // Üyenin adı ve soyadı
            System.out.println("Numara: " + member[2]);  // Üyenin numarası
            System.out.println("Durum: " + member[3]);  // Üyenin durumu (örneğin: Aktif Üye)
            System.out.println("Ödünç Geçmişi: " + member[4]);  // Üyenin ödünç geçmişi (varsa)
            System.out.println();
        }
    }

    // Yeni bir üye ekleyen fonksiyon
    public void addMember() {
        Scanner scanner = new Scanner(System.in);  // Kullanıcıdan veri almak için Scanner
        System.out.print("Yeni Üye İsmi: ");
        String name = scanner.nextLine();  // Yeni üyenin adı
        System.out.print("Yeni Üye Soyadı: ");
        String surname = scanner.nextLine();  // Yeni üyenin soyadı
        System.out.print("Yeni Üye Numarası: ");
        String number = scanner.nextLine();  // Yeni üyenin numarası

        // Yeni üye listeye eklenir
        members.add(new String[]{name, surname, number, "Aktif Uye", ""});
        System.out.println("Üye başarıyla eklendi.");
    }

    // Mevcut bir üyeyi numarasına göre silen fonksiyon
    public void deleteMember() {
        Scanner scanner = new Scanner(System.in);  // Kullanıcıdan veri almak için Scanner
        System.out.print("Silmek istediğiniz üyenin numarasını giriniz: ");
        String numberToDelete = scanner.nextLine();  // Silmek istenilen üyenin numarası
        
        Iterator<String[]> iterator = members.iterator();  // Listede dolaşmak için Iterator
        boolean found = false;  // Üye bulunup bulunmadığını tutan degisken
        while (iterator.hasNext()) {  // Listeyi dolaş
            String[] member = iterator.next();  // Şu anki üyeyi al
            if (member[2].equals(numberToDelete)) {  // Eğer üye numarası eşleşiyorsa
                iterator.remove();  // Üyeyi listeden sil
                System.out.println("Üye başarıyla silindi.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Üye bulunamadı.");
        }
    }

    // Üye arama fonksiyonu: Üye numarasına göre arama yapar
    public void researchMember() {
        Scanner scanner = new Scanner(System.in);  // Kullanıcıdan veri almak için Scanner
        System.out.print("Aramak istediğiniz üyenin numarasını giriniz: ");
        String numberToSearch = scanner.nextLine();  // Aranacak üyenin numarası
        
        boolean found = false;  // Üye bulunup bulunmadığını tutan degisken
        for (String[] member : members) {  // Listeyi dolaşarak arama yap
            if (member[2].equals(numberToSearch)) {  // Eğer numara eşleşirse
                System.out.println("Üye bulundu: " + member[0] + " " + member[1] + ", " + member[2] + ", Durum: " + member[3]);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Üye bulunamadı.");
        }
    }

    // Üyenin ödünç geçmişini görüntüleyen fonksiyon
   public void viewBorrowHistory() {
    Scanner scanner = new Scanner(System.in);  // Kullanıcıdan veri almak için Scanner
    System.out.print("Ödünç geçmişini görmek istediğiniz üyenin numarasını giriniz: ");
    String memberNumber = scanner.nextLine();  // Ödünç geçmişi istenen üyenin numarası

    boolean found = false;  // Üye bulunup bulunmadığını tutan değişken
    for (String[] member : members) {  // Üyeleri dolaşarak arama yap
        if (member[2].equals(memberNumber)) {  // Eğer üye numarası eşleşirse
            System.out.println("Üye bulundu: " + member[0] + " " + member[1] + ", Durum: " + member[3]);
            System.out.println("Ödünç Alınan Kitaplar:");

            // Eğer ödünç geçmişi varsa, ödünç alınan kitaplar virgülle ayrılarak yazdırılır
            if (!member[4].isEmpty()) 
            {
                String[] borrowedBooks = member[4].split(", ");  // Kitapları virgülle ayır
                for (String borrowedBook : borrowedBooks) {  // Her bir kitabı yazdır
                    System.out.println("- " + borrowedBook);
                }
            } else {
                System.out.println("Bu üye herhangi bir kitap ödünç almamış.");
            }
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Üye bulunamadı.");
    }
}

    

    // Üye bilgilerini güncelleyen fonksiyon
    public void updateMember() {
        Scanner scanner = new Scanner(System.in);  // Kullanıcıdan veri almak için Scanner
        System.out.print("Güncellemek istediğiniz üyenin numarasını giriniz: ");
        String memberNumber = scanner.nextLine();  // Güncellenecek üyenin numarası
        
        boolean found = false;  // Üye bulunup bulunmadığını tutan bayrak
        for (String[] member : members) {  // Üyeleri dolaşarak arama yap
            if (member[2].equals(memberNumber)) {  // Eğer üye numarası eşleşirse
                System.out.println("Üye bulundu: " + member[0] + " " + member[1] + ", " + member[2]);
                
                // Yeni bilgiler alınır (Boş bırakılabilir)
                System.out.print("Yeni İsim (boş bırakmak için Enter'a basın): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) member[0] = newName;  // Yeni isim alınır ve güncellenir
                
                System.out.print("Yeni Soyisim (boş bırakmak için Enter'a basın): ");
                String newSurname = scanner.nextLine();
                if (!newSurname.isEmpty()) member[1] = newSurname;  // Yeni soyisim alınır ve güncellenir
                
                System.out.print("Yeni Numara (boş bırakmak için Enter'a basın): ");
                String newNumber = scanner.nextLine();
                if (!newNumber.isEmpty()) member[2] = newNumber;  // Yeni numara alınır ve güncellenir
                
                System.out.println("Üye bilgileri başarıyla güncellendi.");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Üye bulunamadı.");
        }
    }
}
