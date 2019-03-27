package registry;

import litterature.Newspaper;
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

public class NewspaperRegister extends LitteratureRegister{

    /**
     * Field holds the list for the book collection
     */
    private ArrayList<Newspaper> newspapers;

    /**
     *
     * Creates an arrayList called books
     */
    public NewspaperRegister()
    {
        newspapers = new ArrayList<>();
    }

    /**
     * Adds a book to the collection
     * @param newspaper The book to be added to the collection
     */

    public void addBook(Newspaper newspaper)
    {

        newspapers.add(newspaper);
    }

    /**
     * Returns an iterator of the arrayList containing all newspapers
     * @return an iterator of the arrayList containing all newspapers
     */
    public Iterator<Newspaper> getIterator(){
        return this.newspapers.iterator();
    }

    /**
     * Looks for a book with same title as searchTerm. Returns the object if found.
     * @param searchTerm Will look for a book with this title.
     * @return An object of Book, or null if it cannot find anything
     */

    public Newspaper search(String searchTerm){
        boolean found = false;
        Newspaper result = null;
        Iterator<Newspaper> it = newspapers.iterator();
        while (it.hasNext() && !found)
        {
            Newspaper t = it.next();
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
        Newspaper deleted = this.search(titleToRemove);
        if(deleted != null){
            isDeleted = true;
        }
        this.newspapers.remove(deleted);
        return isDeleted;
    }
}