package com.example.tptekup.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;
    @ManyToMany(mappedBy = "productList")
    List<Ordeer> orderList;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    Subcategory subcategory;
}
