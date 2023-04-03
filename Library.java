    import java.util.HashMap;
import ecs100.*;
/**
 * Holds collection of books in a hashmap
 * allows users to add, find, and print all
 *
 * @author kj
 * @version 31/03
 */
public class Library
{
    // instance variables
    private HashMap<Integer, Book> booksMap;    // declare hashmap
    
    // store the current id of added book
    private int currentBookID;  
    
    // stores instance of the found book
    private Book currentBook;
    

    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // initialise instance variables
        booksMap = new HashMap<Integer, Book>(); // initialise hashmap
    
        // Create some books
        Book b1 = new Book("HARRY POTTER", "J. K. ROWLING", 20, 1997 ,"FANTASY", "harrypotter.jpg", 0);
        Book b2 = new Book("A WIZARD OF EARTHSEA", "URSULA K. LE GUIN", 50, 1968, "FANTASY", "WizardEarthSea.jpg", 0);
        Book b3 = new Book("SIX OF CROWS", "LEIGH BARDUGO", 250, 2015, "FANTASY", "sixOfCrows.jpg", 0);
        Book b4 = new Book("LITTLE WOMEN", "LOUISA MAY ALCOTT", 18, 1868, "AUTO-BIOGRAPHICAL", "LittleWomen.jpg", 0);

        // add books to collections
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        booksMap.put(4, b4);
        
        this.currentBookID = 4;
    }

    /**
     * Add books to hashmap
     */
    public void addBook(String nm, String auth, int qty, int date, String genre, String img, int likes) {
        currentBookID++;    // plus one to book ID
        booksMap.put(currentBookID, new Book(nm, auth, qty, date, genre, img, likes));
    }
    
    /**
     * Finds books in the hashmap 
     * returns boolean
     */
    public boolean findBook(String name) {
        for (int currentBookID : booksMap.keySet()) {
            if (booksMap.get(currentBookID).getName().equals(name)) {
                currentBook = booksMap.get(currentBookID);
                return true;
            }
        }
        return false;       // if not found
    }
    
    /**
     * Iterates through each book and prints title
     */
    public void printBooks() {
        for (int currentBookID : booksMap.keySet()) {
            // paragraph break for white space
            UI.println("_______________________");
            UI.println(booksMap.get(currentBookID).getName());
            UI.println(booksMap.get(currentBookID).getGenre());
        }
    }
    
    /**
     * Getter for current book
     */
    public Book getBook() {
        return this.currentBook;
    }
}
