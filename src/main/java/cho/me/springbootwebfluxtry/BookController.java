package cho.me.springbootwebfluxtry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
    @GetMapping("/mvc/flux")
    public Flux<String> getFlux(){
        return Flux.just("a","b","c");
    }

    @GetMapping("/mvc/mono")
    public Mono<String> getMono(){
        return Mono.just("a");
    }
}