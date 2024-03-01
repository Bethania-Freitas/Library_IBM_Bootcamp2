package github_bethaniafreitas.Library;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CorsConfig: Adding CORS mappings...");

        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // Adapte para a origem do seu Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE");

        System.out.println("CorsConfig: CORS mappings added successfully.");
    }
}
