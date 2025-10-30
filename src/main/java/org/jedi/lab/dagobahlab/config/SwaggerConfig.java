package org.jedi.lab.dagobahlab.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DagobahLab Board API")
                        .description("게시판 CRUD API 문서")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("DagobahLab")
                                .url("https://github.com/yourusername/dagobahlab")));
    }
}
