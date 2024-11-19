package com.example.tptekup.Services;

import com.example.tptekup.Entities.Ordeer;
import com.example.tptekup.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public Ordeer CreateORD(Ordeer order){return orderRepository.save(order);}
    public Ordeer GetbyId(long id){return orderRepository.findById(id).get();}
    public List<Ordeer> getAll(){return orderRepository.findAll();}
    public void DeleteOrd(long id){ orderRepository.deleteById(id);}
    public Ordeer updateOrd(Ordeer order){ return  orderRepository.saveAndFlush(order);}
}
