package by.antonsh.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Genre")
public enum Genre {
    ACTION("Action and adventure"),
    BUSINESS("Bussiness type"),
    AUTOBIOGRAPHY("Autobiograhy type"),
    ECONOMICS("Economics type"),
    HISTORY("History type");
    private String description;

    Genre(String description) {
        this.description = description;
    }

    Genre() {
    }

    public String getDescription() {
        return description;
    }
}
