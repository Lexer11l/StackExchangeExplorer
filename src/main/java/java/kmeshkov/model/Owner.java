package java.kmeshkov.model;

import java.io.Serializable;

public class Owner implements Serializable {
    private String display_name;
    private String link;

    public String getName() {
        return display_name;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.display_name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

