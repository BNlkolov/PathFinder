package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinder.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm() {
        return new UserRegistrationDTO();
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDTO userRegistrationDTO
            , BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        System.out.println(userRegistrationDTO.toString());

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            return "redirect:/register";
        }
        //insert in dbt
        this.registerService.register(userRegistrationDTO);
        return "redirect:/login";

    }


}


