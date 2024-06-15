package com._6bitcampers.nangman_doctor.servingPackage.jangwoo.login.loginController;

import com._6bitcampers.nangman_doctor.servingPackage.jangwoo.login.loginDto.customOAuth2User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class loginController {

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(value="error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception) {

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login";
    }

    @GetMapping("/addinfo")
    public String buf() {
        customOAuth2User customOAuth2User = (customOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        System.out.println(customOAuth2User.getType());
        return "addinfotem/"+customOAuth2User.getType();
    }
}
