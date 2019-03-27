package litterature;

public class Litterature {
    private String title;
    private String genre;

    protected Litterature(String title, String genre){
        this.title = title;
        this.genre = genre;
    }

    public String getTitles(){
        return title;
    }
    protected String getGenres(){
        return genre;
    }
}
