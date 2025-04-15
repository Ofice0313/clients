package com.devcaleb.clients.dto;

import com.devcaleb.clients.entities.Client;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @Size(min = 5, max = 15, message = "Name must be between 5 and 15 characters long")
    @NotBlank(message = "Required field")
    private String name;
    private String cpf;
    @Positive(message = "Income must be positive")
    private Double income;
    @PastOrPresent
    private LocalDate birthDate;
    @PositiveOrZero(message = "The number of children must be positive or zero")
    private Integer children;

    public ClientDTO(){}

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client client){
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
