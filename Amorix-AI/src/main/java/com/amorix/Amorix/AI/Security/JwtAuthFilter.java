package com.amorix.Amorix.AI.Security;

import com.amorix.Amorix.AI.Errors.GlobalExceptionHandlers;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final AuthUtil authUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            try{
                log.info("incoming request: {}",request.getRequestURI());
                String requestHeaderToken =  request.getHeader("Authorization");
                log.info("Authorization Header: {}", request.getHeader("Authorization"));
                if(requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer ")){
                    filterChain.doFilter(request,response);
                    return;
                }
                String token = requestHeaderToken.substring(7).trim();
                log.info("token: {}", token);
                JwtUserPrincipal user = authUtil.verifyAccessToken(token);
                log.info("Jwt Auth Filter user: {}", user);
                if(user != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    user.authorities()
                    );
                    log.info("Authorization Header: {}", request.getHeader("Authorization"));
                    SecurityContextHolder.clearContext();
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                filterChain.doFilter(request,response);

            }catch(Exception e){
                log.error("JWT Filter Error", e);
                handlerExceptionResolver.resolveException(request,response,null,e);
                return;
            }
    }
}
