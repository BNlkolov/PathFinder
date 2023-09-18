package bg.softuni.pathfinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
        @GetMapping("/register")
        public String register(){
            return "register";
        }

}


