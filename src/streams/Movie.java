package streams;

public class Movie {
    private String title;
    private int likes;



    private Genre genre;

    public Movie(String title, int likes,Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre=genre;
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return this.title;
    }

    public Genre getGenre() {
        return genre;
    }
    @Override
    public String toString() {
        return "Movie [ " + title + " , " + likes + " ]";
    }
}
