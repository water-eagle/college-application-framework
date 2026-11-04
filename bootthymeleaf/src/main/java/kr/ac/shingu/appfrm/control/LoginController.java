package kr.ac.shingu.appfrm.control;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kr.ac.shingu.appfrm.repository.ChatUser;
import kr.ac.shingu.appfrm.repository.ChatUserRepository;

@Controller
@RequestMapping("/")
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    // public LoginController() {
    // }

    // @GetMapping("")
    // public String index() {
    // this.log.debug("index");
    // return "index";
    // }

    // @PostMapping("main")
    // public String main(@RequestParam("nickname") String nickname, Model model) {
    // this.log.debug("main");
    // model.addAttribute("nickname", nickname);
    // return "main";
    // }

    private final ChatUserRepository chatUserRepository;

    public LoginController(ChatUserRepository chatUserRepository) {
        this.chatUserRepository = chatUserRepository;
    }

    @GetMapping("")
    public String index(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "login";
        }
        Optional<ChatUser> chatUserOpt = this.chatUserRepository.findById(userId);
        if (chatUserOpt.isEmpty()) {
            return "login";
        }
        ChatUser chatUser = chatUserOpt.get();
        String nickname = chatUser.getNickname();
        model.addAttribute("nickname", nickname);
        return "main";
    }
}
