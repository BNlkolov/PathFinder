package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.CommentCreationDTO;
import bg.softuni.pathfinder.model.views.CommentDisplayView;
import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    public CommentService(RouteRepository routeRepository, UserRepository userRepository, CommentRepository commentRepository, CommentService commentService) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;

    }


    public CommentDisplayView createComment(CommentCreationDTO commentDto) {
        User author = userRepository.findByUsername(commentDto.getUsername()).get();
        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setRoute(routeRepository.getReferenceById(commentDto.getRouteId()));
        comment.setAuthor(userRepository.findByUsername(commentDto.getUsername()).get());
        comment.setApproved(true);
        comment.setText(commentDto.getMessage());

        commentRepository.save(comment);
        return new CommentDisplayView(author.getFullName(), commentDto.getMessage());
    }


}
