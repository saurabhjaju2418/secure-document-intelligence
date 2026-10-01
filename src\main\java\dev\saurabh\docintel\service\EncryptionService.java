package dev.saurabh.docintel.service;
import jakarta.annotation.PostConstruct;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Component;import javax.crypto.Cipher;import javax.crypto.spec.GCMParameterSpec;import javax.crypto.spec.SecretKeySpec;import java.security.SecureRandom;import java.util.Base64;
@Component public class EncryptionService{
 @Value("\${DOCUMENT_ENCRYPTION_KEY:}") private String configuredKey;private SecretKeySpec key;private final SecureRandom random=new SecureRandom();
 @PostConstruct void initialize(){if(configuredKey.isBlank())throw new IllegalStateException("DOCUMENT_ENCRYPTION_KEY must be configured as base64-encoded 32-byte key");byte[] raw=Base64.getDecoder().decode(configuredKey);if(raw.length!=32)throw new IllegalStateException("DOCUMENT_ENCRYPTION_KEY must decode to 32 bytes");key=new SecretKeySpec(raw,"AES");}
 public Sealed seal(byte[] plain){try{byte[] nonce=new byte[12];random.nextBytes(nonce);Cipher c=Cipher.getInstance("AES/GCM/NoPadding");c.init(Cipher.ENCRYPT_MODE,key,new GCMParameterSpec(128,nonce));return new Sealed(nonce,c.doFinal(plain));}catch(Exception e){throw new IllegalStateException("Document encryption failed",e);}}
 public byte[] open(byte[] nonce,byte[] cipher){try{Cipher c=Cipher.getInstance("AES/GCM/NoPadding");c.init(Cipher.DECRYPT_MODE,key,new GCMParameterSpec(128,nonce));return c.doFinal(cipher);}catch(Exception e){throw new IllegalStateException("Document authentication/decryption failed",e);}}
 public record Sealed(byte[] nonce,byte[] ciphertext){}
}

