package th.ac.ku.sharesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.sharesheet.data.PostRepository;
import th.ac.ku.sharesheet.model.Post;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    private PostRepository repository;

    public PostService(PostRepository repository){
        this.repository = repository;
    }

    public Post findPost(int id){
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void createPost(Post post) {
        repository.save(post);
    }

    public List<Post> getPosts() {
        return repository.findAll();
    }


}