<div align="center">

<img src="assets/project-banner.svg" alt="Animated Margin — Secure Document Intelligence banner" width="900" />

# Margin — Secure Document Intelligence

**Answers tied to the page. Access tied to the person.**

Java · Spring Boot · PostgreSQL · Object storage

![Project status](https://img.shields.io/badge/status-in%20progress-7a8b71)

</div>

## Product scope

Ingest documents, index content, retrieve relevant passages, and return answers with page-level citations.

## Architecture notes

Private object storage; tenant-filtered retrieval; source-linked responses; deletion propagation; audit events; authorization before retrieval.

### Data model sketch

    documents(id, tenant_id, object_key, checksum, status) · chunks(id, document_id, page, text, embedding) · grants(tenant_id, principal_id, document_id, permission)

## Stack

Java · Spring Boot · PostgreSQL · Object storage

## Build sequence

1. Secure upload and document lifecycle
2. Extraction and cited retrieval
3. Tenant-aware authorization
4. Deletion, audit, and threat model

## Current status

Public repository with an animated README. Product code is being built incrementally, one project at a time. This page records the planned product boundary and engineering milestones.

## License

MIT.
