package ru.orangeraze.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import ru.orangeraze.dto.UserDTO;
import ru.orangeraze.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String registration(UserDTO userDTO,
                               Model model) {
        userService.register(userDTO);

        model.addAttribute("messageType", "success");
        model.addAttribute("message", "На вашу электронную почту было отправлено письмо. Перейдите по ссылке, чтобы подтвердить свой аккаунт.");

        return "/login";
    }
}
