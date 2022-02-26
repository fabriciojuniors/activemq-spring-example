package com.amq.controllers;

import com.amq.consumers.TopicoPessoaSender;
import com.amq.models.Pessoa;
import com.amq.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private TopicoPessoaSender topicoOrigemSender;

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    public void salvar(@RequestBody Pessoa pessoa) {
        topicoOrigemSender.send(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return repository.findAll();
    }
}
