package th.ac.ku.sharesheet.model;

public class Post {
    private String namePost;
    private String description;
    private String file;

    public Post(String namePost, String description, String file) {
        this.namePost = namePost;
        this.description = description;
        this.file = file;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
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
}