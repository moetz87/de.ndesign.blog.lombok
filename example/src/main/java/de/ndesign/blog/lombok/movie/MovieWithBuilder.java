package de.ndesign.blog.lombok.movie;

import java.util.List;

import lombok.*;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class MovieWithBuilder extends Movie {

    private final String name;
    private final int year;
    @Singular
    private List<String> genres;

}
