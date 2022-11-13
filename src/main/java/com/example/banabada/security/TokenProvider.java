package com.example.banabada.security;

import com.example.banabada.model.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider {
    private static final String SECRET_KEY = "NMA8JPctFuna59f5";

    public String create(UserEntity userEntity) {
        // 기한은 지금부터 1일로 설정
        Date expiryDate = Date.from(
                Instant.now()
                .plus(1, ChronoUnit.DAYS));

		/*
		{ // header
		  "alg":"HS512"
		}.
		{ // payload
		  "sub":"40288093784915d201784916a40c0001",
		  "iss": "Banabada app",
		  "iat":1595733657,
		  "exp":1596597657
		}.
		// SECRET_KEY를 이용해 서명한 부분
		Nn4d1MOVLZg79sfFACTIpCPKqWmpZMZQsbNrXdJJNWkRv50_l7bPLQPwhMobT4vBOG6Q3JYjhDrKFlBSaUxZOg
		 */


        // JWT Token 생성
        return Jwts.builder()
                // header에 들어갈 내용 + 서명 위한 SECRET_KEY
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                // payload에 들어갈 내용
                .setSubject(userEntity.getUsername()) // 원래 : userEntity.getId() --> Long이라 String인 Name으로 대체
                .setIssuer("banabada app")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }


    public String validateAndGetUserName(String token) {
        // parseClaimsJws 메서드가 Base64로 디코딩 및 파싱
        // header, payload를 setSigningKey로 넘어온 시크릿을 이용해 서명한 후, token의 서명과 비교
        // 위조되지 않았다면 payload(Claims) 반환, 위조라면 예외 반환
        // 그 중 우리는 userName이 필요하므로 getBody를 부른다.
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
