package conteudo;

import java.util.Objects;

enum BlogType {
    NEWS, ARTICLE
}

class Tuple {
    String author;
    BlogType type;

    public Tuple(String author, BlogType type) {
        this.author = author;
        this.type = type;
    }

    public Tuple() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogType getType() {
        return type;
    }

    public void setType(BlogType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Objects.equals(author, tuple.author) && type == tuple.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, type);
    }
}

public class Post {

    String title;
    String author;
    BlogType type;
    int likes;

    public Post() {
    }

    public Post(String title, String author, BlogType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogType getType() {
        return type;
    }

    public void setType(BlogType type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
