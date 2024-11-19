package com.example.tptekup.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Provider extends User{
    public Provider(long id, String name, String salary, int phone, int age, String mail, String password, String matricule, String service, String company) {
        super(id, name, salary, phone, age, mail, password);
        this.matricule = matricule;
        this.service = service;
        this.company = company;
    }

    private String matricule;
    private String service;
    private String company;
    @OneToMany(mappedBy="provider",cascade= CascadeType.REMOVE)
    private List<Product> product;
}
