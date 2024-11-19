package com.example.tptekup.Services;

import com.example.tptekup.Entities.Customer;
import com.example.tptekup.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer CreateCust(Customer customer){return customerRepository.save(customer);}
    public Customer GetbyId(long id){return customerRepository.findById(id).get();}
    public List<Customer> getAll(){return customerRepository.findAll();}
    public void DeleteCust(long id){ customerRepository.deleteById(id);}
    public Customer updateCust(Customer customer){ return  customerRepository.saveAndFlush(customer);}
}
