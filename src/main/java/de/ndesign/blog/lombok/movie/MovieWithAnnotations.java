package de.ndesign.blog.lombok.movie;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieWithAnnotations extends Movie {

    private final String name;
    private final int year;
    private List<String> genres;

}
