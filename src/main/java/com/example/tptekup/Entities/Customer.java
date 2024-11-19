package com.example.tptekup.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer extends User{
    private String adress;

    public Customer(long id, String name, String salary, int phone, int age, String mail, String password, String adress, String city) {
        super(id, name, salary, phone, age, mail, password);
        this.adress = adress;
        this.city = city;
    }

    private String city;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    List<Ordeer>orderList;
}
