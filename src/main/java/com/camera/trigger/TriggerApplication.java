package com.camera.trigger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication										// Anotação que vai startar toda a aplicação
@EntityScan(basePackages = {"com.camera.trigger.model"})	// Informa o spring onde nossas classes 'model' estão localizadas
@ComponentScan(basePackages = {"com.*"})					// Automatização de injeção de dependências
@EnableJpaRepositories(basePackages = {"com.camera.trigger.repository"})	// Onde ficara o nosso crud?
@EnableTransactionManagement 		// Gerência de transações. Havia muitos problemas antigamente sem isso
@EnableWebMvc						// Habilitando os recursos de MVC (embora aqui iremos trabalhar somente com REST)
@RestController						// Avisa ao spring que vamos trabalhar com REST, fazendo com que os contollers retornem um JSON
@EnableAutoConfiguration			// O spring já faz as manipulações de classes e dependências automaticamente
public class TriggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriggerApplication.class, args);
	}

}
