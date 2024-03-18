package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    Model add(Model model);
    void delete(int id);
    List<Model> getAll();
    Model getById(int id);
    Model update(Model model);
}
