package no.hvl.dat250.Votesphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EntityScan("no.hvl.dat250.Votesphere.Entities")
@EnableJpaRepositories("no.hvl.dat250.Votesphere.Repository")
@ComponentScan(basePackages = {"no.hvl.dat250.Votesphere.*"})
public class VotesphereApplication {

	//private static final Logger log = LoggerFactory.getLogger(VotesphereApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VotesphereApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
