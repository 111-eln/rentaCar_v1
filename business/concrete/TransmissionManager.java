package com.turkcell.rentacar.business.concrete;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    @Override
    public Transmission add(Transmission transmission) {
        return transmissionRepository.save(transmission);

    }
    @Override
    public void delete(int id) {
        transmissionRepository.deleteById(id);
    }

    @Override
    public List<Transmission> getAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        return transmissionRepository.getById(id);
    }

    @Override
    public Transmission update(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }
}
