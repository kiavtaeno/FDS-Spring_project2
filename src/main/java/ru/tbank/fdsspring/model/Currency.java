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
