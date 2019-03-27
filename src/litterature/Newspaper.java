package litterature;

public class Newspaper extends Litterature{
    private String publisher;
    private int numberPublishedAYear;

    public Newspaper(String title, String publisher, String genre, int numberPublishedAYear){
        super(title, genre);
        this.publisher = publisher;
        this.numberPublishedAYear = numberPublishedAYear;
    }

    public String getTitle(){
        return super.getTitles();
    }

    public String getPublisher(){
        return publisher;
    }

    public String getGenre(){
        return super.getGenres();
    }

    public int getNumberPublishedAYear(){
        return numberPublishedAYear;
    }
}
