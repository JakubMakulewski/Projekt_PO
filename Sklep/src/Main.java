import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {

    public static abstract class Object implements Serializable{
        protected String id;

    }
    public static abstract class Product extends Object{
        protected String title;
        protected Integer pages;
        protected Double price;
        protected String summary;

        public Product(String id, String title, Integer pages, Double price){
            this.id = id;
            this.title = title;
            this.pages = pages;
            this.price = price;
        }

        @Override
        public String toString() {
            String sb = "produkt:    " + "id: " + id +
                    ", kategoria produktu: " + this.getClass().getSimpleName() +
                    ", cena: " + price +
                    ", tytuł: " + title +
                    ", liczba stron: " + pages;
            return sb;
        }

        public String summaryToString() {
            String sb = "Opis produktu:\n" + summary + '\n';
            return sb;
        }
    }

    public static class Book extends Product implements Serializable{
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
            String sb = "id: " + id +
                    "     Tytuł: '" + title +
                    "', Gatunek: " + genre +
                    ", Liczba stron: " + pages +
                    ", Cena:" + price + "PLN";
            return sb;
        }

    }

    public static class Textbook extends Product implements Serializable{
        public String edition;



        public void setEdition(String edition) {
            this.edition = edition;
        }

        public Textbook(String id, String title, Integer pages, Double price, String edition) {
            super(id, title, pages, price);
            setEdition(edition);
        }
        @Override
        public String toString() {
            String sb = "id: " + id +
                    "     Tytuł: '" + title +
                    "', Wydanie: " + edition +
                    ", Liczba stron: " + pages +
                    ", Cena:" + price + "PLN";
            return sb;
        }
    }

    public static class Magazine extends Product implements Serializable{
        public String subject;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public Magazine(String id, String title, Integer pages, Double price, String subject) {
            super(id, title, pages, price);
            this.subject = subject;
        }

        @Override
        public String toString() {
            String sb = "id: " + id +
                    "     Tytuł: " + title +
                    ", Tematyka: " + subject +
                    ", Liczba stron: " + pages +
                    ", Cena:" + price + "PLN";
            return sb;
        }
    }

    public static class Date implements Serializable{
        private Integer year;
        private Integer month;
        private Integer day;

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
            String sb = day +
                    "." + month +
                    "." + year +
                    "r.";
            return sb;
        }
    }
    public static class Client extends Object implements Serializable{
        private String username;

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
            String sb = "klient " + "id: " + id +
                    ", username: " + username;
            return sb;
        }
    }

    public static class ProductList implements Serializable{
        private ArrayList<Product> elements = new ArrayList<Product>();
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

        public Product searchByIdProduct(String id){
            if(this.productIdExists(id)){
                for (Product s : elements) {
                    return s;
                }
            }
            else{
                System.out.println("Produkt id '" + id + "' nie istnieje");
            }
            return null;
        }
    }

    public static class ClientList implements Serializable{
        private ArrayList<Client> elements = new ArrayList<Client>();
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

        public Client searchByIdClient(String id){
            if(this.clientIdExists(id)){
                for (Client s : elements) {
                    return s;
                }
            }
            else{
                System.out.println("Klient id '" + id + "' nie istnieje");
            }
            return null;
        }

    }

    public static class Order extends Object implements Serializable{
        private Date submitDate;
        private Date fulfillDate;
        private Client client;
        private ArrayList<OrderBuilder> orderContent;

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


    public static class OrderBuilder implements Serializable{
        public Product product;
        public Integer amount;

        public OrderBuilder(Product product, Integer amount) {
            this.product = product;
            this.amount = amount;
        }
    }

    public static class OrderList implements Serializable{
        private ArrayList<Order> elements = new ArrayList<Order>();

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
//---------------------------------------------------------------------------------------
        public Order searchByIdClient(String id){
            if(this.orderIdExists(id)){
                for (Order s : elements) {
                    return s;
                }
            }
            else{
                System.out.println("Zamówienie id '" + id + "' nie istnieje");
            }
            return null;
        }
//---------------------------------------------------------------------------------------
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
    }   //dodać   -   sortowanie w unfulfillSortedToString()          [Comparator?    Collections?!]

    public static class Compound implements Serializable{
         ClientList clientList = new ClientList();
         ProductList productList = new ProductList();
         OrderList orderList = new OrderList();

        public Compound(ClientList clientList, ProductList productList, OrderList orderList) {
            this.clientList = clientList;
            this.productList = productList;
            this.orderList = orderList;
        }
    }

    public static class SaverLoader{
        public void saveCompound(String filePath, Compound compound){
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream pictureOutputStream = new ObjectOutputStream(fileOutputStream);

                pictureOutputStream.writeObject(compound);

                pictureOutputStream.close();
                fileOutputStream.close();

                System.out.println("Pomyślnie zapisano zestaw danych\n");
            }
            catch (Exception e){
                System.out.println("Błąd: Zapisywanie danych nie powiodło się\n");
                e.printStackTrace();
            }
        }

        Compound loadCompound(String filePath, Compound currentState){
            try{
                FileInputStream fileInputStream = new FileInputStream(filePath);
                ObjectInputStream pictureInputStream = new ObjectInputStream(fileInputStream);

                Compound loaded = (Compound) pictureInputStream.readObject();

                pictureInputStream.close();
                fileInputStream.close();

                System.out.println("Pomyślnie wczytano zestaw danych\n");

                return loaded;
            }
            catch(Exception e){
                System.out.println("Błąd: Wczytywanie danych nie powiodło się\n");
                e.printStackTrace();
            }

            return currentState;
        }
    }
    public static class Menu{
        private Compound compound = new Compound(new ClientList(), new ProductList(), new OrderList());
        private SaverLoader saverLoader = new SaverLoader();

        Scanner scanner = new Scanner(System.in);
        String option = new String();

        public void startTest(){
            System.out.println("Uruchamianie aplikacji...\n\n");
        }
        public void addObject(){
            do{
            System.out.println("Wybierz typ obiektu do dodania:\n" +
                    "1) Klient\n" +
                    "2) Produkt\n" +
                    "3) Zamówienie\n" +
                    "Wpisz 'anuluj', żeby wrócić do menu głównego");

            option = scanner.nextLine();


            switch (option) {
                case "1":
                    System.out.println("Nowy klient:\n");

                    System.out.println("Wpisz id:");
                    String clientId = scanner.nextLine();

                    System.out.println("Wpisz nazwę użytkownika:");
                    String clientUsername = scanner.nextLine();

                    Client newClient = new Client(clientId, clientUsername);
                    compound.clientList.addClient(newClient);

                    break;

                case "2":
                    System.out.println("Nowy produkt:\n");
                    System.out.println("Wybierz rodzaj nowego produktu:\n" +
                            "1) Książka\n" +
                            "2) Podręcznik\n" +
                            "3) Magazyn\n");

                    String pickType = scanner.nextLine();

                    switch (pickType) {
                        case "1":
                            System.out.println("Nowa książka:");
                            System.out.println("Wpisz id:");
                            String bookId = scanner.nextLine();

                            System.out.println("Wpisz tytuł:");
                            String bookTitle = scanner.nextLine();

                            System.out.println("Wpisz liczbę stron:");
                            Integer bookPages = scanner.nextInt();

                            System.out.println("Wpisz cenę:");
                            Double bookPrice = scanner.nextDouble();

                            scanner.nextLine();                             //przeskakuje z nextDouble na kolejną linijkę inputa
                            System.out.println("Wpisz gatunek:");
                            String bookGenre = scanner.nextLine();

                            if (!compound.productList.productIdExists(bookId)) {
                                Book newBook = new Book(bookId, bookTitle, bookPages, bookPrice, bookGenre);
                                compound.productList.addProduct(newBook);
                            } else {
                                System.out.println("Produkt o tym id już istnieje, tworzenie produktu nie powiodło się");
                            }
                            break;

                        case "2":
                            System.out.println("Nowy podręcznik:");
                            System.out.println("Wpisz id:");
                            String textId = scanner.nextLine();

                            System.out.println("Wpisz tytuł:");
                            String textTitle = scanner.nextLine();

                            System.out.println("Wpisz liczbę stron:");
                            Integer textPages = scanner.nextInt();

                            System.out.println("Wpisz cenę:");
                            Double textPrice = scanner.nextDouble();

                            scanner.nextLine();                             //przeskakuje z nextDouble na kolejną linijkę inputa
                            System.out.println("Wpisz numer wydania:");
                            String textEdition = scanner.nextLine();

                            if (!compound.productList.productIdExists(textId)) {
                                Textbook newTextbook = new Textbook(textId, textTitle, textPages, textPrice, textEdition);
                                compound.productList.addProduct(newTextbook);
                            } else {
                                System.out.println("Produkt o tym id już istnieje, tworzenie produktu nie powiodło się");
                            }
                            break;

                        case "3":
                            System.out.println("Nowy magazyn:");
                            System.out.println("Wpisz id:");
                            String magId = scanner.nextLine();

                            System.out.println("Wpisz tytuł:");
                            String magTitle = scanner.nextLine();

                            System.out.println("Wpisz liczbę stron:");
                            Integer magPages = scanner.nextInt();

                            System.out.println("Wpisz cenę:");
                            Double magPrice = scanner.nextDouble();

                            scanner.nextLine();                             //przeskakuje z nextDouble na kolejną linijkę inputa
                            System.out.println("Wpisz tematykę:");
                            String magSubject = scanner.nextLine();

                            if (!compound.productList.productIdExists(magId)) {
                                Magazine newMagazine = new Magazine(magId, magTitle, magPages, magPrice, magSubject);
                                compound.productList.addProduct(newMagazine);
                            } else {
                                System.out.println("Produkt o tym id już istnieje, tworzenie produktu nie powiodło się");
                            }
                            break;
                    }
                    break;

                case "3":
                    System.out.println("Nowe zamówienie:\n");

                    System.out.println("Wpisz id:");
                    String ordId = scanner.nextLine();

                    System.out.println("Wpisz datę złożenia (YYYY/MM/DD):");
                    Integer subDateYear = scanner.nextInt();
                    Integer subDateMonth = scanner.nextInt();
                    Integer subDateDay = scanner.nextInt();
                    Date ordSubDate = new Date(subDateYear, subDateMonth, subDateDay);

                    scanner.nextLine();                             //przeskakuje z nextInt na kolejną linijkę inputa
                    System.out.println("Wpisz id klienta:");
                    String ordClientId = scanner.nextLine();
                    Client ordClient = new Client(null, null);

                    if (compound.clientList.clientIdExists(ordClientId)) {
                        ordClient.id = compound.clientList.searchByIdClient(ordClientId).id;
                        ordClient.username = compound.clientList.searchByIdClient(ordClientId).username;
                    } else {
                        System.out.println("Ten klient nie istnieje. Tworzenie zamówienia nie powiodło się");
                        break;
                    }

                    System.out.println("Wybierz produkty i wyznacz ich ilość");
                    ArrayList<OrderBuilder> ordOrderContent = new ArrayList<>();
                    OrderBuilder item = new OrderBuilder(null, null);
                    String nextItem = "tak";

                    do {
                        System.out.println("Wprowadź id produktu: ");
                        String chosenProductId = scanner.nextLine();

                        if (compound.productList.productIdExists(chosenProductId)) {
                            Product chosenProduct = compound.productList.searchByIdProduct(chosenProductId);

                            item.product = chosenProduct;

                            System.out.println("Wprowadź ilość wybranego produktu: ");
                            Integer chosenAmount = scanner.nextInt();
                            item.amount = chosenAmount;

                            item.product = chosenProduct;

                            System.out.println("Czy chcesz dodać kolejną pozycję w zamówieniu? (tak/nie)");
                            nextItem = scanner.nextLine();
                        } else {
                            System.out.println("Ten produkt nie istnieje. Tworzenie zamówienia nie powiodło się");
                            break;
                        }

                    }
                    while (nextItem == "tak");

                    Order newOrder = new Order(ordId, ordSubDate, ordClient, ordOrderContent);
                    compound.orderList.addOrder(newOrder);

                    break;

            }
            }while(!"anuluj".equals(option));
        }

        public void removeObject(){

            do{
            System.out.println("Wybierz typ obiektu do usunięcia:\n" +
                    "1) Klient\n" +
                    "2) Produkt\n" +
                    "3) Zamówienie\n" +
                    "Wpisz 'anuluj', żeby wrócić do menu głównego");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Usuń klienta\nPodaj id klienta do usunięcia");
                    String idToRemoveClient = scanner.nextLine();
                    compound.clientList.removeClient(idToRemoveClient);
                    break;

                case "2":
                    System.out.println("Usuń produkt\nPodaj id produktu do usunięcia");
                    String idToRemoveProduct = scanner.nextLine();
                    compound.productList.removeProduct(idToRemoveProduct);
                    break;

                case "3":
                    System.out.println("Usuń zamówienie\nPodaj id zamówienia do usunięcia");
                    String idToRemoveOrder = scanner.nextLine();
                    compound.orderList.removeOrder(idToRemoveOrder);
                    break;
            }

            }while(!"anuluj".equals(option));
        }

        public void displayList(){

            do{
            System.out.println("Wybierz listę do wyświetlenia:\n" +
                    "1) Klienci\n" +
                    "2) Produkty\n" +
                    "3) Zamówienia\n" +
                    "Wpisz 'anuluj', żeby wrócić do menu głównego");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Wyświetl klientów\n");
                    System.out.println(compound.clientList.toString());
                    break;

                case "2":
                    System.out.println("Wyświetl produkty\n");
                    System.out.println(compound.productList.toString());
                    break;

                case "3":
                    System.out.println("Wyświetl zamówienia\n");
                    System.out.println(compound.orderList.toString());
                    break;
            }

            }while(!"anuluj".equals(option));
        }

        public void searchList(){
            do{
                System.out.println("Wybierz listę, której element chcesz wyszukać:\n" +
                        "1) Klienci\n" +
                        "2) Produkty\n" +
                        "3) Zamówienia\n" +
                        "Wpisz 'anuluj', żeby wrócić do menu głównego");

                option = scanner.nextLine();

                switch (option) {
                    case "1":                                                                   //
                        System.out.println("Wyszukaj klienta po id:\n");
                        String searchClientId = scanner.nextLine();
                        System.out.println(compound.clientList.searchById(searchClientId));
                        break;

                    case "2":                                                                   //
                        System.out.println("Wyszukaj produkt po id:\n");
                        String searchProductId = scanner.nextLine();
                        System.out.println(compound.productList.searchById(searchProductId));
                        break;

                    case "3":                                                                   //
                        System.out.println("Wyszukaj zamówienie po id:\n");
                        String searchOrderId = scanner.nextLine();
                        System.out.println(compound.orderList.searchById(searchOrderId));
                }

            }while(!"anuluj".equals(option));
        }

        public void unfullDisplay(){
            compound.orderList.unfulfillSortedToString();
        }

        public void saveToFile(){
            System.out.println("Podaj nazwę pliku do zapisu danych:");
            String fileName = scanner.nextLine();
            saverLoader.saveCompound(fileName, compound);
        }

        public void loadFromFile(){
            System.out.println("Podaj nazwę pliku do wczytania danych:");
            String fileName = scanner.nextLine();
            saverLoader.loadCompound(fileName, compound);
        }

        public void mainMenu(){

            Menu menu = new Menu();
            menu.startTest();
            String choice = new String();
            Scanner scanner = new Scanner(System.in);


            while(!"wyjdź".equals(choice)){
                System.out.println("-    MENU GŁÓWNE    -\n" +
                        "Wybierz działanie:\n" +
                        "1) Dodaj klienta/produkt/zamówienie\n" +
                        "2) Usuń klienta/produkt/zamówienie\n" +
                        "3) Wyświetl klientów/produkty/zamówienia\n" +
                        "4) Wyszukaj klienta/produkt/zamówienie\n" +
                        "5) Wyświetl niezrealizowane zamówienia\n" +
                        "6) Zapisz dane\n" +
                        "7) Wczytaj dane\n" +
                        "Wpisz 'wyjdź' aby zakończyć program");

                choice = scanner.nextLine();

                switch(choice){
                    case "1":
                        menu.addObject();
                        break;
                    case "2":
                        menu.removeObject();
                        break;
                    case "3":
                        menu.displayList();
                        break;
                    case "4":
                        menu.searchList();
                        break;
                    case "5":
                        menu.unfullDisplay();
                        break;
                    case "6":
                        menu.saveToFile();
                        break;
                    case "7":
                        menu.loadFromFile();
                        break;
                }

            }
        }
    }

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.mainMenu();

        /*
        ClientList clientList = new ClientList();
        ProductList productList = new ProductList();
        OrderList orderList = new OrderList();

        Menu menu = new Menu();
        menu.compound.clientList = clientList;
        menu.compound.productList = productList;
        menu.compound.orderList = orderList;

        Scanner scanner = new Scanner(System.in);
        String option = new String();

        menu.addObject();
        menu.addObject();
        menu.addObject();


        System.out.println(menu.compound.clientList.toString());
        System.out.println(menu.compound.productList.toString());
        System.out.println(menu.compound.orderList.toString());

        do{

        }
        while(!"exit".equals(option));
        scanner.close();
         */



        /*
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
        ArrayList<OrderBuilder> orderContent = new ArrayList<>();
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

        ClientList clientList = new ClientList();
        clientList.addClient(client);



        Compound compound = new Compound(clientList, productList, orderList);

        SaverLoader saverLoader = new SaverLoader();
        saverLoader.saveCompound("data.txt", compound);

        System.out.println(clientList.toString());
        clientList = new ClientList();
        System.out.println(clientList.toString());

        compound = new Compound(new ClientList(),new ProductList(), new OrderList());

        compound = saverLoader.loadCompound("data.txt", compound);

        clientList = compound.clientList;
        System.out.println(clientList.toString());
        */


        /*
        SaverLoader saverLoader = new SaverLoader();
        Compound compound = new Compound(new ClientList(),new ProductList(), new OrderList());
        saverLoader.loadCompound("data.txt",compound);
         */
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