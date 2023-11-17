package bg.softuni.pathfinder.web;


import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.views.UserProfileView;
import bg.softuni.pathfinder.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class ProfileController {
    AuthService authService;
    public ProfileController(AuthService registerService) {
        this.authService = registerService;
    }


    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
    String username = principal.getName();
        User user = authService.getUser(username);
        UserProfileView userProfileView = new UserProfileView(username,
                user.getEmail(),
                user.getFullName(),
                user.getAge(),
                user.getLevel() != null ? user.getLevel().name() : "BEGINNER"
        );

        model.addAttribute("user",userProfileView);

        return "profile";
    }
}
