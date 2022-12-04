package org.venusPj.common.gfw.common.exception;

public class SystemException extends RuntimeException implements
    ExceptionCodeProvider {

    private static final long serialVersionUID = 1L;

    private final String code;

    public SystemException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

}
