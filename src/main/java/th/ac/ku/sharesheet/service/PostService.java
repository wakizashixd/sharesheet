package th.ac.ku.sharesheet.service;

import org.springframework.stereotype.Service;
import th.ac.ku.sharesheet.model.Post;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> postList;

    @PostConstruct
    public void postConstruct() {
        this.postList = new ArrayList<>();
    }

    public void createPost(Post post){
        postList.add(post);
    }
    public List<Post> getPosts() {
        return new ArrayList<>(this.postList);
    }
}