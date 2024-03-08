package hernandez.isral.movie.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    
    /** Id */
    @Id
    private ObjectId id;

    /** IMDB id */
    private String imdbId;

    /** Movie title */
    private String title;

    /** Release date of the movie */
    private String releaseDate;

    /** Trailer link */
    private String trailerLink;

    /** Poster image */
    private String poster;

    /** Genres */
    private List<String> genres;

    /**Backdrops images */
    private List<String> backdrops;

    /** Review ids */
    @DocumentReference
    private List<Review> reviewIds;

}
