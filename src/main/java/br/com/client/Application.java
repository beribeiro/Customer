package br.com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.client")
@EntityScan( basePackages = {"br.com.client.model"} )
public class Application {

    public static void main (final String [] args){
        SpringApplication.run(Application.class, args);
    }

}
