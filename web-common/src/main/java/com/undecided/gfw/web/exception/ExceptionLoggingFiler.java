package com.undecided.gfw.web.exception;

import com.undecided.gfw.common.exception.ExceptionLogger;
import jakarta.servlet.*;

import java.io.IOException;

public class ExceptionLoggingFiler extends GenericFilter {
    public void setExceptionLogger(final ExceptionLogger exceptionLogger) {
        this.exceptionLogger = exceptionLogger;
    }

    private ExceptionLogger exceptionLogger = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (IOException e) {
            logIOException(e, request, response);
            throw e;

        } catch (ServletException e) {
            logServletException(e, request, response);
            throw e;

        } catch (RuntimeException e) {
            logRuntimeException(e, request, response);
            throw e;
        }

    }

    private void logRuntimeException(RuntimeException ex, ServletRequest request, ServletResponse response) {
        exceptionLogger.error(ex);
    }

    private void logServletException(ServletException ex, ServletRequest request, ServletResponse response) {
        exceptionLogger.error(ex);

    }

    private void logIOException(IOException ex, ServletRequest request, ServletResponse response) {
        exceptionLogger.error(ex);

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    //    @Override
    protected void initFilerBean() throws SecurityException {
        if (exceptionLogger == null) {
            exceptionLogger = new ExceptionLogger(getClass().getName());
            exceptionLogger.afterPropertiesSet();
        }
    }

}
