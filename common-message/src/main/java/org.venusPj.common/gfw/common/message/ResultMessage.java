package org.venusPj.common.gfw.common.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.venusPj.primitive.array.Arrays2;
import org.venusPj.primitive.object.Objects2;

public class ResultMessage implements Serializable {

    private static final Object[] EMPTY_ARRAY = Objects2.EMPTY_ARRAY;

    private final String code;

    private final Object[] args;

    private final String text;

    public ResultMessage(String code, Object[] args, String text) {
        this.code = code;
        this.args = args == null ? EMPTY_ARRAY : args;
        this.text = text;
    }

    public static ResultMessage fromCode(String code, Object... args) {
        checkNotNull(code, "code must not be null");
        return new ResultMessage(code, args, null);
    }

    public static ResultMessage fromText(String text) {
        checkNotNull(text, "text must not be null");
        return new ResultMessage(null, EMPTY_ARRAY, text);

    }

    private static void checkNotNull(Object reference, String message) {

    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays2.hash(args);
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ResultMessage other = (ResultMessage) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        if (!Arrays2.equal(args, other.args)) {
            return false;
        }
        if (text == null) {
            if (other.text != null) {
                return false;
            }
        } else if (!text.equals(other.text)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResultMessage [code=" + code + ", args=" + Arrays2.toString(args)
            + ", text=" + text + "]";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(
        ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}
