package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {

    private FuelService fuelService;//IoC
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fuel add(@RequestBody Fuel fuel){

        return  fuelService.add(fuel);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody int id){

        fuelService.delete(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Fuel> getAll(){

        return fuelService.getAll();
    }
    @GetMapping("/fuels/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Fuel getById(int id){

        return fuelService.getById(id);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Fuel update(int id,@RequestBody Fuel fuel){

        Fuel _fuel=fuelService.getById(id);
        _fuel.setName(fuel.getName());
        _fuel.setUpdatedDate(fuel.getUpdatedDate());
        _fuel.setCreatedDate(fuel.getCreatedDate());
        _fuel.setDeletedDate(fuel.getDeletedDate());
        Fuel updatedFuel=fuelService.update(_fuel);
        return updatedFuel;
    }

}
