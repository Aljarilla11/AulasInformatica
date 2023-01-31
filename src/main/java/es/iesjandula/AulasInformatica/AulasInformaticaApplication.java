package es.iesjandula.AulasInformatica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AulasInformaticaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AulasInformaticaApplication.class, args);
	}

	@Transactional(readOnly = false)
	@Override
	public void run(String... args) throws Exception {

	}
}
