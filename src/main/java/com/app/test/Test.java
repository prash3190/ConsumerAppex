package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.Appconfig;
import com.app.listener.MyMessageListener;

public class Test {

	public static void main(String[] args) {
    ApplicationContext ac= new AnnotationConfigApplicationContext(Appconfig.class);
    
    MyMessageListener msg= ac.getBean(MyMessageListener.class);
    System.out.println("Done");
	}

}
