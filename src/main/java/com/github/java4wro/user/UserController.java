package com.github.java4wro.user;


import com.github.java4wro.user.dto.RegisterUserDTO;
import com.github.java4wro.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    List<UserDTO> getAll() {
        return userService.getAll();
    }

    @PostMapping(value = "/register")
    public RegisterUserDTO addUser(@RequestParam("password") String password, @RequestParam("confirmedPassword") String confirmedPassword, RegisterUserDTO registerUserDTO) {
        userService.validationOfPasswordIdenitiy(password, confirmedPassword);
        return userService.addUser(registerUserDTO);
    }

    @GetMapping(value = "/confirmRegistration")
    public ModelAndView confirmRegistration(@RequestParam("token") String token) {
        userService.confirmRegistration(token);
        return new ModelAndView("redirect:/login.html");
    }

    @PostMapping(value = "/resetForgotPassword")
    public void sendEmailWhenForgotPassword(@RequestParam("email") String email,
                                            @RequestParam("newPassword") String newPassword,
                                            @RequestParam("confirmNewPassword") String confirmNewPassword) {
        userService.sendEmailWhenForgotPassword(email, newPassword, confirmNewPassword);
    }

    @GetMapping(value = "/resetForgotPassword")
    public ModelAndView changePasswordsWhenForgot(@RequestParam("token") String token) {
        userService.changePasswordsWhenForgot(token);
        return new ModelAndView("redirect:/forgotPasswordChangeSuccessful.html");
    }

    @PostMapping(value = "/resetPassword")
    void sendEmailWhenResetPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword, @RequestParam("confirmNewPassword") String confirmNewPassword) {
        userService.sendEmailWhenResetPassword(email, newPassword, confirmNewPassword);
    }

    @GetMapping(value = "/resetPassword")
    public ModelAndView changePasswordsWhenReset(@RequestParam("token") String token) {
        userService.changePasswordsWhenReset(token);
        return new ModelAndView("redirect:/forgotPasswordChangeSuccessful.html");
    }

}
