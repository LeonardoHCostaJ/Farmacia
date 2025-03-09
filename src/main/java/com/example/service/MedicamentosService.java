package com.example.service;

import com.example.domains.Medicamentos;
import com.example.domains.dtos.MedicamentosDTO;
import com.example.repositories.MedicamentosRepository;
import com.example.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicamentosService {

    @Autowired
    private MedicamentosRepository medicamentosRepo;

    public List<MedicamentosDTO> findAll(){
        return medicamentosRepo.findAll().stream().map(obj -> new MedicamentosDTO(obj)).collect(Collectors.toList());
    }

    public Medicamentos findById(Long id){
        Optional<Medicamentos> obj = medicamentosRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medicamento não Encontrado! Id:" + id));
    }

    public Medicamentos findByNomeComercial(String nomeComercial){
        Optional<Medicamentos> obj = medicamentosRepo.findByNomeComercial(nomeComercial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medicamento não Encontrado! Nome Comercial:" + nomeComercial));
    }

    public Medicamentos findByPrinAtivo(String prinAtivo){
        Optional<Medicamentos> obj = medicamentosRepo.findByPrinAtivo(prinAtivo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medicamento não Encontrado! Princípio Ativo:" + prinAtivo));
    }

    public Medicamentos create(MedicamentosDTO dto){
        dto.setId(null);
        Medicamentos obj = new Medicamentos(dto);
        return medicamentosRepo.save(obj);
    }

    public Medicamentos update(Long id, MedicamentosDTO objDto){
        objDto.setId(id);
        Medicamentos oldObj = findById(id);
        oldObj = new Medicamentos(objDto);
        return medicamentosRepo.save(oldObj);
    }

    public void delete(Long id){
        Medicamentos obj = findById(id);
        medicamentosRepo.deleteById(id);
    }
}
