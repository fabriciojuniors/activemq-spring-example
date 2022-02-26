package com.amq.controllers;

import com.amq.consumers.TopicoPessoaSender;
import com.amq.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private TopicoPessoaSender topicoOrigemSender;

    @PostMapping
    public void salvar(@RequestBody Pessoa pessoa) {
        topicoOrigemSender.send(pessoa);
    }
}
