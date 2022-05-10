package de.htwberlin.webtech.web.api;

public class NoBuyManipulationRequest {
    private String category;
    private String description;
    private double value;

    public NoBuyManipulationRequest(String category, String description, double value) {
        this.category = category;
        this.description = description;
        this.value = value;
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
}
