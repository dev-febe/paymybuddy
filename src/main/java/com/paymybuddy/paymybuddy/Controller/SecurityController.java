package com.paymybuddy.paymybuddy.Controller;

import com.paymybuddy.paymybuddy.Dto.UserDto;
import com.paymybuddy.paymybuddy.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {
    private UserService userService;

    SecurityController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        // validate the form and proceed to processing
        model.addAttribute("user", new UserDto());

        return "register";
    }

    @PostMapping("/register")
    public String submitRegister(@ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {
        // validate the form and proceed to processing
        if (!bindingResult.hasErrors()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userDto.setPassword(encoder.encode(userDto.getPassword()));
            this.userService.saveUser(userDto);
            model.addAttribute("user", new UserDto());
        }

        return "register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
