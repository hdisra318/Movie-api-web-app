package hernandez.isral.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hernandez.isral.movie.repository.MovieRepository;

import hernandez.isral.movie.models.Movie;

@Service
public class MovieService {
    
    /** Repository object */
    @Autowired
    private MovieRepository movieRepository;

    /**
     * Return all the movies
     */
    public List<Movie> getAllMovies() {
        
        return movieRepository.findAll();
    }


    /**
     * Return one movie
     */
    public Optional<Movie> getMovie(String imdbId) {

        return movieRepository.findMovieByImdbId(imdbId);
    }
}
