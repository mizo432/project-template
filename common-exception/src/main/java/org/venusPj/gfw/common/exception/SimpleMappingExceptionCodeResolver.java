package org.venusPj.gfw.common.exception;

import com.undecided.primitive.map.Maps2;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMappingExceptionCodeResolver implements
    ExceptionCodeResolver {

    private static final Logger logger = LoggerFactory.getLogger(
        SimpleMappingExceptionCodeResolver.class);

    private LinkedHashMap<String, String> exceptionMappings;

    private String defaultExceptionCode;

    public void setExceptionMappings(
        LinkedHashMap<String, String> exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }

    public void setDefaultExceptionCode(String defaultExceptionCode) {
        this.defaultExceptionCode = defaultExceptionCode;
    }

    @Override
    public String resolveExceptionCode(Exception ex) {

        if (ex == null) {
            logger.warn(
                "target exception is null. return defaultExceptionCode.");
            return defaultExceptionCode;
        }

        if (ex instanceof ExceptionCodeProvider) {
            String code = ((ExceptionCodeProvider) ex).getCode();
            if (code != null) {
                return code;
            }
        }

        if (Maps2.isEmpty(exceptionMappings)) {
            return defaultExceptionCode;
        }

        for (Entry<String, String> entry : exceptionMappings.entrySet()) {
            String targetException = entry.getKey();
            Class<?> exceptionClass = ex.getClass();
            while (exceptionClass != Object.class) {
                if (exceptionClass.getName().contains(targetException)) {
                    return entry.getValue();
                }
                exceptionClass = exceptionClass.getSuperclass();
            }
        }

        return defaultExceptionCode;
    }

}
