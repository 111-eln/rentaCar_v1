package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;

import java.util.List;

public interface TransmissionService {
    Transmission add(Transmission transmission);
    void delete(int id);
    List<Transmission> getAll();
    Transmission getById(int id);
    Transmission update(Transmission transmission);
}
