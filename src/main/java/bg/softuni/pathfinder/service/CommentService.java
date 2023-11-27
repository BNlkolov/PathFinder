package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.exceptions.RouteNotFoundExceptions;
import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.CommentCreationDTO;
import bg.softuni.pathfinder.model.views.CommentDisplayView;
import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;




    public CommentService(RouteRepository routeRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }
public List<CommentDisplayView> getAllCommentForRoute(Long routeId){
    Route route = routeRepository.findById(routeId).orElseThrow(RouteNotFoundExceptions::new);
        List<Comment> comments = commentRepository.findAllByRoute(route).get();
        return comments.stream().map(comment -> new CommentDisplayView(comment.getId(),
                comment.getAuthor().getFullName(),
                comment.getText())).collect(Collectors.toList());
}

    public CommentDisplayView createComment(CommentCreationDTO commentDto) {
        User author = userRepository.findByUsername(commentDto.getUsername()).get();

        Comment comment = new Comment();

        comment.setCreated(LocalDateTime.now());
        comment.setRoute(routeRepository.getReferenceById(commentDto.getRouteId()));
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setText(commentDto.getMessage());

        commentRepository.save(comment);

        return new CommentDisplayView(comment.getId(),author.getFullName(), comment.getText());
    }


}
