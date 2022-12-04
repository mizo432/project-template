package org.venusPj.common.gfw.common.exception;

import org.venusPj.common.gfw.common.message.ResultMessage;
import org.venusPj.common.gfw.common.message.ResultMessages;

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
