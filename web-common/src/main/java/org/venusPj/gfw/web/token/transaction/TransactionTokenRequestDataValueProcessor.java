package org.venusPj.gfw.web.token.transaction;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.venusPj.gfw.web.mvc.support.RequestDataValueProcessorAdaptor;

public class TransactionTokenRequestDataValueProcessor extends
    RequestDataValueProcessorAdaptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        TransactionTokenRequestDataValueProcessor.class);

    public TransactionTokenRequestDataValueProcessor() {
        LOGGER.debug("TransactionTokenRequestDataValueProcessor()");

    }

    @Override
    public Map<String, String> getExtraHiddenFields(
        @NotNull HttpServletRequest request) {

        TransactionToken nextToken = (TransactionToken) request.getAttribute(
            TransactionTokenInterceptor.NEXT_TOKEN_REQUEST_ATTRIBUTE_NAME);
        LOGGER.debug("nextToken:" + nextToken);

        if (nextToken != null) {
            Map<String, String> map = new HashMap<>(2);
            map.put(TransactionTokenInterceptor.TOKEN_REQUEST_PARAMETER,
                nextToken.getTokenString());
            return map;
        }
        return null;
    }

}
