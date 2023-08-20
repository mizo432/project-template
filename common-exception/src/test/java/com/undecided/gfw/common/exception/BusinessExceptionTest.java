package com.undecided.gfw.common.exception;

import com.undecided.gfw.common.message.ResultMessage;
import com.undecided.gfw.common.message.ResultMessages;
import com.undecided.test.size.SmallTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BusinessExceptionTest {

    /**
     * Method under test: {@link BusinessException#BusinessException(ResultMessages)}
     */
    @SmallTest
    void testConstructor() {
        assertEquals("ResultMessages [type=danger, list=[]]",
                (new BusinessException(ResultMessages.danger())).getMessage());
    }

    /**
     * Method under test: {@link BusinessException#BusinessException(ResultMessages)}
     */
    @SmallTest
    void testConstructor2() {
        assertThatThrownBy(() -> {
                    throw new BusinessException((ResultMessages) null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }


    /**
     * Method under test: {@link BusinessException#BusinessException(ResultMessages, Throwable)}
     */
    @SmallTest
    void testConstructor3() {
        ResultMessages messages = ResultMessages.danger();
        assertEquals("ResultMessages [type=danger, list=[]]",
                (new BusinessException(messages, new Throwable())).getLocalizedMessage());
    }

    /**
     * Method under test: {@link BusinessException#BusinessException(ResultMessages, Throwable)}
     */
    @SmallTest
    void testConstructor4() {
        assertThatThrownBy(() -> {
                    throw new BusinessException(null, new Throwable());
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }


    /**
     * Method under test: {@link BusinessException#BusinessException(String)}
     */
    @SmallTest
    void testConstructor5() {
        BusinessException actualBusinessException = new BusinessException("An error occurred");
        assertEquals(
                "ResultMessages [type=error, list=[ResultMessage [code=null, args=[], text=An error occurred]]]",
                actualBusinessException.getMessage());
        ResultMessages resultMessages = actualBusinessException.getResultMessages();
        assertTrue(resultMessages.isNotEmpty());
        ResultMessage getResult = resultMessages.getList().get(0);
        assertEquals(0, getResult.getArgs().length);
        assertEquals("An error occurred", getResult.getText());
        assertNull(getResult.getCode());
    }
}

