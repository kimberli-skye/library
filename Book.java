import ecs100.*;
/**
 * Support Class
 *A book that contains a name, author, qty, image
 *
 * @author KJ
 * @version 31/03
 */
public class Book
{
    // instance variables
    private String name;    // book title
    private String author;  // author name
    private int quantity;   // how many copies
    private int publishDate;
    private String genre;
    private int likes;
    private String image;   // cover art
    private static final String
    DEFAULT_IMAGE = "book_face.jpg";
    
    private int locX = 50;
    private int locY = 50;
    final int WIDTH = 220;
    final int HEIGHT = 300;
    
    
    /**
     * Constructor for objects of class Book
     */
    public Book(String nm, String auth, int qty, int date, String genre, String img, int likes) {
        // initialise instance variables
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.publishDate = date;
        this.genre = genre;
        this.likes = likes;
        
        if (img == null) {
            this.image = DEFAULT_IMAGE;
        } else {
            this.image = img;
        }
    }

    /**
     * Constructor overloading objects of class
     */
    public Book(String nm, String auth, int date, String genre, int qty, int likes) {
        // initialise variables
        this(nm, auth, qty, date, genre, DEFAULT_IMAGE, likes);
            
    }
    
    /**
     * Getter for name, author, quantiy, date, genre, likes etc.
     */
    public String getName() {
        return this.name;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public int getDate() {
        return this.publishDate;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public int getLikes() {
        return this.likes;
    }
    
    /**
     * Adds a like to likes
     */
    public void addLike() {
        likes++;
    }
    
    /** 
     * display image on GUI
     */
    public void displayBook() {
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    // return book covers position on screen
    
    public int getBookTop() {
        int top = this.locX;
        return top;
    }
    
    public int getBookBottom() {
        int bottom = this.HEIGHT;
        return bottom;
    }
    
    public int getBookRight() {
        int right = this.WIDTH;
        return right;
    }
    
    public int getBookLeft() {
        int left = this.locX;
        return left;
    }
}
