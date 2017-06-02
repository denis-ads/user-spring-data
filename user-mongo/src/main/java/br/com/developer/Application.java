package br.com.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.developer.infrastructure.converter.LocalDateConverter;

@SpringBootApplication(scanBasePackages = { "br.com.developer" })
@ComponentScan
@EnableMongoRepositories(basePackages = { "br.com.developer" })
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LocalDateConverter localDateConverter() {
        return new LocalDateConverter("dd/MM/yyyy");
    }
}
