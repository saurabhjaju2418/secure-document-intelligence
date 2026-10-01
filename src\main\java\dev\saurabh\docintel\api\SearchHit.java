package dev.saurabh.docintel.api;
import java.util.UUID;
public record SearchHit(UUID documentId,String title,int chunkIndex,int score,String citation,String excerpt){}

