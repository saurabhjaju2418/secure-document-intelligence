package dev.saurabh.docintel.repo;
import dev.saurabh.docintel.domain.DocumentRecord;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface DocumentRepository extends JpaRepository<DocumentRecord,UUID>{List<DocumentRecord> findTop100ByOwnerSubjectOrderByCreatedAtDesc(String owner);Optional<DocumentRecord> findByIdAndOwnerSubject(UUID id,String owner);}

