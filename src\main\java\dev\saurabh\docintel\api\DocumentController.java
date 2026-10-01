package dev.saurabh.docintel.api;
import dev.saurabh.docintel.service.DocumentService;import jakarta.validation.Valid;import jakarta.validation.constraints.NotBlank;import org.springframework.security.core.Authentication;import org.springframework.validation.annotation.Validated;import org.springframework.web.bind.annotation.*;import java.util.List;import java.util.UUID;
@Validated @RestController @RequestMapping("/api/documents") public class DocumentController{
 private final DocumentService service;public DocumentController(DocumentService s){service=s;}
 @PostMapping public DocumentView ingest(Authentication auth,@Valid @RequestBody IngestDocumentRequest req){return service.ingest(auth.getName(),req);}
 @GetMapping public List<DocumentView> list(Authentication auth){return service.list(auth.getName());}
 @GetMapping("/search") public List<SearchHit> search(Authentication auth,@RequestParam @NotBlank String q){return service.search(auth.getName(),q);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(Authentication auth,@PathVariable UUID id){service.delete(auth.getName(),id);}
}

