package com.example.repositories;

import com.example.domains.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {

    Optional<Medicamentos> findByNomeComercial(String nomeComercial);

    Optional<Medicamentos> findByPrinAtivo(String prinAtivo);
}
