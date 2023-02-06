package com.undecided.gfw.common.exception;

import com.undecided.gfw.common.message.ResultMessage;
import com.undecided.gfw.common.message.ResultMessages;

/**
 * 業務例外の基底クラス.
 * <pre>
 *     業務例外の場合はこの例外を継承する
 * </pre>
 */
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
