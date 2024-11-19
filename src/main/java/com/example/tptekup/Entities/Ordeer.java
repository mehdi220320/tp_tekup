package com.example.tptekup.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ordeer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String ref;
    private double price;
    private LocalDate date;
    @ManyToMany
    @JoinTable(
            name = "ordeer_product",
            joinColumns = @JoinColumn(name = "ordeer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList ;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


}
