package com.turkcell.rentacar.business.concrete;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    @Override
    public Model add(Model model) {
        return modelRepository.save(model);

    }
    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getById(int id) {
        return modelRepository.getById(id);
    }

    @Override
    public Model update(Model model) {
        return modelRepository.save(model);
    }
}
