package registry;

import litterature.BookSeries;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * In charge of managing a list and supplying with details that it uses the list to find it.
 * Contains methods to:
 * <ul>
 *     <li> Add a book </li>
 *     <li> Print information on a book </li>
 *     <li> Print a list of all books in the collection </li>
 *     <li> Search for a book </li>
 *     <li> Delete a book </li>
 * </ul>
 *
 *
 */

public class BookSeriesRegister extends LitteratureRegister{

    /**
     * Field holds the list for the book collection
     */
    private ArrayList<BookSeries> bookSerie;

    /**
     *
     * Creates an arrayList called books
     */
    public BookSeriesRegister()
    {
        bookSerie = new ArrayList<>();
    }

    /**
     * Adds a book to the collection
     * @param bookSeries The book to be added to the collection
     */

    public void addBookSeries(BookSeries bookSeries)
    {

        bookSerie.add(bookSeries);
    }

    /**
     * Returns an iterator of the arrayList containing all books
     * @return an iterator of the arrayList containing all books
     */
    public Iterator<BookSeries> getIterator(){
        return this.bookSerie.iterator();
    }

    /**
     * Looks for a book with same title as searchTerm. Returns the object if found.
     * @param searchTerm Will look for a book with this title.
     * @return An object of Book, or null if it cannot find anything
     */

    public BookSeries search(String searchTerm){
        boolean found = false;
        BookSeries result = null;
        Iterator<BookSeries> it = bookSerie.iterator();
        while (it.hasNext() && !found)
        {
            BookSeries t = it.next();
            String title = t.getTitle();
            if (title.equals(searchTerm))
            {
                found = true;
                result = t;
            }
        }
        return result;
    }

    /**
     * Looks for a book with same title as parameter. if found, deletes it from arrayList.
     * @param titleToRemove Title of book
     * @return True if it finds an item to delete
     */

    public boolean deleteEntries(String titleToRemove){
        boolean isDeleted = false;
        BookSeries deleted = this.search(titleToRemove);
        if(deleted != null){
            isDeleted = true;
        }
        this.bookSerie.remove(deleted);
        return isDeleted;
    }
}