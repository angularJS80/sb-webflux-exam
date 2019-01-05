package cho.me.springbootwebfluxtry;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**")
        .addResourceLocations("classpath:/my/")
                .setCacheControl(CacheControl.maxAge(100, TimeUnit.SECONDS));
    }
}
