package com.example.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;
import java.util.logging.Logger;

public final class JwtTokenUtil {
    //在request的header中的名字
    public final static String TOKEN_HEADER = "Authorization";

    //一个星期过期
    public final static long REMEMBER_EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7;

    //一天过期
    public final static long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // 应用密钥
    private static final String APP_SECRET = "logisticapi";

    private static final String PREFIX = "logistics:";

    // 角色权限声明
    private static final String ROLE_CLAIMS = "roles";

    //检验token是否合法
    public static boolean checkToken(String token) {
        if ("null".equals(token) || token == null || "".equals(token)){
            System.out.println("token为空");
            return false;
        }
        return token.startsWith(PREFIX);
    }

    /**
     * 生成Token
     */
    public static String createToken(String username, String[] roles, long expiration) {
        System.out.println("---------------------------");
        System.out.println("username:"+username);
        System.out.println("-----------------------");
        Map<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, roles);
        return PREFIX + Jwts.builder()
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .setSubject(username)
                .compact();
    }

    /**
     * 获取token body
     */
    private static Claims getTokenClaims(String token) {
        token = token.substring(PREFIX.length());
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(APP_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        }
        return claims;
    }

    /** 从Token中获取username */
    public static String getUsername(String token) {
        System.out.println("----gettoken----");
        System.out.println(getTokenClaims(token));
        System.out.println("-------------");
        System.out.println(getTokenClaims(token).getSubject());
        System.out.println("-------------");
        return getTokenClaims(token).getSubject();
    }

    /**
     * 从Token中获取用户角色
     */
    public static List<String> getTokenRoles(String token) {
        List<String> roles = new ArrayList<>();
        Object object = getTokenClaims(token).get(ROLE_CLAIMS);
        if (object instanceof ArrayList<?>) {
            for (Object o : (List<?>) object) {
                roles.add((String) o);
            }
        }
        for (String role : roles) {
            System.out.println(role);
        }
        return roles;
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token) {
        return getTokenClaims(token).getExpiration().before(new Date());
    }

}

