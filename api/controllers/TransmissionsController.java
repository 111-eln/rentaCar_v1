package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {
    private TransmissionService transmissionService;//IoC
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transmission add(@RequestBody Transmission transmission){

        return  transmissionService.add(transmission);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody int id){

        transmissionService.delete(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Transmission> getAll(){

        return transmissionService.getAll();
    }

    @GetMapping("/transmissions/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transmission getById(int id){

        return transmissionService.getById(id);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transmission update(int id,@RequestBody Transmission transmission){

        Transmission _transmission=transmissionService.getById(id);
        _transmission.setName(transmission.getName());
        _transmission.setUpdatedDate(transmission.getUpdatedDate());
        _transmission.setCreatedDate(transmission.getCreatedDate());
        _transmission.setDeletedDate(transmission.getDeletedDate());
        Transmission updatedTransmission=transmissionService.update(_transmission);
        return updatedTransmission;
    }

}
