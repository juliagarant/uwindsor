package Lab2;

/**
 * A book has a title, author, year of publication, and number of pages.
 * Each is different depending on the book.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;

    public Book(String title){
        this.title = title;
        author = null;
        year = 0;
        pages = 0;
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        year = 0;
        pages = 0;
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public int getPages() {
        return pages;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

}
