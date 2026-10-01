package dev.saurabh.docintel.domain;
import jakarta.persistence.*;import java.time.Instant;import java.util.UUID;
@Entity @Table(name="documents",indexes=@Index(name="idx_document_owner_created",columnList="owner_subject,created_at"))
public class DocumentRecord{
 @Id public UUID id; @Column(name="owner_subject",nullable=false,length=180) public String ownerSubject; @Column(nullable=false,length=240) public String title; @Column(name="source_name",nullable=false,length=240) public String sourceName; @Column(name="content_sha256",nullable=false,length=64) public String contentSha256; @Column(name="chunk_count",nullable=false) public int chunkCount; @Column(name="created_at",nullable=false) public Instant createdAt;
 protected DocumentRecord(){} public DocumentRecord(String owner,String title,String source,String hash,int chunks){id=UUID.randomUUID();ownerSubject=owner;this.title=title;sourceName=source;contentSha256=hash;chunkCount=chunks;createdAt=Instant.now();}
}

