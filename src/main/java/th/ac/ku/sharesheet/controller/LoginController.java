package th.ac.ku.sharesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.sharesheet.model.User;
import th.ac.ku.sharesheet.service.PostService;
import th.ac.ku.sharesheet.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UserService userService;
    private PostService postService;

    public LoginController(UserService userService,
                           PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping
    public String getLoginPage() {
        return "login";   // return login.html
    }

    @PostMapping
    public String login(@ModelAttribute User user, Model model) {
        // 1. เอา id กับ pin ไปเช็คกับข้อมูล user ที่มีอยู่ ว่าตรงกันบ้างไหม
        User matchingUser = userService.checkPin(user);

        // 2. ถ้าตรง ส่งข้อมูล user กลับไปแสดงผล
        if (matchingUser != null) {
            model.addAttribute("greeting",
                    "Welcome, " + matchingUser.getName());
        } else {
            // 3. ถ้าไม่ตรง แจ้งว่าไม่มีข้อมูล user นี้
            model.addAttribute("greeting", "Can't find User");
        }
        return "home";
    }


}
