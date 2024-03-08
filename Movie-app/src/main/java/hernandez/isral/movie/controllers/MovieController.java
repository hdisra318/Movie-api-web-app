package hernandez.isral.movie.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hernandez.isral.movie.models.Movie;
import hernandez.isral.movie.services.MovieService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    
    /** Service */
    @Autowired
    private MovieService movieService;

    /** 
     * Return all the movies 
    */
    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies() {

        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
    

    /**
     * Return a movie
     */
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId) {
        
        return new ResponseEntity<Optional<Movie>>(movieService.getMovie(imdbId), HttpStatus.OK);
    }
    
}
