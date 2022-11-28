package org.venusPj.projectTemplate.modules.example.usecase.employee;

import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessages;

public class EntityNotFoundException extends
    BusinessException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(ResultMessages resultMessages) {
        super(resultMessages);
    }
}
