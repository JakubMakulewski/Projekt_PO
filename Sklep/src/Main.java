import java.util.ArrayList;

public class Main {

    public static abstract class Object{
        public String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
    public static abstract class Product extends Object{
        public String title;
        public Integer pages;
        public Double price;
        public String summary;

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

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Product(String id, String title, Integer pages, Double price){
            setId(id);
            setTitle(title);
            setPages(pages);
            setPrice(price);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("produkt:    ");
            sb.append("id: ").append(id);
            sb.append(", kategoria produktu: ").append(this.getClass().getName());
            sb.append(", cena: ").append(price);
            sb.append(", tytuł: ").append(title);
            sb.append(", liczba stron: ").append(pages);
            return sb.toString();
        }
    }

    public static class Book extends Product{
        public String genre;

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
            sb.append("     Tytuł: '").append(title);
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
            sb.append("     Tytuł: '").append(title);
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
            sb.append("id: ").append(id);
            sb.append("     Tytuł: ").append(title);
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
            final StringBuilder sb = new StringBuilder("klient ");
            sb.append("id: ").append(id);
            sb.append(", username: ").append(username);
            return sb.toString();
        }
    }

    public static class ProductList{
        ArrayList<Product> elements = new ArrayList<Product>();
        private boolean productIdExists(String id){
            for (Product s : elements){
                if(s.id == id) {
                    //System.out.println("Produkt id " + id + " istnieje");
                    return true;
                }
            }
            //System.out.println("Nie znaleziono produktu id " + id + "");
            return false;
        }

        public void addProduct(Product product){
            if(!this.productIdExists(product.id)) {
                elements.add(product);
                System.out.println("Dodano produkt id " + product.id);
            }
            else{
                System.out.println("Produkt id " + product.id + "już istnieje, nie utworzono nowego produktu");
            }
        }

        public void removeProduct(String id){
            for (Product s : elements){
                if(this.productIdExists(id)){
                    elements.remove(s);
                    System.out.println("Usunięto produkt id " + s.id);
                    break;
                }
                else if (!this.productIdExists(id)) {
                    System.out.println("Produkt id " + id + " nie istnieje, nie usunięto produktu");
                }
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nLista produktów:\n");

            for (Product s : elements){
                sb.append(s).append("\n");
            }
            return sb.toString();
        }

        public String searchById(String id){
            final StringBuilder sb = new StringBuilder("Szukaj produkt po id '"+ id + "':\n");


            if(this.productIdExists(id)){
                for (Product s : elements) {
                    if (this.productIdExists(id)) {
                        sb.append(s.toString());
                        break;
                    }
                }
            }
            else{
                sb.append("Produkt id '" + id + "' nie istnieje");
            }
            return sb.toString();
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

        public String searchById(String id){
            final StringBuilder sb = new StringBuilder("Szukaj klienta po id '"+ id + "':\n");


                if(this.clientIdExists(id)){
                    for (Client s : elements) {
                        if (this.clientIdExists(id)) {
                            sb.append(s.toString());
                            break;
                        }
                    }
                }
                else{
                    sb.append("Klient id '" + id + "' nie istnieje");
                }
            return sb.toString();
        }

    }

    public static class Order extends Object{
        public Date submitDate;
        public Date fulfillDate;
        public Client client;
        public ArrayList<OrderBuilder> orderContent;

        public Order(String id, Date submitDate, Client client, ArrayList<OrderBuilder> orderContent) {       //Date fulfillDate
            this.id = id;
            this.submitDate = submitDate;
            //this.fulfillDate = fulfillDate;
            this.client = client;
            this.orderContent = orderContent;
        }

        public Date getFulfillDate() {
            return fulfillDate;
        }

        public void setFulfillDate(Date fulfillDate) {
            this.fulfillDate = fulfillDate;
        }

        public String displayContent(){
            final StringBuilder sb = new StringBuilder();
            int i = 1;
            for (OrderBuilder s : this.orderContent){
                sb.append("#" + i + " ");
                sb.append("id: " + s.product.id);
                sb.append(", tytuł: " + s.product.title);
                sb.append(", cena: " + s.product.price + "PLN");
                sb.append(", ilość: " + s.amount);
                i++;
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Zamówienie " + id + "\n");
            sb.append("Data przyjęcia:      ").append(submitDate).append("\n");
            sb.append("Data realizacji:     ");
            if(fulfillDate != null) {
                sb.append(fulfillDate).append("\n");
            }
            else {
                sb.append("N/A").append("\n");
            }
            sb.append("Klient:              ").append(client).append("\n\n");
            sb.append("Zawartość zamówienia:\n").append(displayContent() + "\n");
            return sb.toString();
        }
    }


    public static class OrderBuilder{
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

        public OrderBuilder(Product product, Integer amount) {
            this.product = product;
            this.amount = amount;
        }
    }

    public static class OrderList{
        ArrayList<Order> elements = new ArrayList<Order>();

        private boolean orderIdExists(String id){
            for (Order s : elements){
                if(s.id == id) {
                    //System.out.println("Zamówienie id " + id + " istnieje");
                    return true;
                }
            }
            //System.out.println("Nie znaleziono zamówienia id " + id + "");
            return false;
        }

        public void addOrder(Order order){
            if(!this.orderIdExists(order.id)) {
                elements.add(order);
                System.out.println("Dodano zamówienie id " + order.id);
            }
            else{
                System.out.println("Zamówienie id " + order.id + "już istnieje, nie utworzono nowego zamówienia");
            }
        }

        public void removeOrder(String id){
            for (Order s : elements){
                if(this.orderIdExists(id)){
                    elements.remove(s);
                    System.out.println("Usunięto zamówienie id " + s.id);
                    break;
                }
                else if (!this.orderIdExists(id)) {
                    System.out.println("Zamówienie id " + id + " nie istnieje, nie usunięto zamówienia");
                }
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nLista zamówień:\n");

            for (Order s : elements){
                sb.append(s).append("\n");
            }
            return sb.toString();
        }

        public String searchById(String id){
            final StringBuilder sb = new StringBuilder("Szukaj zamówienia po id '"+ id + "':\n");


            if(this.orderIdExists(id)){
                for (Order s : elements) {
                    if (this.orderIdExists(id)) {
                        sb.append(s.toString());
                        break;
                    }
                }
            }
            else{
                sb.append("Zamówienie id '" + id + "' nie istnieje");
            }
            return sb.toString();
        }

        public String unfulfillSortedToString(){
            ArrayList<Order> sortingList = new ArrayList<Order>();
            final StringBuilder sb = new StringBuilder("Do realizacji:\n");

            for(Order s : elements){
                if (s.fulfillDate == null){
                    sortingList.add(s);
                }
            }

            sb.append(sortingList.toString());

            return sb.toString();
        }
    }   //WiP   -   sortowanie w unfulfillSortedToString()

    public static class Menu{
        //class Menu
    }

    public static void main(String[] args) {

        Book cl1 = new Book("1","one", 5,1.99,"gen1");
        Book cl2 = new Book("2","two", 10,2.99,"gen2");
        Textbook cl3 = new Textbook("3","three", 15,3.99,"gen3");
        ProductList productList = new ProductList();

        productList.addProduct(cl1);
        productList.addProduct(cl2);
        productList.addProduct(cl3);

        System.out.println(productList.toString());

        productList.removeProduct("1");
        productList.removeProduct("1");

        System.out.println(productList.toString());

        productList.addProduct(cl1);

        System.out.println(productList.toString());

        System.out.println(productList.searchById("4"));

        Client client = new Client("9", "user");
        Date date = new Date(2000,1,1);

        System.out.println(client.toString());
        System.out.println(date.toString());

        OrderBuilder orderBuilder = new OrderBuilder(cl1, 1);
        ArrayList<OrderBuilder> orderContent = new ArrayList<OrderBuilder>();
        orderContent.add(orderBuilder);

        Order order = new Order("11", date, client,orderContent);
        Order order2 = new Order("21", date, client,orderContent);
        Order order3 = new Order("31", date, client,orderContent);
        order2.fulfillDate = date;

        System.out.println(order.toString());

        OrderList orderList = new OrderList();

        orderList.addOrder(order);
        orderList.addOrder(order2);
        orderList.addOrder(order3);

        System.out.println(orderList.toString());
        System.out.println(orderList.unfulfillSortedToString());

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