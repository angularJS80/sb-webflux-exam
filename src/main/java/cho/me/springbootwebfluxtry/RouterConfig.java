package cho.me.springbootwebfluxtry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
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
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
        return serverHttpSecurity
                .authorizeExchange()
                .matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .pathMatchers("/my/hello.html").permitAll()
                .anyExchange().authenticated()
                .and()
                .formLogin().and()
                .build();
    }
    @Bean
    RouterFunction<ServerResponse> routerFunction(){
        return      route(GET("/webflux/allFluxTypeBook").and(accept(APPLICATION_JSON)),bookHandler::allFluxTypeBooks)
                .andRoute(GET("/webflux/allMonoTypeBook").and(accept(APPLICATION_JSON)),bookHandler::allMonoTypeBooks)
                ;

    }
}
