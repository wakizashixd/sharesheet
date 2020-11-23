package th.ac.ku.sharesheet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.sharesheet.service.PostService;

@Controller
public class HomeController {

    private PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("greeting", "Sawaddee");
        model.addAttribute("allPost",postService.getPosts());
        // return home.html
        return "home";
    }

}
