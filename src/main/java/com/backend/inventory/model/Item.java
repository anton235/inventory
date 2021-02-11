package com.backend.inventory.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", unique = true, nullable = false)
    private Integer number;
    private String name;
    private Integer amount;
    @Column(unique = true)
    private final UUID inventoryCode;

    public Item(@JsonProperty("number") Integer number, @JsonProperty("name") String name,
            @JsonProperty("amount") Integer amount, @JsonProperty("inventoryCode") UUID inventoryCode) {
        this.number = number;
        this.name = name;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public UUID getInventoryCode() {
        return inventoryCode;
    }
}
