package de.htwberlin.webtech.persistance;

import javax.persistence.*;

@Entity(name = "nobuy")
public class NoBuyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "test")
    private String test;

    public NoBuyEntity(Long id, String category, String description, double value) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.value = value;
    }

    protected NoBuyEntity() {
    }

    public Long getId() {
        return id;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}