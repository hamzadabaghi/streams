package streams;

public class Movie {
    private String title;
    private int likes;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Movie [ " + title + " , " + likes + " ]";
    }
}
