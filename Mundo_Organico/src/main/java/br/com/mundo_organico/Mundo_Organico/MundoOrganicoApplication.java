package br.com.mundo_organico.Mundo_Organico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MundoOrganicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MundoOrganicoApplication.class, args);
	}

}
