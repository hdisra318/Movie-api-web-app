package hernandez.isral.movie.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import hernandez.isral.movie.models.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
    
    Optional<Movie> findMovieByImdbId(String imdbId);
}
