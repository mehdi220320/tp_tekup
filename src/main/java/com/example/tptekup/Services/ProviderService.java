package com.example.tptekup.Services;

import com.example.tptekup.Entities.Provider;
import com.example.tptekup.Repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;
    public Provider CreateProv(Provider provider){return providerRepository.save(provider);}
    public Provider GetbyId(long id){return providerRepository.findById(id).get();}
    public List<Provider> getAll(){return providerRepository.findAll();}
    public void DeleteProv(long id){ providerRepository.deleteById(id);}
    public Provider updateProv(Provider provider){ return  providerRepository.saveAndFlush(provider);}
}
