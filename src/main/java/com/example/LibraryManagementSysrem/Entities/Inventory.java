package com.example.LibraryManagementSysrem.Entities;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Table(name="inventory",uniqueConstraints =@UniqueConstraint(name = "itemId",columnNames={"item_id"}))
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "type")
    private String type;
    @Column(name = "inventory")
    private Long inventory;

    public Inventory(Long itemId, String type) {
        this.itemId = itemId;
        this.type = type;
    }

    public Inventory(Long itemId, Long inventory) {
        this.itemId = itemId;
        this.inventory = inventory;
    }

    public Inventory(Long id, Long itemId, String type) {
        this.id = id;
        this.itemId = itemId;
        this.type = type;
    }

    public Inventory() {

    }

    public Long getId() {
        return id;
    }


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }
}
