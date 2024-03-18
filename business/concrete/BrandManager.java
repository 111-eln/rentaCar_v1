package com.turkcell.rentacar.business.concrete;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
//        return  createdBrand;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.getById(id);
    }

    @Override
    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }
}
