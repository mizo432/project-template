package org.venusPj.common.gfw.common.exception;

public interface ExceptionLevelResolver {

    ExceptionLevel resolveExceptionLevel(Exception ex);
    
}
