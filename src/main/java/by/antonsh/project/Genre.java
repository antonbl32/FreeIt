package by.antonsh.project;

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

    public String getDescription() {
        return description;
    }
}
