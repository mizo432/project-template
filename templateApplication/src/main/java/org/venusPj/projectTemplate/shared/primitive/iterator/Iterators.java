package org.venusPj.projectTemplate.shared.primitive.iterator;

import static org.venusPj.projectTemplate.shared.primitive.list.Lists2.newArrayList;

import java.util.Collection;
import java.util.Iterator;
import org.venusPj.projectTemplate.shared.primitive.array.ObjectArrays;
import org.venusPj.projectTemplate.shared.primitive.object.Objects2;

public class Iterators {

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection<?>) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> type) {
        return toArray(iterable, ObjectArrays.newArray(type, 0));
    }

    static <T> T[] toArray(Iterable<? extends T> iterable, T[] array) {
        Collection<? extends T> collection = castOrCopyToCollection(iterable);
        return collection.toArray(array);
    }

    static Object[] toArray(Iterable<?> iterable) {
        return castOrCopyToCollection(iterable).toArray();
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> iterable) {
        return (iterable instanceof Collection)
            ? (Collection<E>) iterable
            : newArrayList(iterable.iterator());
    }

    public static boolean equalNumberOfElements(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            if (!iterator2.hasNext()) {
                return false;
            }
            Object o1 = iterator1.next();
            Object o2 = iterator2.next();
            if (!Objects2.equal(o1, o2)) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }
}
