package com._6bitcampers.nangman_doctor;

import com._6bitcampers.nangman_doctor.servingPackage.jangwoo.login.loginService.roleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
@RequiredArgsConstructor
public class homeController {
    private final roleService roleService;

    @GetMapping("/")
    public String home() {
        //로그인 시 이메일 출력
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return roleService.checkRole(role);
    }
}
