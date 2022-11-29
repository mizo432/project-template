package org.venusPj.projectTemplate.shared.primitive.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lists2 {

    public static <T> List<T> newArrayList(Collection<T> values) {
        ArrayList<T> result = new ArrayList<>();
        result.addAll(values);
        return result;
    }
}
