package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/add-route")
    public String route() {
        return "add-route";
    }


}
