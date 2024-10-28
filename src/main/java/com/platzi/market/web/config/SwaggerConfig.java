package com.platzi.market.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

// La ruta para abrir la documentacion web del archivo es con "{basePath}/swagger-ui/index.html"
//Archivo de configuracion de swagger. Solo para documentacion
@Configuration
@OpenAPIDefinition(
        info = @Info(
               title = "Market CRUD",
                version = "1.0.0",
                description = "Ejercicio de CRUD para manejo de una tienda y sus productos"
        )
)
public class SwaggerConfig {
}
