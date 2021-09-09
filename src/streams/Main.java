package streams;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        // Stream consists of processing a collection of data in a declarative way
        List<Movie> movies = List.of(
                new Movie("a",30),
                new Movie("b",20),
                new Movie("c",10)
        );
        var count = movies.stream()
                .filter(movie->movie.getLikes()>10)
                .count();

        System.out.println(count);
    }
}
