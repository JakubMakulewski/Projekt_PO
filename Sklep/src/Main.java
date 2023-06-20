import java.util.ArrayList;

public class Main {

    public static abstract class Product{
        public String id;
        public String title;
        public Integer pages;
        public Double price;

        String getId(){
            return this.id;
        }
        void setId(String id){
            this.id = id;
        }
        String getTitle(){
            return this.title;
        }
        void setTitle(String title){
            this.title = title;
        }
        Integer getPages(){
            return this.pages;
        }
        void setPages(Integer pages){
            this.pages = pages;
        }
        Double getPrice(){
            return this.price;
        }
        void setPrice(Double price){
            this.price = price;
        }

        public Product(String id, String title, Integer pages, Double price){
            setId(id);
            setTitle(title);
            setPages(pages);
            setPrice(price);
        }
    }

    public static class Book extends Product{
        String genre;

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public Book(String id, String title, Integer pages, Double price, String genre) {
            super(id, title, pages, price);
            setGenre(genre);
        }
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(id);
            sb.append(", Tytuł: '").append(title);
            sb.append("', Gatunek: ").append(genre);
            sb.append(", Liczba stron: ").append(pages);
            sb.append(", Cena:").append(price).append("PLN");
            return sb.toString();
        }
        void setBookId(String id){
            this.id = id;
        }

    }

    public static class Textbook extends Product{
        String edition;

        public String getEdition() {
            return edition;
        }

        public void setEdition(String edition) {
            this.edition = edition;
        }

        public Textbook(String id, String title, Integer pages, Double price, String edition) {
            super(id, title, pages, price);
            setEdition(edition);
        }
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(id);
            sb.append(", Tytuł: '").append(title);
            sb.append("', Wydanie: ").append(edition);
            sb.append(", Liczba stron: ").append(pages);
            sb.append(", Cena:").append(price).append("PLN");
            return sb.toString();
        }
    }

    public static class Magazine extends Product{
        String subject;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public Magazine(String id, String title, Integer pages, Double price, String subject) {
            super(id, title, pages, price);
            setSubject(subject);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("id: '").append(id);
            sb.append("', Tytuł: ").append(title);
            sb.append(", Tematyka: ").append(subject);
            sb.append(", Liczba stron: ").append(pages);
            sb.append(", Cena:").append(price).append("PLN");
            return sb.toString();
        }
    }

    public static class ProductList{
        public ArrayList<Product> elements;

        public ProductList(){
            this.elements = new ArrayList<>();
        }
    }

    public static class Date{
        public Integer year;
        public Integer month;
        public Integer day;

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public Integer getMonth() {
            return month;
        }

        public void setMonth(Integer month) {
            this.month = month;
        }

        public Integer getDay() {
            return day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        public Date(Integer year, Integer month, Integer day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public boolean validateDate(Integer year, Integer month, Integer day){
            //sprawdzarka poprawności dat
            System.out.println("Data poprawna");
            return true;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(day);
            sb.append(".").append(month);
            sb.append(".").append(year);
            sb.append("r.");
            return sb.toString();
        }
    }
    public static class Client{
        //class Client
    }

    public static class Order{
        //class Order
        public void displayOrder(){

        }
    }

    public static class Menu{
        //class Menu
    }

    public static void main(String[] args) {
        Book txt = new Book("id","title",2,3.00, "sci-fi");
        System.out.println(txt.toString());
        //main
    }
}

/*
2) Sklep
        Aplikacja wspomagająca rejestrację zamówień na produkty. Podstawowe funkcjonalności:
        - dodawanie/usuwanie/wyszukiwanie/przeglądanie klientów,
        - dodawanie/usuwanie/wyszukiwanie/przeglądanie produktów, obsługa 3 kategorii produktów, kategorie produktów powinny posiadać wspólne atrybuty (np.: id, waga, cena) i specyficzne dla danego typu
        - dodawanie/ przeglądanie zamówień na produkty, zamówienie jest przypisane do danego klienta, zawiera datę złożenia i datę realizacji, może zawierać wiele pozycji
        - wyświetlanie zamówień do przeznaczonych do realizacji sortowanych względem daty
        - zapis/odczyt z pliku
 */