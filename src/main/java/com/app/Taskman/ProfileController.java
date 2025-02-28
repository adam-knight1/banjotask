package com.app.Taskman;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        if (oidcUser != null) {
            model.addAttribute("name", oidcUser.getFullName());
            model.addAttribute("email", oidcUser.getEmail());
        }
        return "profile";
    }
}

