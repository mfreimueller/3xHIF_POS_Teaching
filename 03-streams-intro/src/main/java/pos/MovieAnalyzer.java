package pos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static java.util.Comparator.comparingDouble;

public class MovieAnalyzer {

    public List<String> titlesByGenre(List<Movie> movies, String genre) {
        //var titles =
        return movies.stream()
                .filter(m -> m.genre().equalsIgnoreCase(genre))
                .map(m -> m.title())
                // .map(Movie::title)
                .toList();
        // return titles;
    }

    public long countByRating(List<Movie> movies, double minRating) {
        return movies.stream()
                .filter(m -> m.rating() >= minRating)
                .count();
    }

    public List<String> uniqueGenres(List<Movie> movies) {
        return movies.stream()
                .map(m -> m.genre())
                // .map(Movie::genre)
                .distinct()
                .toList();
    }

    public List<String> topTitles(List<Movie> movies, int n) {
        return movies.stream()
                .sorted(comparingDouble(Movie::rating).reversed())
                .map(Movie::title)
                .limit(n)
                .toList();
    }

    public double averageMovieRating(List<Movie> movies) {
        return movies.stream()
                .mapToDouble(Movie::rating)
                .average().orElse(0.0);
    }

    public void printTitles(List<Movie> movies) {
        movies.stream()
                .map(Movie::title)
                .forEach(System.out::println);
                // .forEach(m -> System.out.println(m));
    }
}
