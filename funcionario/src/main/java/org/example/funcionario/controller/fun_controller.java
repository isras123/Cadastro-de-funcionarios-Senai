package org.example.funcionario.controller;

import jakarta.validation.Valid;
import org.example.funcionario.model.Funcionario;
import org.example.funcionario.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class fun_controller {
    private final FuncionarioService service;

    public fun_controller(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listar();
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody @Valid Funcionario funcionario) {
        return service.salvar(funcionario);
    }
    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id) { return service.buscar(id); }


    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){
        funcionario.setId(id);
        return service.salvar(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id){ service.deletar(id); }

    @GetMapping("/buscar")
    public List<Funcionario> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }
}
