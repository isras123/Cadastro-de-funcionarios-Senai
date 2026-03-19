package org.example.funcionario.service;

import org.example.funcionario.model.Funcionario;
import org.example.funcionario.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service

public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {this.repository = repository;}

    public Funcionario salvar(Funcionario funcionario) {return repository.save(funcionario);}

    public Funcionario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public List<Funcionario> listar(){return repository.findAll();}

    public void deletar(Long id){repository.deleteById(id);}

    public List<Funcionario> buscarPorNome(String nome){return repository.findByNomeContainingIgnoreCase(nome);}


}
