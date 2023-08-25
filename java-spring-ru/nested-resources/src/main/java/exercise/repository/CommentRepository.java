package exercise.repository;

import exercise.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    // BEGIN
    Iterable<Comment> findCommentsByPostId(Long id);
    Optional<Comment> findCommentByPostIdAndId(Long postId, Long commentId);
    // END
}
