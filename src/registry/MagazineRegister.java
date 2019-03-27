package registry;

import litterature.Magazine;

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
 * Magazine magazine magazines
 */

public class MagazineRegister extends LitteratureRegister{

    /**
     * Field holds the list for the book collection
     */
    private ArrayList<Magazine> magazines;

    /**
     *
     * Creates an arrayList called books
     */
    public MagazineRegister()
    {
        magazines = new ArrayList<>();
    }

    /**
     * Adds a book to the collection
     * @param magazine The book to be added to the collection
     */

    public void addBook(Magazine magazine)
    {

        magazines.add(magazine);
    }

    /**
     * Returns an iterator of the arrayList containing all books
     * @return an iterator of the arrayList containing all books
     */
    public Iterator<Magazine> getIterator(){
        return this.magazines.iterator();
    }

    /**
     * Looks for a book with same title as searchTerm. Returns the object if found.
     * @param searchTerm Will look for a book with this title.
     * @return An object of Book, or null if it cannot find anything
     */

    public Magazine search(String searchTerm){
        boolean found = false;
        Magazine result = null;
        Iterator<Magazine> it = magazines.iterator();
        while (it.hasNext() && !found)
        {
            Magazine t = it.next();
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
        Magazine deleted = this.search(titleToRemove);
        if(deleted != null){
            isDeleted = true;
        }
        this.magazines.remove(deleted);
        return isDeleted;
    }
}