package hernandez.isral.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import hernandez.isral.movie.models.Movie;
import hernandez.isral.movie.models.Review;
import hernandez.isral.movie.repository.ReviewRepository;

@Service
public class ReviewService {
    
    /**
     * Repository of the Review
     */
    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Template
     */
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * Create a review for the movie passed by imbd id
     */
    public Review createReview(String reviewBody, String imdbId) {
        
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Adding the new review to the Database
        mongoTemplate.update(Movie.class)
                        .matching(Criteria.where("imdbId").is(imdbId))
                        .apply(new Update().push("reviewIds").value(review))
                        .first();

        return review;

    }



}
