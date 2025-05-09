public class Book {
    private String title;
    private String author;
    private int ISBN;
    private boolean is_avaliable; 

    public Book(String title, String author ,int ISBN , boolean is_avaliable ){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.is_avaliable = is_avaliable;
    }
        public void is_avaliable(){
            if(is_avaliable){
                System.out.println(" Sorguladiginiz Kitap Mevcuttur ");
            }
            else{
                System.out.println(" Sorguladiginiz Kitap Mevcut Degildir :( ");
            }
        }
        public void borrow(){
            if(is_avaliable){
                is_avaliable = false ;
                System.out.println(title + " Odunc Alinmisitr ");
            }

            else {

                System.out.println(title + "Baskasi Tarafindan Odunc Alinmistir ");
            }
        }
    
}
