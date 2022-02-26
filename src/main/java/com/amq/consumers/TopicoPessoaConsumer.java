package com.amq.consumers;

import com.amq.models.Pessoa;
import com.amq.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class TopicoPessoaConsumer {

    private static Logger log = LoggerFactory.getLogger(TopicoPessoaConsumer.class);

    @Autowired
    private PessoaRepository repository;

    @JmsListener(destination = "topico.pessoa")
    public void consumir(@Payload Pessoa pessoa) throws JMSException, InterruptedException {
        log.info("Consumindo [" + pessoa.getNome() + "] no tópico [topico.pessoa]");
        repository.save(pessoa);
    }
}
