package com.undecided.gfw.web.logging.mdc;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class MDCClearFilter extends OncePerRequestFilter {

    @Override
    protected final void doFilterInternal(@NotNull HttpServletRequest request,
                                          @NotNull HttpServletResponse response,
                                          FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

}
