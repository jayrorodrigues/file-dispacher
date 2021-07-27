package br.jus.tjce.dispatcher.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.jus.tjce.dispatcher.operation.FileHandler;

@Configuration
public class ConsumerConfiguration extends RabbitConfiguration{
	
	/*
	 * @Bean public SimpleMessageListenerContainer listenerContainer() {
	 * SimpleMessageListenerContainer container = new
	 * SimpleMessageListenerContainer();
	 * container.setConnectionFactory(connectionFactory());
	 * container.setQueueNames(this.myQueue().toString());
	 * container.setMessageListener(new MessageListenerAdapter(new FileHandler()));
	 * return container; }
	 */
	
	
	@Bean
	  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	      MessageListenerAdapter listenerAdapter) {
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(queueName);
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }
	

}
