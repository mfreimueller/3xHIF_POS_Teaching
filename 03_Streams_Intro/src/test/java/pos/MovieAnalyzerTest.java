package pos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MovieAnalyzerTest {

    private MovieAnalyzer analyzer;
    private List<Movie> movies;

    @BeforeEach
    void setUp() {
        // Arrange
        analyzer = new MovieAnalyzer();
        movies = List.of(
                new Movie("Eraserhead", 1977, "Horror", 7.3),
                new Movie("The Elephant Man", 1980, "Drama", 8.2),
                new Movie("Dune", 1984, "Sci-Fi", 6.3),
                new Movie("Blue Velvet", 1986, "Thriller", 7.7),
                new Movie("Mulholland Drive", 2001, "Drama", 7.9),
                new Movie("Dune", 2021, "Sci-Fi", 8.0),
                new Movie("The Fabelmans", 2022, "Drama", 7.5),
                new Movie("Lynch/Oz", 2022, "Documentary", 7.0)
        );
    }

    @Test
    void verifyThatTitlesByGenreReturnsTheProperTitles() {
        // Arrange
        var expectedMovieTitles = List.of("Mulholland Drive", "The Fabelmans", "The Elephant Man").stream().sorted().toList();

        // Act
        var dramaMovies = analyzer.titlesByGenre(movies, "Drama").stream().sorted().toList();

        // Assert
        assertThat(dramaMovies)
                //.containsExactlyInAnyOrderElementsOf(expectedMovieTitles);
                .usingRecursiveComparison()
                .isEqualTo(expectedMovieTitles);
    }

    @Test
    void ensureThatUniqueGenresReturnsAllGenres() {
        // Arrange
        var expectedUniqueGenres = List.of("Horror", "Drama", "Sci-Fi", "Thriller", "Documentary");

        // Act
        var uniqueGenres = analyzer.uniqueGenres(movies);

        // Assert
        assertThat(uniqueGenres)
                //.containsExactlyInAnyOrderElementsOf(expectedMovieTitles);
                //.usingRecursiveComparison()
                .containsAll(expectedUniqueGenres);
    }
}
