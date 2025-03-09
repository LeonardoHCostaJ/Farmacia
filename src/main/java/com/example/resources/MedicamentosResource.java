package com.example.resources;

import com.example.domains.Medicamentos;
import com.example.domains.dtos.MedicamentosDTO;
import com.example.service.MedicamentosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentosResource {

    @Autowired
    private MedicamentosService medicamentosService;

    @GetMapping
    public ResponseEntity<List<MedicamentosDTO>> findAll(){
        return ResponseEntity.ok().body(medicamentosService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicamentosDTO> findById(@PathVariable Long id){
        Medicamentos obj = this.medicamentosService.findById(id);
        return ResponseEntity.ok().body(new MedicamentosDTO(obj));
    }

    @GetMapping(value = "/nomecomercial/{nomeComercial}")
    public ResponseEntity<MedicamentosDTO> findById(@PathVariable String nomeComercial){
        Medicamentos obj = this.medicamentosService.findByNomeComercial(nomeComercial);
        return ResponseEntity.ok().body(new MedicamentosDTO(obj));
    }

    @GetMapping(value = "/prinativo/{prinAtivo}")
    public ResponseEntity<MedicamentosDTO> findNomeComercial(@PathVariable String prinAtivo){

        Medicamentos obj = this.medicamentosService.findByPrinAtivo(prinAtivo);

        return ResponseEntity.ok().body(new MedicamentosDTO(obj));
    }

    @PostMapping
    public ResponseEntity<MedicamentosDTO> create(@Valid @RequestBody MedicamentosDTO dto){
        Medicamentos medicamentos = medicamentosService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(medicamentos.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicamentosDTO> update(@PathVariable Long id, @Valid @RequestBody MedicamentosDTO objDto){

        Medicamentos Obj = medicamentosService.update(id, objDto);

        return ResponseEntity.ok().body(new MedicamentosDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicamentosDTO> delete(@PathVariable Long id){
        medicamentosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
