package cho.me.springbootwebfluxtry;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class BookHandler {

    public Mono<ServerResponse> allMonoTypeBooks(ServerRequest serverRequest){
        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("3333");
        Mono<Book> monoBook = Mono.just(book);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(monoBook,Book.class);
    }

    public Mono<ServerResponse> allFluxTypeBooks(ServerRequest serverRequest){
        Book book = new Book();
        book.setIsbn("flux1");
        book.setTitle("flux1");

        Book book2 = new Book();
        book2.setIsbn("flux2");
        book2.setTitle("flux2");
        Flux<Book> fluxBook = Flux.just(book,book2);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fluxBook,Book.class);
    }
}
