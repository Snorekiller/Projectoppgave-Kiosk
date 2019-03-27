package litterature;

public class BookSeries extends Litterature {

    /**
     * Fields holds the title, author and genres of the book
     */

    private String author;
    private int numberInSeries;

    /**
     * Sets the details of new book
     * @param title Title of the book
     * @param author Author of the book
     * @param genre Genre of the book
     */

    public BookSeries(String title, String author, String genre, int numberInSeries) {
        super(title, genre);
        this.author = author;
        this.numberInSeries = numberInSeries;

    }
    /**
     * Returns title
     * @return Title of book
     */
    public String getTitle()
    {
        return super.getTitles();
    }

    /**
     *
     * Returns author
     * @return Author of book
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     *
     * Returns genre
     * @return Genre of book
     */
    public String getGenre()
    {
        return super.getGenres();
    }

    public int getNumberInSeries(){
        return numberInSeries;
    }
}
