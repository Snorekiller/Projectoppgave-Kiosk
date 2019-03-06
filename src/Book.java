/**
 * Everytime we get a new book we create an object of the book class.
 * Has methods to:
 * <ul>
 *     <li> Set Title, Author and Genre </li>
 *     <li> Get Title </li>
 *     <li> Get Author </li>
 *     <li> Get Genre </li>
 * </ul>
 *
 *
 */

public class Book {

	/**
	 * Fields holds the title, author and genres of the book
	 */

	private String title;
	private String author;
	private String genre;

	/**
	 * Sets the details of new book
	 * @param title Title of the book
	 * @param author Author of the book
	 * @param genre Genre of the book
	 */

	public Book(String title, String author, String genre) {

			this.title = title;
			this.author = author;
			this.genre = genre;

	}
	/**
	 * Returns title
	 * @return Title of book
	 */
	public String getTitle()
	{

		return title;
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
		return genre;
	}
}