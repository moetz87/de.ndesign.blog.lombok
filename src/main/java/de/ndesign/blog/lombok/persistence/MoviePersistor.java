package de.ndesign.blog.lombok.persistence;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.ndesign.blog.lombok.movie.Movie;
import de.ndesign.blog.lombok.movie.MovieWithAnnotations;
import lombok.Cleanup;
import lombok.SneakyThrows;

public class MoviePersistor {

    private static final Gson GSON = new Gson();
    private static final Type MOVIELIST_TYPE = new TypeToken<List<MovieWithAnnotations>>() {
    }.getType();

    @SneakyThrows(IOException.class)
    public List<Movie> loadMovies(File file) {
        @Cleanup
        InputStream inputStream = new FileInputStream(file);
        @Cleanup
        Reader reader = new InputStreamReader(inputStream);
        return GSON.fromJson(reader, MOVIELIST_TYPE);
    }

    public void saveMovies(List<Movie> movies, File file) throws IOException {
        String json = GSON.toJson(movies);
        @Cleanup
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(json.getBytes());
    }

}
