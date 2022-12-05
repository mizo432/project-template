package org.venusPj.gfw.common.exception;

public interface ExceptionLevelResolver {

    ExceptionLevel resolveExceptionLevel(Exception ex);

}
