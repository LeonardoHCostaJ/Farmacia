package com.example.domains.dtos;

import com.example.domains.Medicamentos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MedicamentosDTO {

    private Long id;

    @NotNull(message = "O campo Nome Comercial não pode ser nulo")
    @NotBlank(message = "O campo Nome Comercial não pode estar vazio")
    private String nomeComercial;

    @NotNull(message = "O campo Pricípio Ativo não pode ser nulo")
    @NotBlank(message = "O campo Princípio Ativo não pode estar vazio")
    private String prinAtivo;

    public MedicamentosDTO() {}

    public MedicamentosDTO(Medicamentos medicamentos) {
        this.id = medicamentos.getId();
        this.nomeComercial = medicamentos.getNomeComercial();
        this.prinAtivo = medicamentos.getPrinAtivo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo Nome Comercial não pode ser nulo") @NotBlank(message = "O campo Nome Comercial não pode estar vazio") String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(@NotNull(message = "O campo Nome Comercial não pode ser nulo") @NotBlank(message = "O campo Nome Comercial não pode estar vazio") String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public @NotNull(message = "O campo Pricípio Ativo não pode ser nulo") @NotBlank(message = "O campo Princípio Ativo não pode estar vazio") String getPrinAtivo() {
        return prinAtivo;
    }

    public void setPrinAtivo(@NotNull(message = "O campo Pricípio Ativo não pode ser nulo") @NotBlank(message = "O campo Princípio Ativo não pode estar vazio") String prinAtivo) {
        this.prinAtivo = prinAtivo;
    }
}
