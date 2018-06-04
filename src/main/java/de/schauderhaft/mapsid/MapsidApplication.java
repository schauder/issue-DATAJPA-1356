package de.schauderhaft.mapsid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MapsidApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapsidApplication.class, args);
	}
}
