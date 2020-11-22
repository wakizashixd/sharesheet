package th.ac.ku.sharesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.sharesheet.model.User;
import th.ac.ku.sharesheet.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getLoginPage() {
        return "login";   // return login.html
    }

    @PostMapping
    public String login(@ModelAttribute User customer, Model model) {
        // 1. เอา id กับ pin ไปเช็คกับข้อมูล customer ที่มีอยู่ ว่าตรงกันบ้างไหม
        User matchingCustomer = userService.checkPin(customer);

        // 2. ถ้าตรง ส่งข้อมูล customer กลับไปแสดงผล
        if (matchingCustomer != null) {
            model.addAttribute("greeting",
                    "Welcome, " + matchingCustomer.getName());
        } else {
            // 3. ถ้าไม่ตรง แจ้งว่าไม่มีข้อมูล customer นี้
            model.addAttribute("greeting", "Can't find customer");
        }
        return "home";
    }


}
