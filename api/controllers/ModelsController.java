package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {
    private ModelService modelService;//IoC
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Model add(@RequestBody Model model){

        return  modelService.add(model);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody int id){

        modelService.delete(id);
    }
    @GetMapping("/models")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Model> getAllModels(){

        return modelService.getAll();
    }
    @GetMapping("/models/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Model getByIdModels(@PathVariable int id){

        return modelService.getById(id);
    }
    @PutMapping
    public Model update(int id,@RequestBody Model model){
        Model _model=modelService.getById(id);
        _model.setName(model.getName());
        _model.setUpdatedDate(model.getUpdatedDate());
        _model.setCreatedDate(model.getCreatedDate());
        _model.setDeletedDate(model.getDeletedDate());
        Model updatedModel=modelService.update(_model);
        return updatedModel;


    }

}
