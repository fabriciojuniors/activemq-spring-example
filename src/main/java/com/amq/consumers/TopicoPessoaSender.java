package com.amq.consumers;

import com.amq.models.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TopicoPessoaSender {

    private static Logger log = LoggerFactory.getLogger(TopicoPessoaSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Pessoa pessoa) {
        log.info("Enviando [" + pessoa.toString() + "] para o tópico [topico.pessoa].");
        jmsTemplate.convertAndSend("topico.pessoa", pessoa);
        return;
    }
}
