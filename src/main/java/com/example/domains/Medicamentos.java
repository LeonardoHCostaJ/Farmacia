package com.example.domains;

import com.example.domains.dtos.MedicamentosDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "medicamentos")
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medicamentos")
    private Long id;

    @NotNull @NotBlank
    private String nomeComercial;

    @NotNull @NotBlank
    private String prinAtivo;

    public Medicamentos() {
    }

    public Medicamentos(Long id, String nomeComercial, String prinAtivo) {
        this.id = id;
        this.nomeComercial = nomeComercial;
        this.prinAtivo = prinAtivo;
    }

    public Medicamentos(MedicamentosDTO dto){
        this.id = dto.getId();
        this.nomeComercial = dto.getNomeComercial();
        this.prinAtivo = dto.getPrinAtivo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(@NotNull @NotBlank String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public @NotNull @NotBlank String getPrinAtivo() {
        return prinAtivo;
    }

    public void setPrinAtivo(@NotNull @NotBlank String prinAtivo) {
        this.prinAtivo = prinAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicamentos that = (Medicamentos) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeComercial, that.nomeComercial) && Objects.equals(prinAtivo, that.prinAtivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeComercial, prinAtivo);
    }
}