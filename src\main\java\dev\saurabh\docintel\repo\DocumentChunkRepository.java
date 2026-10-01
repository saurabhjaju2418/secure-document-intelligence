package dev.saurabh.docintel.repo;
import dev.saurabh.docintel.domain.DocumentChunk;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface DocumentChunkRepository extends JpaRepository<DocumentChunk,UUID>{List<DocumentChunk> findByDocumentIdOrderByChunkIndex(UUID documentId);}

