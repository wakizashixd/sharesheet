package th.ac.ku.sharesheet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.sharesheet.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


}
