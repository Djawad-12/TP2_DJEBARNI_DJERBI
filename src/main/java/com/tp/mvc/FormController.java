package com.tp.mvc;

import com.tp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {

    private final MessageService service;

    @Autowired
    public FormController(MessageService service) {
        this.service = service;
    }

    // --- CE QU'IL MANQUAIT ---
    // Cette méthode permet d'afficher la page form.jsp quand on tape l'URL /form
    @RequestMapping("/form")
    public String showForm() {
        return "form"; // Renvoie vers /WEB-INF/views/form.jsp
    }
    // -------------------------

    @PostMapping("/send")
    public String send(@RequestParam String content, Model model) {
        // Appelle le service pour mettre en majuscule
        model.addAttribute("msg", service.process(content));
        return "result"; // Renvoie vers /WEB-INF/views/result.jsp
    }
}