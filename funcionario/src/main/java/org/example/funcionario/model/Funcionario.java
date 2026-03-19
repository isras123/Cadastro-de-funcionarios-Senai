package org.example.funcionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o nome do funcionário!")
    private String nome;

    @NotBlank (message = "Preencha o cargo do funcionário")
    private String cargo;

    @NotBlank(message = "Preencha o Email do funcionário")
    private String email;

    @NotNull(message = "Preencha o Salário do funcionário")
    @Positive(message = "Salário inválido")
    private Double salario;

    public Funcionario(){}
}
