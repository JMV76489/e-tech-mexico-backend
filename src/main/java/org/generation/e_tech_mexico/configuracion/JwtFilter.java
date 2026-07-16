package org.generation.e_tech_mexico.configuracion;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JwtFilter extends GenericFilterBean {
    public static final String signature = "DentroDeUn_UniversoConLasPosibilidades--C0moElNuestro-?>QuiEN!!IM4G1nAr_íaQu3EEsP0c0pr0BaBle-+-P0D3RV_-iSIT4RR)UNPL4net4";
    public static final String secret = Base64.getEncoder().encodeToString(signature.getBytes(StandardCharsets.UTF_8));

    public static SecretKey getSignInKey() {
        byte[] keyBytes = signature.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //Verificar si se require un filtro según el method y endpoint recibidos
        if (requiereAutenticacion(httpServletRequest)) {
            //Recuperar el token
            String token = obtenerToken(httpServletRequest);

            validarToken(token);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private boolean requiereAutenticacion(HttpServletRequest httpServletRequest) {
        String method = httpServletRequest.getMethod(); //Recuperar el método del request
        String URI = httpServletRequest.getRequestURI(); //Recupera el endpoint al que se le hizo la solicitud

        return method.equals(("POST")) && !URI.contains("/api/usuarios/") ||
                method.equals("GET") && !URI.contains("/api/productos/") ||
                method.equals("PUT") || method.equals("DELETE");
    }


    private String obtenerToken(HttpServletRequest httpServletRequest) throws ServletException {

        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("1. Token inválido");
        }

        return authHeader.substring(7);
    }

    private void validarToken(String token) throws  ServletException{
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            System.out.println(claims.getSubject());
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException exception) {
            throw new ServletException("2. Token invalido");

        }
    }
}
