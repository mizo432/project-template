package com.undecided.gfw.common.exception;

public interface ExceptionLevelResolver {

    ExceptionLevel resolveExceptionLevel(Exception ex);

}
