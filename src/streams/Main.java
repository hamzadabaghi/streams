package streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        // Stream consists of processing a collection of data in a declarative way

        List<Movie> movies = List.of(

                new Movie("a",30,Genre.ACTION),
                new Movie("a",30,Genre.LOVE),
                new Movie("b",20,Genre.LOVE),
                new Movie("c",10,Genre.HORROR)
        );

        System.out.println("------------Stream of objects, short demo---------------");

        var count = movies.stream()
                .filter(movie->movie.getLikes()>10)
                .count();

        System.out.println(count);


        // streams are applicable on collections, Array, arbitrary number of objects, infinite/finite streams

        System.out.println("------------Stream of array ---------------");

        // arrays
        int[] numbers = {1,2,3};
        Arrays.stream(numbers).forEach(System.out::println);

        System.out.println("------------Stream of arbitrary objects---------------");
        // arbitrary objects
        var c=Stream.of(1,2,"hello",8).count();
        System.out.println("count of random objects : "+c);

        System.out.println("------------Infinite Stream generate---------------");

        // creating stream with limit
        Stream.generate(Math::random)
                .limit(5)
                .forEach(n-> System.out.println(Math.round(n*10)));

        System.out.println("------------Infinite Stream using iterate---------------");

        // Generating infinite stream

        Stream.iterate(1,n->n+1)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("------------Map---------------");

        // Transform the values in a stream using the map functions

        movies.stream()
                .map(Movie::getTitle)
                .forEach(System.out::println);

        System.out.println("------------Flat map---------------");

        // mapping using flatmap , we can flatten a string

        var stream = Stream.of(List.of(1,2,3),List.of(4,5,6));
        stream.flatMap(Collection::stream)
                        .forEach(System.out::println);

        // filtering

        System.out.println("-----------Filtering----------------");

        Predicate<Movie> isPopular = m -> m.getTitle().equals("a");
        movies.stream()
                .filter(isPopular)
                .forEach(System.out::println);

        System.out.println("-----------Slicing using limit----------------");

        // Slicing streams : limit , skip , takewhile , dropwhile

        movies.stream()
                .limit(2)
                .forEach(System.out::println);


        System.out.println("-----------Slicing using skip----------------");

        movies.stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("-----------Slicing using takewhile ----------------");

        // it stops the moment the predicate returns false , dropwhile the opposite
        movies.stream()
                .takeWhile(m->m.getLikes()!=10)
                .forEach(System.out::println);

        System.out.println("-----------Sorting ----------------");

        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);

        System.out.println("-----------Unique values ----------------");

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);

        System.out.println("-----------Peeking elements ----------------");

        movies.stream()
                .filter(m->m.getLikes()>10)
                .peek(m-> System.out.println("Filtered : "+m.getTitle()))
                .forEach(System.out::println);

        System.out.println("-----------Simple Reducers : any match----------------");

        var result = movies.stream()
                .anyMatch(m->m.getLikes()>10);

        System.out.println(result);

        System.out.println("-----------Simple Reducers : all match----------------");

        // noneMatch the opposite
        var r = movies.stream()
                .allMatch(m->m.getLikes()>10);

        System.out.println(r);

        System.out.println("-----------Simple Reducers : find first ----------------");

        // there is also max , findAny ...
        var movie = movies.stream()
                .findFirst( )
                .get();

        System.out.println(movie.getTitle());

        System.out.println("----------- Reducers : single value ----------------");

        //optional : the stream may return or not a value
        Optional<Integer> sum = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);

        // or else , we supply a default value
        System.out.println(sum.orElse(0));


        System.out.println("----------- Collectors ----------------");

        // toMap ...
        var topMovies = movies.stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.toList());


        System.out.println("----------- Grouping elements ----------------");

        var re = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        System.out.println(re);

        // we have also partitioning , some variation of stream : IntStream , LongStream ....











    }
}
