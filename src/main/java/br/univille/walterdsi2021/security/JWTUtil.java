package br.univille.walterdsi2021.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
@Service
public class JWTUtil {
    private String SECRET_KEY= "3Yq4uki7Cy0C1TrClk2d";
    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }
 
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
 
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
 
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
 
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }
 
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
 
    public Boolean validateToken (String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}