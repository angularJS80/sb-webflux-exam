package cho.me.springbootwebfluxtry;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class BookMapper {
    public static class BookSerializer extends JsonSerializer<Book>{

        @Override
        public void serialize(Book book, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("isbn",book.getIsbn());
            gen.writeEndObject();
        }
    }

}
