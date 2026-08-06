package ru.alfabank.homework14;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));

        System.out.println(movies);

        movies.sort(new MovieRatingComparator());

        System.out.println(movies);

        Person person = new Person(
                "Петров Иван Васильевич",
                23,
                "0113 098765",
                223000.0
        );

        ObjectInspector.inspect(person);
    }
}
