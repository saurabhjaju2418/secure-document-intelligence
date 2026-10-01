create table documents (
 id uuid primary key, owner_subject varchar(180) not null, title varchar(240) not null,
 source_name varchar(240) not null, content_sha256 char(64) not null, chunk_count integer not null,
 created_at timestamptz not null
);
create index idx_document_owner_created on documents(owner_subject,created_at desc);
create table document_chunks (
 id uuid primary key, document_id uuid not null references documents(id) on delete cascade,
 chunk_index integer not null, nonce bytea not null check(octet_length(nonce)=12),
 ciphertext bytea not null, constraint uq_doc_chunk unique(document_id,chunk_index)
);

