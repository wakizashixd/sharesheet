package th.ac.ku.sharesheet.model;

import javax.persistence.*;

@Entity
@Table(name = "post", schema = "sharesheet")
public class Post {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int post_id;

    private String namepost;
    private String description;
    private String file;

    public Post(){

    }

    public Post(int post_id, String namepost, String description, String file) {
        this.post_id = post_id;
        this.namepost = namepost;
        this.description = description;
        this.file = file;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getNamepost() {
        return namepost;
    }

    public void setNamepost(String namepost) {
        this.namepost = namepost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", namePost='" + namepost + '\'' +
                ", description='" + description + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}