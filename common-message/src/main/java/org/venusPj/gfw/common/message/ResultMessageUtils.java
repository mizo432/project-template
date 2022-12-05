package org.venusPj.gfw.common.message;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.util.Assert;

public class ResultMessageUtils {

    private static final Logger logger = LoggerFactory.getLogger(
        ResultMessageUtils.class);

    /**
     * Default Constructor.
     */
    private ResultMessageUtils() {
    }

    ;

    public static String resolveMessage(ResultMessage message,
        MessageSource messageSource,
        Locale locale) throws NoSuchMessageException {
        Assert.notNull(messageSource, "messageSource must not be null!");
        Assert.notNull(message, "message must not be null!");
        Assert.notNull(locale, "locale must not be null!");

        String msg;
        String code = message.getCode();
        if (code != null) {
            // try to resolve from code at first.
            try {
                msg = messageSource.getMessage(code, message.getArgs(), locale);
            } catch (NoSuchMessageException e) {
                String text = message.getText();
                if (text != null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("messege is not found under code '" + code
                            + "' for '" + locale + "'. use '" + text
                            + "' instead", e);
                    }
                    // if ResultMessage has a text, then use it.
                    msg = text;
                } else {
                    // otherwise throw exception
                    throw e;
                }
            }
        } else {
            msg = message.getText();
        }
        return msg;
    }

    public static String resolveMessage(ResultMessage message,
        MessageSource messageSource) {
        return resolveMessage(message, messageSource, Locale.getDefault());
    }
}
