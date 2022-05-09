package de.htwberlin.webtech.web.api;

public class NoBuy {

    private long id;
    private String category;
    private String description;
    private double value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public NoBuy(long id, String category, String description, double value) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.value = value;
    }
}

