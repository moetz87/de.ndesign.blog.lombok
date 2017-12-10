package de.ndesign.blog.lombok.movie;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.List;

@Value
public class MovieAsImmutable extends Movie {

    String name;
    int year;
    @NonFinal
    List<String> genres;

}
