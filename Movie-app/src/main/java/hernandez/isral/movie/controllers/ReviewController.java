package hernandez.isral.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import hernandez.isral.movie.models.Review;
import hernandez.isral.movie.services.ReviewService;



@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    
    /** Service */
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        
        return new ResponseEntity<>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
    

}
