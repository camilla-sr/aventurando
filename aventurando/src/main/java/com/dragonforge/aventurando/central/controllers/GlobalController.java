package com.dragonforge.aventurando.central.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.dragonforge.aventurando.central.models.Usuario;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {
	@Autowired
    private Sessao s;

    @ModelAttribute
    public void addGlobalAttributes(Model model, HttpSession session) {
        if (s.loginAtivo(session)) {
            model.addAttribute("userLogado", (Usuario) session.getAttribute("userLogado"));
        }
    }
}