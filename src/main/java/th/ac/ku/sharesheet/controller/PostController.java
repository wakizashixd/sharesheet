package th.ac.ku.sharesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.sharesheet.model.Post;
import th.ac.ku.sharesheet.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String getPostPage(Model model){
        model.addAttribute("allPost",postService.getPosts());
        return "post";
    }

    @PostMapping
    public String CreatePost(@ModelAttribute Post post,Model model){
        postService.createPost(post);
        model.addAttribute("allPosts",postService.getPosts());
        return "redirect:post";
    }
}
