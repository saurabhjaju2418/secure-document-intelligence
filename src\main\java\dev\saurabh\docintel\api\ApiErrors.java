package dev.saurabh.docintel.api;
import jakarta.persistence.EntityNotFoundException;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestControllerAdvice public class ApiErrors{@ExceptionHandler(EntityNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND) public Map<String,String> missing(EntityNotFoundException e){return Map.of("error",e.getMessage());}}

