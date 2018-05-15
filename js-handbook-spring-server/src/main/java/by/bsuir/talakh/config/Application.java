package by.bsuir.talakh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@ComponentScan (basePackages = {"by.bsuir.talakh"})
@EntityScan(basePackages = {"by.bsuir.talakh.entity"})
@EnableAutoConfiguration
@EnableJpaRepositories("by.bsuir.talakh.dao")
public class Application extends SpringBootServletInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
@RestController
class GreetingsController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Hi, bitch.", HttpStatus.OK);

    }
}
