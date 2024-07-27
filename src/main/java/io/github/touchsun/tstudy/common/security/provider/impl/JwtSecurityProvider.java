package io.github.touchsun.tstudy.common.security.provider.impl;

import io.github.touchsun.tstudy.common.security.SecurityConstant;
import io.github.touchsun.tstudy.common.security.filter.impl.JwtFilterFactory;
import io.github.touchsun.tstudy.common.security.provider.ISecurityProvider;
import io.github.touchsun.tstudy.common.security.provider.SecurityProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt impl provider
 * 
 * @author lee 
 */
@SecurityProvider(filterFactory = JwtFilterFactory.class)
public class JwtSecurityProvider implements ISecurityProvider {

    @Override
    public String createToken(String userId) {
        return Jwts.builder()
            .setSubject(userId)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS256, SecurityConstant.PRIVATE_KEY)
            .compact();
    }

    @Override
    public boolean checkToken(String token) {
        return !getClaimsFromToken(token).getExpiration().before(new Date());
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
            .setSigningKey(SecurityConstant.PRIVATE_KEY)
            .parseClaimsJws(token)
            .getBody();
    }
}
