
public class Book extends Literature {

	/**
	 * Fields holds the title, author and genres of the book
	 */
	private String author;
	private int edition;

	/**
	 * Sets the details of new book
	 * @param title Title of the book
	 * @param author Author of the book
	 * @param genre Genre of the book
	 */

	public Book(String title, String genre, String publisher, String author, int edition) {

		super(title, genre, publisher);
		this.edition = edition;
		this.author = author;
	}


	public int getEdition(){
		return edition;
	}

	public String getAuthor(){
		return author;
	}
}