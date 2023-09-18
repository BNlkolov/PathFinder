package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovementController {

    @GetMapping("/pedestrian")
    public String pedestrian() {
        return "pedestrian";
    }

    @GetMapping("/bicycle")
    public String bicycle() {
        return "bicycle";
    }

    @GetMapping("/motorcycle")
    public String motorcycle() {
        return "motorcycle";
    }

    @GetMapping("/car")
    public String car() {
        return "car";
    }


}
