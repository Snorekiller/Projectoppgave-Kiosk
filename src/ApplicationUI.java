
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author asty
 * @version 1.0
 *
 *
 * dfdfdfdfdf
 */
public class ApplicationUI
{
    private BookRegister bookRegister;
    private Register register;


    private static int MAX_AUTHOR_LENGTH = 30;
    private static int MAX_GENRE_LENGTH = 30;
    private static int MAX_PUBLISHER_LENGTH = 30;
    private static int MAX_EDITION_LENGTH = 100;
   
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "product" with "literature"
    // etc.
    private String[] menuItems = {
        "1. List all literature",
        "2. Add new literature",
        "3. Find a literature by name",
        "4. Delete literature",
        "5. Fill with dummy literature",
    };

    private String[] addLiteratureMenuItems = {
            "1. Add Book",
            "2. Add Book Series",
            "3. Add Newspaper",
            "4. Add Magazine",
            "5. Add Comic Book",
    };

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() 
    {
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllLiterature();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        //this.findBookByName();
                        break;

                    case 4:
                        this.deleteBook();
                        break;

                    case 5:
                        //this.fillDummyBooks();
                        break;

                    case 6:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } 
            catch (InputMismatchException ime) 
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + (this.menuItems.length+1) + "..\n");
            }
        }        
        
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu(String[] menu) throws InputMismatchException
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menu )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menu.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---
    
    /**
     * Initializes the application.
     */
    private void init()
    {
        //bookRegister = new BookRegister();
        register = new Register();
    }

    /**
     * Lists all the items in the register and the amount of items
     */
    private void listAllLiterature()
    {
       Iterator<Literature> it = register.getIterator();
       while (it.hasNext()){
           displayLiterature(it.next());
       }
    }

    private void displayLiterature(Literature literature){
        System.out.println("Title: " + literature.getTitle());
        System.out.println("Publisher: " + literature.getPublisher());
        System.out.println("Genre: " + literature.getGenre());

        if(literature instanceof Book){
            Book book = (Book)literature;
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Edition: " + book.getEdition());
            System.out.println();
        }

        if(literature instanceof BookSeries){
            BookSeries bookSeries = (BookSeries)literature;
            System.out.println("Author: " + bookSeries.getAuthor());
            System.out.println("Number of books: " + bookSeries.getNumberOfBooks());
            System.out.println();
        }

        if(literature instanceof ComicBooks){
            ComicBooks comicBooks = (ComicBooks)literature;
            System.out.println("Yearly editions: " + comicBooks.getYearlyEditions());
            System.out.println();
        }

        if(literature instanceof Newspaper){
            Newspaper newspaper = (Newspaper)literature;
            System.out.println("Yearly editions: " + newspaper.getYearlyEditions());
            System.out.println();
        }

        if(literature instanceof Magazine){
            Magazine magazine = (Magazine) literature;
            System.out.println("Yearly editions: " + magazine.getYearlyEditions());
            System.out.println();
        }
    }

    
    /**
     * Add a new product/literature to the register.
     * takes input from the user for title, author and genre.
     * lets you try again if you enter nothing or too many characters.
     */
    private void addNewBook()
    {
        int nameLength = 50;
        int authorLength = 30;
        int publisherLength = 30;
        int genreLength = 30;
        int maxEdition = 100;
        int maxYearlyEditions = 365;
        int maxNumberOfBooks = 100;

        String name;
        String author = "";
        String publisher;
        String genre;
        int edition = 0;
        int yearlyEditions = 0;
        int numberOfBooks = 0;

                    // Creates reader scanner object (reads input from user)
            int menuSelection = this.showMenu(addLiteratureMenuItems);
            if(menuSelection != 6) {

                //menuSelection 1 = book, 2 = bookSeries, 3 = newspaper, 4 = magazine, 5 = comicbook

                // Creates reader scanner object (reads input from user)
                Scanner reader = new Scanner(System.in);

                name = setLiteratureInfo(nameLength, "name");
                if(menuSelection == 1 || menuSelection == 2) {
                    author = setLiteratureInfo(authorLength, "author");
                    String edition1 = setLiteratureInfo(maxEdition, "edition");
                    edition = Integer.parseInt(edition1);
                }
                genre = setLiteratureInfo(genreLength, "genre");
                publisher = setLiteratureInfo(publisherLength, "publisher");

                if(menuSelection == 3 || menuSelection == 4 || menuSelection == 5) {
                    String yearlyEdition1 = setLiteratureInfo(maxYearlyEditions, "yearlyEditions");
                    yearlyEditions = Integer.parseInt(yearlyEdition1);
                }

                if(menuSelection == 2) {
                    String numberOfBooks1 = setLiteratureInfo(maxNumberOfBooks, "numberOfBooks");
                    numberOfBooks = Integer.parseInt(numberOfBooks1);
                }

                // Creates book object and adds it's information to a list.
                if (menuSelection == 1) {
                    Book book = new Book(name, author, genre, publisher, edition);
                    register.addLiterature(book);
                } else if (menuSelection == 2) {
                    BookSeries bookSeries = new BookSeries(name, publisher, author, genre, numberOfBooks);
                    register.addLiterature(bookSeries);
                } else if (menuSelection == 3) {
                    Newspaper newspaper = new Newspaper(name, publisher, genre, yearlyEditions);
                    register.addLiterature(newspaper);
                } else if (menuSelection == 4) {
                    Magazine magazine = new Magazine(name, publisher, genre, yearlyEditions);
                    register.addLiterature(magazine);
                } else if (menuSelection == 5) {
                    ComicBooks comicBooks = new ComicBooks(name, publisher, genre, yearlyEditions);
                    register.addLiterature(comicBooks);
                } else {
                    System.out.println("Something went wrong, try again...");
                }
            }

    }

    /**
     * Find and display a product based om name (title).
     * displays author and genre
     */
    /*
    private void findBookByName()
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please write the title you are searching for:");
        String parameterString = reader.nextLine();
        Literature literatureSearch = register.search(parameterString);
        if(literatureSearch == null){
            System.out.println("No literature matches that name");
        }
        else{
            System.out.println("This book is currently in your system");
            displayLiterature(literatureSearch);
        }
    }
    */


    /**
     * Will send your input to deleteEntries in BookRegister and delete it if it exists
     */
    private void deleteBook()
    {
        System.out.println("Write the title of the literature you want to delete.");
        Scanner reader = new Scanner(System.in);
        String parameterString = reader.nextLine();
        boolean isDeleted = register.deleteEntries(parameterString);
        if(isDeleted){
            System.out.println("Successfully deleted " + parameterString + " from the system!");
        }
        else{
            System.out.println("Could not find " + parameterString + ", please try again.");
        }
    }
/*
    public void fillDummyBooks(){
        Literature book = new Book("1984", "George Orwell", "Science Fiction","Egmont", 0);
        Literature book1 = new Book("Harry Potter and the deathly hallows", "JK Rowling", "Fantasy","Cappelenn", 0);
        Literature book2 = new Book("The hitchhikers guide to the galaxy", "Douglas Adams", "Science Fiction","Gyldendal", 0);

        register.addLiterature(book);
        register.addLiterature(book1);
        register.addLiterature(book2);

        Literature bookSeries = new BookSeries("Harry Potter", "Cappelenn", "JK Rowling", "Fantasy", 7);
        Literature bookSeries1 = new BookSeries("Ringenes Herre", "Gyldendal", "Tolkien", "Fantasy", 3);

        register.addLiterature(bookSeries);
        register.addLiterature(bookSeries1);

        Newspaper news = new Newspaper("VG", "Schibsted", "News",365);
        Newspaper news1 = new Newspaper("Østlandsposten", "OP", "News",365);
        Newspaper news2 = new Newspaper("E24", "Schibsted", "Economics",0);

        register.addLiterature(news);
        register.addLiterature(news1);
        register.addLiterature(news2);

        ComicBooks comicBooks = new ComicBooks("Batman", "DC", "Action", 52);
        ComicBooks comicBooks1 = new ComicBooks("Donald Duck", "Disney", "Comedy", 52);
        ComicBooks comicBooks2 = new ComicBooks("Naruto", "Japan", "Action", 52);

        register.addLiterature(comicBooks);
        register.addLiterature(comicBooks1);
        register.addLiterature(comicBooks2);

        Magazine magazine = new Magazine("Hjemmet", "Egmont", "Home improvement", 52);
        Magazine magazine1 = new Magazine("Jakt & Fiske", "NJFF", "Hobby", 52);

        register.addLiterature(magazine);
        register.addLiterature(magazine1);



    }
*/
    private String setLiteratureInfo(int maxLength, String type){
        String toBeAdded = "";


        Scanner reader = new Scanner(System.in);

        if(type.equals ("name")){
            toBeAdded = "Title";
        }
        else if(type.equals("genre")){
            toBeAdded = "Genre";
        }
        else if(type.equals("publisher")){
            toBeAdded = "Publisher";
        }
        else if(type.equals("author")){
            toBeAdded = "Author";
        }
        else if(type.equals("edition")){
            toBeAdded = "Edition";
        }
        else if(type.equals("yearlyEditions")){
            toBeAdded = "Yearly edition";
        }
        else if(type.equals("numberOfBooks")){
            toBeAdded = "Number of Books";
        }


        // Adds a string with user input
        System.out.println("Please write the " + toBeAdded.toLowerCase());


        // Checks that user input is allowed. Makes user redo it if not
        if((type.equals("name")||type.equals("genre")||type.equals("publisher")||type.equals("author"))){
            String literatureInfo = reader.nextLine();
        while ((literatureInfo.isEmpty() || literatureInfo.length() > maxLength)) {
            System.out.println(toBeAdded + " must not be 0 characters, and must be less than "
                    + maxLength + " characters. Try again.");
            literatureInfo = reader.nextLine();
        }
            System.out.println(toBeAdded + " has been set to: " + literatureInfo);
            return literatureInfo;
        }

        if(type.equals("edition")||type.equals("yearlyEditions")||type.equals("numberOfBooks")){
            int literatureInfo = reader.nextInt();

            while ((literatureInfo <= 0 || literatureInfo > maxLength)) {
                System.out.println(toBeAdded + " must not be 0 characters, and must be less than "
                        + maxLength + " characters. Try again.");
                literatureInfo = reader.nextInt();
            }
            System.out.println(toBeAdded + " has been set to: " + literatureInfo);
            return Integer.toString(literatureInfo);

        }
        return "Error";
    }

}
