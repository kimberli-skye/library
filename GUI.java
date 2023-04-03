import ecs100.*;
/**
 *  Class to handle the GUI functionality
 *
 * @author KJ
 * @version 31/03
 */
public class GUI
{
    // instance variables 
    private Library books;
    private Book book;      // stores the current book instance

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Library();
        UI.initialise();
        
        // buttons
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("All Books", this::listBooks);
        UI.addButton("Clear Text", UI::clearText);
        UI.addButton("Quit", UI::quit);
        
        //set up mouse
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * Select object based on where the user clicks
     */
    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            // find top, bottom, left, and right most points
            // check if the x,y point is within boundaries
            if ((x >= book.getBookLeft()) && (x <= book.getBookRight()) &&
                (y >= book.getBookTop()) && (y <= book.getBookBottom())){
                // if yes -> Do something cool (put a heart sticker on book)
                final String
                HEARTIMAGE = "Heart.png";
                final double heartWidth = 50;
                final double heartHeight = 50;
                
                UI.drawImage(HEARTIMAGE, book.getBookLeft(), 
                             book.getBookTop(), heartWidth, heartHeight);     
            
                if (book.getLikes() == 0) {
                    UI.println("You liked " + book.getName());
                    book.addLike();
                } else {
                    UI.println(book.getName() + " has " + book.getLikes() + " likes 💗");
                    book.addLike();
                }
            }
            // if no -> Don't do anything
        }
    }

    /**
     * Add book to collection
     * 
     */
    public void addBook() {
        //Min and Max quantity
        final int MIN = 1;
        final int MAX = 999;
        
        //declares try again boolean (set as true)
        boolean tryAgain = true;
        
        // paragraph break for white space
        UI.println("\r");
        
        // Ask the user for details
        String name = UI.askString("Title: ").toUpperCase();
        String author = UI.askString("Author: ").toUpperCase();
        
        int quantity = UI.askInt("Quantity: ");
        
        // while loop to check quantity
        // while try again = true:
        // if it is between max and min, try again = false
        // breaks the loop
        // else re ask quantity
        while (tryAgain = true) {
            if (quantity >= MIN && quantity <= MAX) {
                tryAgain = false;
                break;
            } else {
                UI.println("HAH No");
                quantity = UI.askInt("Quantity: ");
            }
        }
        
        int date = UI.askInt("What date was the book published? ");
        
        String genre = UI.askString("What is the Genre? ");
            
        // add a book image for display in GUI
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // always set as 0 first
        int likes = 0;
        
        books.addBook(name, author, quantity, date, genre, imgFileName, likes);
    }
    
    /**
     * Find book
     */
    public void findBook() {
        // paragraph break for white space
        UI.println("\r");
        
        String bookName = UI.askString("Name of book: ").toUpperCase();
        if (books.findBook(bookName)) {
            // paragraph break for white space
            UI.println("\r");
            UI.println("We have that book");
            book = books.getBook();
            UI.println("Author: " + book.getAuthor());
            UI.println("Genre: " + book.getGenre());
            UI.println("Date published: " + book.getDate());
            UI.println("No. of Books: " + book.getQuantity());
            book.displayBook();   // show cover
        } else {
            // paragraph break for white space
            UI.println("\r");
            UI.println("Book not found");
        }
    }
    

    /**
     * Prints out titles of each book
     */
    public void listBooks() {
        // clear image pane
        UI.clearGraphics();
        books.printBooks();
    }
}