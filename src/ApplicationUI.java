
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
 */
public class ApplicationUI
{
    private BookRegister bookRegister;
   
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "literature"
    // etc.
    private String[] menuItems = {
        "1. List all books",
        "2. Add new books",
        "3. Find a product by books",
        "4. Delete a books",
        "5. Fill with dummy books",
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
                int menuSelection = this.showMenu();
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllBooks();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        this.findBookByName();
                        break;

                    case 4:
                        this.deleteBook();
                        break;

                    case 5:
                        this.fillDummyBooks();
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
    private int showMenu() throws InputMismatchException 
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
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
        bookRegister = new BookRegister();
    }

    /**
     * Lists all the items in the register and the amount of items
     */
    private void listAllBooks()
    {
        int i = 1;
        int numberOfBooks = 0;
        Iterator<Book> bookItList = this.bookRegister.getIterator();
        while (bookItList.hasNext()){
            if(i == 1){
                System.out.println("This is a list of all your books: ");
                i++;
            }
            Book book = bookItList.next();
            System.out.println("Title: " + book.getTitle() + ". Author: " + book.getAuthor()
             + ". Genre: " + book.getGenre());
            numberOfBooks++;
            if(!bookItList.hasNext()){
                System.out.println("There are " + numberOfBooks + " books in the system.");
            }
        }
        if(i == 1){
            System.out.println("There are no books here.");
        }
    }

    
    /**
     * Add a new product/literature to the register.
     * takes input from the user for title, author and genre.
     * lets you try again if you enter nothing or too many characters.
     */
    private void addNewBook()
    {
            // Creates reader scanner object (reads input from user)
            Scanner reader = new Scanner(System.in);

            // Adds a string with user input
            System.out.println("Please write the title of the book.");
            String name = reader.nextLine();

            // Checks that user input is allowed. Makes user redo it if not
            while(name.isEmpty() || name.length() > 50){
                System.out.println("Name must not be 0 characters, and must be less than 50 characters. Try again.");
                name = reader.nextLine();
            }

            System.out.println("Name has been set to: " + name);

            // Adds a string with user input
            System.out.println("Please write the author of the book.");
            String author = reader.nextLine();

            // Checks that user input is allowed. Makes user redo it if not
            while(author.isEmpty() || author.length() > 30){
                System.out.println("Author must not be 0 characters, and must be less than 30 characters. Try again.");
                author = reader.nextLine();
            }
            System.out.println("Author set to: " + author);

            // Adds a string with user input
            System.out.println("Please write the genre of the book.");
            String genre = reader.nextLine();

            // Checks that user input is allowed. Makes user redo it if not
            while(genre.isEmpty() || genre.length() > 30){
                System.out.println("Genre must not be 0 characters, and must be less than 30 characters. Try again.");
                genre = reader.nextLine();
            }
            System.out.println("Genre set to: " + genre);


        // Creates book object and adds it's information to a list.
        // I think next time, it will create another book object and the last one wil be deleted? updated? lost in space? who knows..
        Book book = new Book(name, author, genre);
        bookRegister.addBook(book);

    }

    /**
     * Find and display a product based om name (title).
     * displays author and genre
     */
    private void findBookByName()
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please write the title of the book you are searching for:");
        String parameterString = reader.nextLine();
        Book bookSearch = bookRegister.search(parameterString);
        if(bookSearch == null){
            System.out.println("No book matches that name");
        }
        else{
            System.out.println("This book is currently in your system");
            System.out.println("Author: " + bookSearch.getAuthor());
            System.out.println("Genre: " + bookSearch.getGenre());
        }
    }

    /**
     * Will send your input to deleteEntries in BookRegister and delete it if it exists
     */
    private void deleteBook()
    {
        System.out.println("deleteBook() was called");
        System.out.println("Write the title of the book you want to delete.");
        Scanner reader = new Scanner(System.in);
        String parameterString = reader.nextLine();
        boolean isDeleted = bookRegister.deleteEntries(parameterString);
        if(isDeleted){
            System.out.println("Successfully deleted " + parameterString + " from the system!");
        }
        else{
            System.out.println("Could not find " + parameterString + ", please try again.");
        }
    }

    private void fillDummyBooks(){
        Book book = new Book("1984", "George Orwell", "Science Fiction");
        Book book1 = new Book("Harry Potter and the deathly hallows", "JK Rowling", "Fantasy");
        Book book2 = new Book("The hitchhikers guide to the galaxy", "Douglas Adams", "Science Fiction");

        bookRegister.addBook(book);
        bookRegister.addBook(book1);
        bookRegister.addBook(book2);
    }
}
