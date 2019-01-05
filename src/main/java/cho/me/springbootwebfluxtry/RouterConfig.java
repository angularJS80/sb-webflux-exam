package cho.me.springbootwebfluxtry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
    @Autowired
    BookHandler bookHandler;

    @Bean
    RouterFunction<ServerResponse> routerFunction(){
        return      route(GET("/webflux/allFluxTypeBook").and(accept(APPLICATION_JSON)),bookHandler::allFluxTypeBooks)
                .andRoute(GET("/webflux/allMonoTypeBook").and(accept(APPLICATION_JSON)),bookHandler::allMonoTypeBooks)
                ;

    }
}
