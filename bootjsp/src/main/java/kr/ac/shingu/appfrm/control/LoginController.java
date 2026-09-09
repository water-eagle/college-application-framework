package kr.ac.shingu.appfrm.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {
    public LoginController() {
    }

    @GetMapping(path = { "", "login", "login.jsp" })
    public String index() {
        return "index";
    }

    @PostMapping("main")
    public String main(@RequestParam("username") String username,
            @RequestParam("userpwd") String userpwd,
            Model model) {
        model.addAttribute("username", username);
        model.addAttribute("userpwd", userpwd);
        return "main";
    }

}
