package org.venusPj.common.gfw.common.exception;

import org.venusPj.common.gfw.common.message.ResultMessages;

public class ResultMessagesNotificationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final ResultMessages resultMessages;

    protected ResultMessagesNotificationException(ResultMessages messages) {
        this(messages, null);
    }

    public ResultMessagesNotificationException(ResultMessages messages,
        Throwable cause) {
        super(cause);
        if (messages == null) {
            throw new IllegalArgumentException("messages must not be null");
        }
        this.resultMessages = messages;
    }

    @Override
    public String getMessage() {
        return resultMessages.toString();
    }

    public ResultMessages getResultMessages() {
        return resultMessages;
    }
}
