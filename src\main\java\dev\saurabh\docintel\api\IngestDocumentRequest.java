package dev.saurabh.docintel.api;
import jakarta.validation.constraints.NotBlank;import jakarta.validation.constraints.Size;
public record IngestDocumentRequest(@NotBlank @Size(max=240) String title,@NotBlank @Size(max=240) String sourceName,@NotBlank @Size(max=200000) String text){}

