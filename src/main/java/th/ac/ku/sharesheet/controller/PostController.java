package th.ac.ku.sharesheet.controller;

import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String createPost(@ModelAttribute Post post,Model model){
        postService.createPost(post);
        model.addAttribute("allPost",postService.getPosts());
        return "redirect:post";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable int id,
                                @ModelAttribute Post post,
                                Model model){
        postService.deletePost(post);
        model.addAttribute("allPost",postService.getPosts());
        return "post";
    }




}