package com.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

@Configuration
@EnableJms
@ComponentScan(basePackages="com.app")
public class Appconfig {
   @Autowired
	private MessageListener messageListener;
	@Bean
	public ConnectionFactory con() {
		ActiveMQConnectionFactory c= new ActiveMQConnectionFactory();
		c.setBrokerURL("tcp://localhost:61616");
		return c;
	}
	@Bean
	public MessageListenerContainer mlc() {
		DefaultMessageListenerContainer m= new DefaultMessageListenerContainer();
		m.setConnectionFactory(con());
		m.setDestinationName("P-queue-temp");
		m.setMessageListener(messageListener);
		return m;
	}
}
