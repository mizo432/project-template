package org.venusPj.projectTemplate.shared.primitive.colleaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Collections3 {

    public static <T> List<T> sort(Collection<T> collection, Comparator<T> comparator) {
        var list = copy(collection);
        list.sort(comparator);
        return list;

    }

    public static <T> List<T> copy(Collection<T> collection) {
        return new ArrayList<T>(collection);

    }

}
