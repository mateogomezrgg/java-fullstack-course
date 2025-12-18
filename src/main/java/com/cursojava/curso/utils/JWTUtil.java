package com.cursojava.curso.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final Logger log = LoggerFactory.getLogger(JWTUtil.class);

    private SecretKey getSigningKey() {
        // Decodifica la clave Base64 usando los decodificadores internos de la librería
        // Si tu clave en application.properties NO es Base64, usa: key.getBytes(StandardCharsets.UTF_8)
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String create(String id, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // Obtenemos la clave firmada
        SecretKey signingKey = getSigningKey();

        // Construimos el JWT
        // NOTA: En la v0.12+ los métodos perdieron el prefijo "set".
        // Ahora es .id() en vez de .setId()
        JwtBuilder builder = Jwts.builder()
                .id(id)
                .issuedAt(now)
                .subject(subject)
                .issuer(issuer)
                .signWith(signingKey, Jwts.SIG.HS256); // Firma con la clave y el algoritmo

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.expiration(exp); // antes .setExpiration()
        }

        return builder.compact();
    }

    public String getValue(String jwt) {
        // Usamos el nuevo verifyWith y build()
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getSubject();
    }

    public String getKey(String jwt) {
        // Usamos el nuevo verifyWith y build()
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getId();
    }
}