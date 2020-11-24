package th.ac.ku.sharesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {


//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String namepost;
    private String description;
    private String file;

    public Post(){

    }

    public Post(int id, String namepost, String description, String file) {
        this.id = id;
        this.namepost = namepost;
        this.description = description;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "post_id=" + id +
                ", namePost='" + namepost + '\'' +
                ", description='" + description + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}