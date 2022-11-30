package com.example.kayitform.Service;

import com.example.kayitform.Model.Uye;
import com.example.kayitform.Repository.UyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UyeService {
    @Autowired
    private UyeRepository repository;

    public List<Uye> listAll() {
        return repository.findAll();
    }

    public void save(Uye uye) {
        repository.save(uye);
    }

    public Uye get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);

    }
}
