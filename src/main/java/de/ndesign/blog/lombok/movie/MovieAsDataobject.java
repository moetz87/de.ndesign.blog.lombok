package de.ndesign.blog.lombok.movie;

import lombok.Data;

import java.util.List;

@Data
public class MovieAsDataobject extends Movie {

    private final String name;
    private final int year;
    private List<String> genres;

}
