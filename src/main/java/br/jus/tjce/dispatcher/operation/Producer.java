package br.jus.tjce.dispatcher.operation;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.jus.tjce.dispatcher.configuration.ProducerConfiguration;

public class Producer {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		
		for(int i=0; i < 10; i++)
			amqpTemplate.convertAndSend("Hello World_" + i);
		
		System.out.println("Sent: Hello World and New Hello World");
	}

}
