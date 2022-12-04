package org.venusPj.common.gfw.common.exception;

import org.venusPj.common.gfw.common.message.ResultMessage;
import org.venusPj.common.gfw.common.message.ResultMessages;

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
