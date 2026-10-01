<div align="center">

<img src="assets/project-banner.svg" alt="Animated secure document intelligence banner" width="900" />

# Secure Document Intelligence

**Private, cited answers begin with controlled document access.**

Java 21 · Spring Boot · OIDC JWT · AES-GCM · PostgreSQL

</div>

A document ingestion and keyword retrieval API. Each document is scoped to the authenticated OIDC subject, split into chunks, encrypted with AES-256-GCM before persistence, and returned as ranked excerpts with source and chunk citations.

## Implemented

- OIDC JWT resource-server authentication for API routes.
- POST /api/documents ingests bounded text content and stores encrypted chunks.
- GET /api/documents lists only documents owned by the authenticated subject.
- GET /api/documents/search?q=... decrypts only that subject's chunks, ranks by query-term matches, and returns source/chunk citations.
- DELETE /api/documents/{id} deletes only a document owned by the caller.
- Flyway schema, health endpoint, Docker Compose.

## Run

Configure an OIDC issuer and an AES key encoded as base64 containing exactly 32 random bytes. Keep secrets outside source control.

```bash
$bytes = New-Object byte[] 32
[Security.Cryptography.RandomNumberGenerator]::Fill($bytes)
[Convert]::ToBase64String($bytes)
$env:DOCUMENT_ENCRYPTION_KEY = '<generated-value>'
$env:JWT_ISSUER_URI = 'https://your-identity-provider.example/issuer'
docker compose up --build
```

Send a valid `Authorization: Bearer <access-token>` with API requests. Ingested text is limited to 200,000 characters per request.

## Security notes and boundaries

Content chunks are encrypted with AES/GCM/NoPadding using a fresh 96-bit nonce per chunk and a 128-bit authentication tag. The encryption key is external configuration and must be managed and rotated through a secrets manager. Lost keys make content unrecoverable. The prototype does not include malware scanning, file format parsing, key rotation/versioning, rate limits, audit retention, embeddings, an LLM, or production hardening. Keyword retrieval is deterministic; it does not generate answers. Validate identity-provider claims and operational controls before real sensitive data is used.

## License

MIT. See LICENSE.

