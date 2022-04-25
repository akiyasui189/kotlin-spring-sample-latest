package com.example.demo;

import com.example.demo.dtos.SimpleMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	Function<SimpleMessage, SimpleMessage> mqProcessor() {
		return sm -> {
			System.out.println("### processor: " + sm.message());
			return sm;
		};
	}

	@Bean
	Consumer<SimpleMessage> mqConsumer() {
		return sm -> {
			System.out.println("### consumer: " + sm.message());
		};
	}


}
