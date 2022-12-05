package org.venusPj.gfw.common.exception;

import org.venusPj.gfw.common.message.ResultMessage;
import org.venusPj.gfw.common.message.ResultMessages;

public class BusinessException extends ResultMessagesNotificationException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(ResultMessages.error().add(ResultMessage.fromText(message)));
    }

    public BusinessException(ResultMessages messages) {
        super(messages);
    }

    public BusinessException(ResultMessages messages, Throwable cause) {
        super(messages, cause);
    }

}
