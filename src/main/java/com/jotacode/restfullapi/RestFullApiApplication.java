package com.jotacode.restfullapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestFullApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFullApiApplication.class, args);
    }

	@Bean
	public OpenAPI customOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API Locals")
						.version("1.0")
						.description("API basico de un sistema de locales, clientes, ordenes y gerentes")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
