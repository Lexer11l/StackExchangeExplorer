package java.kmeshkov.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Topic implements Serializable {
    private ArrayList<String> tags;
    private Owner owner;
    private String title;
    private String author;
    private String link;
    private boolean is_answered;
    private Date creation_date;

    public ArrayList<String> getTags() {
        return tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    public boolean isAnswered() {
        return is_answered;
    }

    public Date getCreationDate() {
        return creation_date;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setIsAnswered(boolean isAnswered) {
        this.is_answered = isAnswered;
    }

    public void setCreationDate(Date creationDate) {
        this.creation_date = creationDate;
    }
}
