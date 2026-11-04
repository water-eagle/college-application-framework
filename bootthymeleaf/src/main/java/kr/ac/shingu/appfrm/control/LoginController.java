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

import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping("login")
    public String login(@RequestParam("userId") String userId,
            @RequestParam("userPwd") String userPwd,
            HttpServletRequest request, Model model) {
        this.log.debug("userId: {}, pwd {}", userId, userPwd);
        Optional<ChatUser> chatUserOpt = this.chatUserRepository.findById(userId);
        if (chatUserOpt.isEmpty()) {
            return "login";
        }
        ChatUser chatUser = chatUserOpt.get();
        if (chatUser.getUserPwd().equals(userPwd) == false) {
            return "login";
        }
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        session = request.getSession(true);
        session.setAttribute("userId", userId);

        return "redirect:/";
    }

    // 회원가입
    @GetMapping("joinform")
    public String joinform() {
        return "joinform";
    }

    @PostMapping("join")
    public String join(ChatUser chatUser) {
        this.log.debug("new User: {}", chatUser);
        this.chatUserRepository.save(chatUser);
        return "redirect:/";
    }
}
