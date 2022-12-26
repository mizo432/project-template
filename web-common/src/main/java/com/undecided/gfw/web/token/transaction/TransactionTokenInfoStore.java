package com.undecided.gfw.web.token.transaction;

import static org.venusPj.primitive.object.Objects2.isNull;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.venusPj.primitive.string.Strings2;

public class TransactionTokenInfoStore {

    private final ConcurrentMap<Method, TransactionTokenInfo> tokenInfoCache = new ConcurrentHashMap<>();

    private final static String globalTokenName = "globalToken";

    public TransactionTokenInfoStore() {
        // do nothing.
    }

    public TransactionTokenInfo getTransactionTokenInfo(
        final HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();
        TransactionTokenInfo info = tokenInfoCache.get(method);
        if (info == null) {
            synchronized (tokenInfoCache) {
                info = tokenInfoCache.get(method);
                if (info == null) {
                    info = createTransactionTokenInfo(handlerMethod);
                    tokenInfoCache.put(method, info);
                }
            }
        }
        return info;
    }

    TransactionTokenInfo createTransactionTokenInfo(
        final HandlerMethod handlerMethod) {

        TransactionTokenCheck methodAnnotation = handlerMethod
            .getMethodAnnotation(TransactionTokenCheck.class);

        TransactionTokenCheck classAnnotation = AnnotationUtils.getAnnotation(
            handlerMethod.getBeanType(), TransactionTokenCheck.class);

        if (isNull(methodAnnotation)) {
            return new TransactionTokenInfo(null, TransactionTokenType.NONE);
        }

        String tokenName = createTokenName(classAnnotation, methodAnnotation);

        return new TransactionTokenInfo(tokenName, methodAnnotation.type());
    }

    String createTokenName(final TransactionTokenCheck classAnnotation,
        final TransactionTokenCheck methodAnnotation) {
        String methodTokenName = methodAnnotation.value();
        String classTokenName = (classAnnotation == null) ? ""
            : classAnnotation.value();

        StringBuilder tokenNameStringBuilder = new StringBuilder();
        if (Strings2.hasText(classTokenName)) {
            tokenNameStringBuilder.append(classTokenName);
        }
        if (Strings2.hasText(methodTokenName)) {
            if (tokenNameStringBuilder.length() != 0) {
                tokenNameStringBuilder.append("/");
            }
            tokenNameStringBuilder.append(methodTokenName);
        }
        if (tokenNameStringBuilder.length() == 0) {
            tokenNameStringBuilder.append(globalTokenName);
        }

        return tokenNameStringBuilder.toString();
    }
}
