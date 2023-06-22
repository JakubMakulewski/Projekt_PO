import java.util.ArrayList;

public class Main {

    public static abstract class Object{
        public String id;
    }
    public static abstract class Product extends Object{
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
    }                                                  //done?
    public static class Client extends Object{
        String username;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Client(String id, String username) {
            this.id = id;
            this.username = username;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("klient:");
            sb.append("id: ").append(id);
            sb.append(", username: ").append(username);
            return sb.toString();
        }
    }
/*
    public static abstract class List extends Object{
        //
    }
*/

    public static class ProductList{
        public ArrayList<Product> elements;

        public void addElement(Product product){
            elements.add(product);
        }
    }

    public static class ClientList{
        ArrayList<Client> elements = new ArrayList<Client>();
        private boolean clientIdExists(String id){
            for (Client s : elements){
                if(s.id == id) {
                    //System.out.println("Klient id " + id + " istnieje");
                    return true;
                }
            }
            //System.out.println("Nie znaleziono klienta id " + id + "");
            return false;
        }

        public void addClient(Client client){
            if(!this.clientIdExists(client.id)) {
                elements.add(client);
                System.out.println("Dodano klienta id " + client.id);
            }
            else{
                System.out.println("Klient id " + client.id + "już istnieje, nie utworzono nowego klienta");
            }
        }

        public void removeClient(String id){
            for (Client s : elements){
                if(this.clientIdExists(id)){
                    elements.remove(s);
                    System.out.println("Usunięto klienta id " + s.id);
                    break;
                }
                else if (!this.clientIdExists(id)) {
                    System.out.println("Klient id " + id + " nie istnieje, nie usunięto klienta");
                }
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nLista klientów:\n");

            for (Client s : elements){
                sb.append(s).append("\n");
            }
            return sb.toString();
        }

        public String clientSearchById(String id){
            final StringBuilder sb = new StringBuilder("Szukaj klienta po id "+ id + ":\n");


                if(this.clientIdExists(id)){
                    for (Client s : elements) {
                        if (this.clientIdExists(id)) {
                            sb.append(s.toString());
                            break;
                        }
                    }
                }
                else{
                    sb.append("Klient id " + id + " nie istnieje, nie usunięto klienta");
                }
            return sb.toString();
        }



    }

    public static class Order extends Object{
        public Date submitDate;
        public Date fulfillDate;
        public Client client;
        public ArrayList<OrderBuilder> orderContent;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getSubmitDate() {
            return submitDate;
        }

        public void setSubmitDate(Date submitDate) {
            this.submitDate = submitDate;
        }

        public Date getFulfillDate() {
            return fulfillDate;
        }

        public void setFulfillDate(Date fulfillDate) {
            this.fulfillDate = fulfillDate;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public ArrayList<OrderBuilder> getOrderContent() {
            return orderContent;
        }

        public void setOrderContent(ArrayList<OrderBuilder> orderContent) {
            this.orderContent = orderContent;
        }

        public Order(String id, Date submitDate, Date fulfillDate, Client client, ArrayList<OrderBuilder> orderContent) {
            this.id = id;
            this.submitDate = submitDate;
            this.fulfillDate = fulfillDate;
            this.client = client;
            this.orderContent = orderContent;
        }

        class OrderBuilder{
           Product product;
           Integer amount;

            public Product getProduct() {
                return product;
            }

            public void setProduct(Product product) {
                this.product = product;
            }

            public Integer getAmount() {
                return amount;
            }

            public void setAmount(Integer amount) {
                this.amount = amount;
            }
        }
        public void displayOrder(){

        }

    }

    public static class OrderList{

    }

    //może warto dodać abstract dla list?

    public static class Menu{
        //class Menu
    }

    public static void main(String[] args) {
        Client cl1 = new Client("1","one");
        Client cl2 = new Client("2","two");
        Client cl3 = new Client("3","three");
        ClientList clientList = new ClientList();

        clientList.addClient(cl1);
        clientList.addClient(cl2);
        clientList.addClient(cl3);

        System.out.println(clientList.toString());

        clientList.removeClient("1");
        clientList.removeClient("1");

        System.out.println(clientList.toString());

        clientList.addClient(cl1);

        System.out.println(clientList.toString());

        System.out.println(clientList.clientSearchById("4"));
    }
}

/*
Zadania projektowe można realizować w 2-3 osobowych grupach. Przy oddaniu projektu należy określić podział pracy (funkcjonalności/klasy implementowane przez daną osobę)

Ocena uwzględnia następujące elementy:
- kompletność funkcjonalności - 4p
- poprawność implementacji i wykorzystanie technik programowania obiektowego (kompozycja, dziedziczenie, polimorfizm, wyjątki) - 4p
- diagram UML - 2p


2) Sklep
        Aplikacja wspomagająca rejestrację zamówień na produkty. Podstawowe funkcjonalności:
        - dodawanie/usuwanie/wyszukiwanie/przeglądanie klientów,
        - dodawanie/usuwanie/wyszukiwanie/przeglądanie produktów, obsługa 3 kategorii produktów,
           kategorie produktów powinny posiadać wspólne atrybuty (np.: id, waga, cena) i specyficzne dla danego typu
        - dodawanie/ przeglądanie zamówień na produkty, zamówienie jest przypisane do danego klienta, zawiera datę złożenia i datę realizacji, może zawierać wiele pozycji
        - wyświetlanie zamówień do przeznaczonych do realizacji sortowanych względem daty
        - zapis/odczyt z pliku
 */