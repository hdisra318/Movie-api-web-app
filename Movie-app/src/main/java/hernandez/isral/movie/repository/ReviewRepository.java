package hernandez.isral.movie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import hernandez.isral.movie.models.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    
}
