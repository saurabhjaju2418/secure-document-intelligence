package dev.saurabh.docintel.domain;
import jakarta.persistence.*;import java.util.UUID;
@Entity @Table(name="document_chunks",uniqueConstraints=@UniqueConstraint(name="uq_doc_chunk",columnNames={"document_id","chunk_index"}))
public class DocumentChunk{
 @Id public UUID id; @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="document_id",nullable=false) public DocumentRecord document; @Column(name="chunk_index",nullable=false) public int chunkIndex; @Column(name="nonce",nullable=false,length=12) public byte[] nonce; @Column(name="ciphertext",nullable=false) public byte[] ciphertext;
 protected DocumentChunk(){} public DocumentChunk(DocumentRecord doc,int index,byte[] nonce,byte[] cipher){id=UUID.randomUUID();document=doc;chunkIndex=index;this.nonce=nonce;ciphertext=cipher;}
}

