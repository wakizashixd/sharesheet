package th.ac.ku.sharesheet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.sharesheet.model.Post;

import java.util.Arrays;
import java.util.List;


@Service
public class PostService {

    private RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public List<Post> getUserPostAccount(int post_id) {
        String url = "http://localhost:8081/api/post/" +
                post_id;
        ResponseEntity<Post[]> response =
                restTemplate.getForEntity(url, Post[].class);

        Post[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

    public List<Post> getPosts() {
        String url = "http://localhost:8081/api/post/";
        ResponseEntity<Post[]> response =
                restTemplate.getForEntity(url, Post[].class);

        Post[] accounts = response.getBody();

        return Arrays.asList(accounts);

    }

    public void createPost(Post post){
        String url = "http://localhost:8081/api/post/";
        restTemplate.postForObject(url, post, Post.class);
    }


    public void deletePost(Post post){
        String url = "http://localhost:8081/api/post/" +
                post.getId();
        restTemplate.delete(url,post);
    }


}