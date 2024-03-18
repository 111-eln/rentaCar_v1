package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")//domaine ek gelicek ksıım doamine localhost diyoruz şimdilik kendi pcmizden çalışacağı için
//turkcell.com.tr/xproject/api/v1/brands
public class BrandsController {
    private BrandService brandService;//IoC
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand add(@RequestBody Brand brand){

        return  brandService.add(brand);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody int id){

        brandService.delete(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Brand> getAll(){

       return brandService.getAll();
    }
    @GetMapping("/brands/{id}")
    @ResponseStatus
    public Brand getById(int id){

        return brandService.getById(id);
    }
    @PutMapping
    @ResponseStatus
    public Brand update(int id,@RequestBody Brand brand){

        Brand _brand=brandService.getById(id);
        _brand.setName(brand.getName());
        _brand.setUpdatedDate(brand.getUpdatedDate());
        _brand.setCreatedDate(brand.getCreatedDate());
        _brand.setDeletedDate(brand.getDeletedDate());
        Brand updatedBrand=brandService.update(_brand);
        return updatedBrand;
    }

}

