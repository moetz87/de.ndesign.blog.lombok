package de.ndesign.blog.lombok.moviedb;

import de.ndesign.blog.lombok.movie.Movie;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
public class MovieDB {

    private final List<Movie> movies;

    @Synchronized
    public void addMovie(@NonNull Movie movie) {
        this.movies.add(movie);
    }

    @Synchronized
    public void removeMovie(@NonNull Movie movie) {
        this.movies.add(movie);
    }

}
