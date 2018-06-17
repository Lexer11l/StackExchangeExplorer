package kmeshkov.model;

import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Topic {
    private String name;
    private String author;
    private String link;
    private String descripion; //maybe question, body message
    private boolean isAnswered;
    private Calendar calendar;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    public String getDescripion() {
        return descripion;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public Calendar getCalendar() {
        return calendar;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
