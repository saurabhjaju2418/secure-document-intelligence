package dev.saurabh.docintel.api;
import dev.saurabh.docintel.domain.DocumentRecord;import java.time.Instant;import java.util.UUID;
public record DocumentView(UUID id,String title,String sourceName,int chunkCount,Instant createdAt){public static DocumentView of(DocumentRecord d){return new DocumentView(d.id,d.title,d.sourceName,d.chunkCount,d.createdAt);}}

