package sptech.projetojpa06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // isto habilita o uso do Feign no projeto
@SpringBootApplication
public class ProjetoJpa06Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpa06Application.class, args);
	}

}
