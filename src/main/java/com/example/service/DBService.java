package com.example.service;

import com.example.domains.Medicamentos;
import com.example.repositories.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private MedicamentosRepository medicamentosRepo;

    public void initDB(){

        Medicamentos medicamento01 = new Medicamentos( null, "AraDois", "Losartana");

        medicamentosRepo.save(medicamento01);
    }
}
