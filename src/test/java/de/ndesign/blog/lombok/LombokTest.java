package de.ndesign.blog.lombok;

import de.ndesign.blog.lombok.movie.*;
import de.ndesign.blog.lombok.moviedb.MovieDB;
import de.ndesign.blog.lombok.persistence.MoviePersistor;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LombokTest {

    private static final Path moviesPath = Paths.get("src", "test", "resources", "movies.json");
    private static MoviePersistor moviePersistor;
    private static MovieDB movieDB;

    @BeforeClass
    public static void beforeClass() throws Exception {
        moviePersistor = new MoviePersistor();
        List<Movie> movies = moviePersistor.loadMovies(moviesPath.toFile());
        movieDB = new MovieDB(movies);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        moviePersistor.saveMovies(new LinkedList<>(), moviesPath.toFile());
    }

    @Test
    public void addMovieWithAnnotations() throws Exception {
        // Prepare
        MovieWithAnnotations movie = new MovieWithAnnotations("Der Soldat James Ryan", 1998);
        movie.setGenres(Arrays.asList("Krieg", "Drama"));
        // Act
        movieDB.addMovie(movie);
        // Verify
        log.info("MovieDB: {}", movieDB);
    }

    @Test
    public void addMovieAsDataobject() throws Exception {
        // Prepare
        MovieAsDataobject movie = new MovieAsDataobject("Der Soldat James Ryan", 1998);
        movie.setGenres(Arrays.asList("Krieg", "Drama"));
        //Act
        movieDB.addMovie(movie);
        // Verify
        log.info("MovieDB: {}", movieDB);
    }

    @Test
    public void addMovieAsImmutable() throws Exception {
        // Prepare
        MovieAsImmutable movie = new MovieAsImmutable("Der Soldat James Ryan", 1998, Arrays.asList("Krieg", "Drama"));
        //Act
        movieDB.addMovie(movie);
        // Verify
        log.info("MovieDB: {}", movieDB);
    }

    @Test
    public void addMovieWithBuilder() throws Exception {
        // Prepare
        MovieWithBuilder movie = MovieWithBuilder.builder()
                .name("Der Soldat James Ryan")
                .year(1998)
                .genre("Krieg")
                .genre("Drama").build();
        //Act
        movieDB.addMovie(movie);
        // Verify
        log.info("MovieDB: {}", movieDB);
    }


}
