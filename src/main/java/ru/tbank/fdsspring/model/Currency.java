package ru.tbank.fdsspring.model;

import jakarta.persistence.*;

@Entity
@Table(name="currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private double priceChangeRange;
    private String description;

    @Column(name = "pricechangerange")
    private double priceChangeName;

    public double getPriceChangeName() {
        return priceChangeName;
    }

    public void setPriceChangeName(double priceChangeName) {
        this.priceChangeName = priceChangeName;
    }

    public double getPriceChangeRange() {
        return priceChangeRange;
    }

    public void setPriceChangeRange(double priceChangeRange) {
        this.priceChangeRange = priceChangeRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
