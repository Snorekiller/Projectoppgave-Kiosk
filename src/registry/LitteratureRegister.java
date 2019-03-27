package registry;

import litterature.Litterature;

import java.util.ArrayList;
import java.util.Iterator;

public class LitteratureRegister {

    /**
     * Field holds the list for the book collection
     */
    private ArrayList<Litterature> litteratures;

    /**
     *
     * Creates an arrayList called books
     */
    public LitteratureRegister()
    {
        litteratures = new ArrayList<>();
    }

    /**
     * Adds a book to the collection
     * @param litterature The book to be added to the collection
     */

    public void addBook(Litterature litterature)
    {

        litteratures.add(litterature);
    }

    /**
     * Returns an iterator of the arrayList containing all books
     * @return an iterator of the arrayList containing all books
     */
    public Iterator<Litterature> getIterator(){
        return this.litteratures.iterator();
    }

    /**
     * Looks for a book with same title as searchTerm. Returns the object if found.
     * @param searchTerm Will look for a book with this title.
     * @return An object of Book, or null if it cannot find anything
     */

    public Litterature search(String searchTerm){
        boolean found = false;
        Litterature result = null;
        Iterator<Litterature> it = litteratures.iterator();
        while (it.hasNext() && !found)
        {
            Litterature t = it.next();
            String title = t.getTitles();
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
        Litterature deleted = this.search(titleToRemove);
        if(deleted != null){
            isDeleted = true;
        }
        this.litteratures.remove(deleted);
        return isDeleted;
    }
}
