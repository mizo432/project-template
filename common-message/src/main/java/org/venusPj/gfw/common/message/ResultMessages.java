package org.venusPj.gfw.common.message;

import static org.venusPj.primitive.list.Lists2.newArrayList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.venusPj.primitive.string.Strings2;

public class ResultMessages implements Serializable, Iterable<ResultMessage> {

    /**
     * message type
     */
    private final ResultMessageType type;

    /**
     * message list
     */
    private final List<ResultMessage> list = newArrayList();

    /**
     * default attribute name for ResultMessages
     */
    public static final String DEFAULT_MESSAGES_ATTRIBUTE_NAME = Strings2
        .uncapitalize(ResultMessages.class.getSimpleName());

    /**
     * Constructor.
     *
     * @param type message type
     */
    public ResultMessages(ResultMessageType type) {
        this(type, (ResultMessage[]) null);
    }

    /**
     * Constructor.
     *
     * @param type     message type
     * @param messages messages to add
     */
    public ResultMessages(ResultMessageType type, ResultMessage... messages) {
        if (type == null) {
            throw new IllegalArgumentException("type must not be null!");
        }
        this.type = type;
        if (messages != null) {
            addAll(messages);
        }
    }

    /**
     * returns type
     *
     * @return type
     */
    public ResultMessageType getType() {
        return type;
    }

    /**
     * returns messages
     *
     * @return messages
     */
    public List<ResultMessage> getList() {
        return list;
    }

    /**
     * add a ResultMessage
     *
     * @param message ResultMessage instance
     * @return this result messages
     */
    public ResultMessages add(ResultMessage message) {
        if (message != null) {
            this.list.add(message);
        } else {
            throw new IllegalArgumentException("message must not be null");
        }
        return this;
    }

    /**
     * add code to create and add ResultMessages
     *
     * @param code message code
     * @return this result messages
     */
    public ResultMessages add(String code) {
        if (code != null) {
            this.add(ResultMessage.fromCode(code));
        } else {
            throw new IllegalArgumentException("code must not be null");
        }
        return this;
    }

    /**
     * add code and args to create and add ResultMessages
     *
     * @param code message code
     * @param args replacement values of message format
     * @return this result messages
     */
    public ResultMessages add(String code, Object... args) {
        if (code != null) {
            this.add(ResultMessage.fromCode(code, args));
        } else {
            throw new IllegalArgumentException("code must not be null");
        }
        return this;
    }

    /**
     * add all messages (excludes <code>null</code> message)<br>
     * <p>
     * if <code>messages</code> is <code>null</code>, no message is added.
     * </p>
     *
     * @param messages messages to add
     * @return this messages
     */
    public ResultMessages addAll(ResultMessage... messages) {
        if (messages != null) {
            for (ResultMessage message : messages) {
                add(message);
            }
        } else {
            throw new IllegalArgumentException("messages must not be null");
        }
        return this;
    }

    /**
     * add all messages (excludes <code>null</code> message)<br>
     * <p>
     * if <code>messages</code> is <code>null</code>, no message is added.
     * </p>
     *
     * @param messages messages to add
     * @return this messages
     */
    public ResultMessages addAll(Collection<ResultMessage> messages) {
        if (messages != null) {
            for (ResultMessage message : messages) {
                add(message);
            }
        } else {
            throw new IllegalArgumentException("messages must not be null");
        }
        return this;
    }

    /**
     * returns whether messages are not empty.
     *
     * @return whether messages are not empty
     */
    public boolean isNotEmpty() {
        return !list.isEmpty();
    }

    /**
     * factory method for success messages.
     *
     * @return success messages
     */
    public static ResultMessages success() {
        return new ResultMessages(StandardResultMessageType.SUCCESS);
    }

    /**
     * factory method for info messages.
     *
     * @return info messages
     */
    public static ResultMessages info() {
        return new ResultMessages(StandardResultMessageType.INFO);
    }

    /**
     * factory method for warning messages.
     *
     * @return warning messages
     * @since 5.0.0
     */
    public static ResultMessages warning() {
        return new ResultMessages(StandardResultMessageType.WARNING);
    }

    /**
     * factory method for error messages.
     *
     * @return error messages
     */
    public static ResultMessages error() {
        return new ResultMessages(StandardResultMessageType.ERROR);
    }

    /**
     * factory method for danger messages.
     *
     * @return danger messages
     */
    public static ResultMessages danger() {
        return new ResultMessages(StandardResultMessageType.DANGER);
    }

    /**
     * factory method for primary messages.
     *
     * @return primary messages
     * @since 5.7.0
     */
    public static ResultMessages primary() {
        return new ResultMessages(StandardResultMessageType.PRIMARY);
    }

    /**
     * factory method for secondary messages.
     *
     * @return secondary messages
     * @since 5.7.0
     */
    public static ResultMessages secondary() {
        return new ResultMessages(StandardResultMessageType.SECONDARY);
    }

    /**
     * factory method for light messages.
     *
     * @return light messages
     * @since 5.7.0
     */
    public static ResultMessages light() {
        return new ResultMessages(StandardResultMessageType.LIGHT);
    }

    /**
     * factory method for dark messages.
     *
     * @return dark messages
     * @since 5.7.0
     */
    public static ResultMessages dark() {
        return new ResultMessages(StandardResultMessageType.DARK);
    }

    /**
     * Returns {@link Iterator} instance that iterates over a list of {@link ResultMessage}
     *
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<ResultMessage> iterator() {
        return list.iterator();
    }

    /**
     * Outputs type of messages in this {@code ResultMessages} and the list of messages itself
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ResultMessages [type=" + type + ", list=" + list + "]";
    }

    /**
     * special handling for the serialization and deserialization process
     *
     * @param out ObjectOutputStream
     * @throws IOException {@link java.io.ObjectOutputStream#defaultWriteObject()}
     * @see java.io.Serializable
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    /**
     * special handling for the serialization and deserialization process
     *
     * @param in ObjectInputStream
     * @throws IOException            {@link java.io.ObjectInputStream#defaultReadObject()}
     * @throws ClassNotFoundException {@link java.io.ObjectInputStream#defaultReadObject()}
     * @see java.io.Serializable
     */
    private void readObject(
        ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}
