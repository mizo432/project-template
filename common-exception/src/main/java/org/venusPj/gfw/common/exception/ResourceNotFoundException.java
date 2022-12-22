package org.venusPj.gfw.common.exception;

import org.venusPj.gfw.common.message.ResultMessage;
import org.venusPj.gfw.common.message.ResultMessages;

public class ResourceNotFoundException extends
    ResultMessagesNotificationException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(ResultMessages.error().add(ResultMessage.fromText(message)));
    }

    public ResourceNotFoundException(ResultMessages messages) {
        super(messages);
    }

    public ResourceNotFoundException(ResultMessages messages, Throwable cause) {
        super(messages, cause);
    }

}