package exercise.controller;

import exercise.dto.CommentDto;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    // BEGIN
    @GetMapping(path = "/{postId}/comments")
    Iterable<Comment> getPostComments(@PathVariable Long postId) {
        return this.commentRepository.findCommentsByPostId(postId);
    }

    @GetMapping(path = "/{postId}/comments/{commentId}")
    public Comment getPostComment(@PathVariable Long postId, @PathVariable Long commentId) {

        return this.commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment" + commentId +  "not found"));
    }

    @PostMapping(path = "/{postId}/comments")
    public Comment createComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        Comment newComment = new Comment();
        newComment.setContent(commentDto.content());
        newComment.setPost(post);

        return this.commentRepository.save(newComment);
    }

    @PatchMapping(path = "/{postId}/comments/{commentId}")
    public Comment updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody CommentDto commentDto) {

        Comment commentForUpdate = this.commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment" + commentId + "not found"));

        commentForUpdate.setContent(commentDto.content());

        return this.commentRepository.save(commentForUpdate);
    }

    @DeleteMapping(path = "/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {

        Comment commentForDelete = this.commentRepository.findCommentByPostIdAndId(postId, commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment" + commentId + "not found"));

        commentRepository.delete(commentForDelete);
    }
    // END
}
