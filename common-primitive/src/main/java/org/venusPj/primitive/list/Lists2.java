package org.venusPj.primitive.list;

import static java.lang.String.format;
import static org.venusPj.primitive.object.Objects2.isNull;
import static org.venusPj.primitive.object.Objects2.nonNull;

import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.venusPj.primitive.intMath.IntMath;
import org.venusPj.primitive.iterator.Iterators;
import org.venusPj.primitive.object.Objects2;
import org.venusPj.primitive.string.Strings2;

public class Lists2 {

    public static List<String> removeNothing(List<String> aList) {
        List<String> result = newArrayList();
        for (String item : aList) {
            if (!"nothing".equals(item)) {
                result.add(item);
            }

        }

        return result;
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... args) {
        ArrayList<T> result = new ArrayList<>();
        Collections.addAll(result, args);
        return result;
    }

    /**
     * 与えられたクロージャーを入力リストの断定条件に合致した要素で実行する.
     * <p>
     * もし、入力リスト,断定条件,クロージャーのいずれかnullの場合には、なにも行われない
     *
     * @param collection 入力リスト（null可）
     * @param predicate  断定条件（null可）
     * @param consumer   the 要素を操作するクロージャー(null可)
     */
    public static <E> void forFilteredDo(List<E> collection,
        Predicate<E> predicate, Consumer<E> consumer) {
        if (isNull(collection) || isNull(consumer) || isNull(predicate)) {
            return;
        }
        for (final E element : collection) {
            if (predicate.test(element)) {
                consumer.accept(element);
            }
        }
    }

    /**
     * 入力リストから断定条件に合致する要素の有無を返却する。.
     * <p>
     * 入力リストnullの場合falseを返却する。 A <code>null</code> predicate はどの要素にもマッチしません.
     *
     * @param list      入力リスト
     * @param predicate 断定条件
     * @return 断定条件に合致した場合true/合致しない場合false
     */
    public static <E> boolean exists(List<E> list,
        Predicate<E> predicate) {
        checkNotNull(list, "list");
        checkNotNull(predicate, "predicate");
        for (E e : list) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 与えられたクロージャーを入力リスト全ての要素で実行する.
     * <p>
     * もし、入力リストあるいはクロージャーがnullの場合には、なにも行われない
     *
     * @param aCollection 入力リスト（nullを指定すると何もしない）
     * @param aClosure    the 要素を操作するクロージャー(nullを指定すると何もしない)
     */
    public static <E> void forAllDo(Collection<E> aCollection, Consumer<E> aClosure) {
        if (nonNull(aCollection) && nonNull(aClosure)) {
            aCollection.forEach(e -> aClosure.accept(e));
        }
    }

    /**
     * 入力リストから断定条件に合致しない要素を抜き取る.
     * <pre>
     * 入力リストがnullの場合なにも行わない。 断定条件がnullの場合なにも行わない。
     * </pre>
     *
     * @param inputList 入力リスト（null可）
     * @param predicate 断定条件（null可）
     */
    public static <E> List<E> include(List<E> inputList,
        Predicate<E> predicate) {
        checkNotNull(inputList, "inputList");
        checkNotNull(predicate, "predicate");
        List<E> resultList = newArrayList(inputList);
        resultList.removeIf(e -> !predicate.test(e));
        return resultList;
    }

    /**
     * 入力リストから断定条件に合致しない要素を抜き取る.
     * <pre>
     * 入力リストがnullの場合なにも行わない。 断定条件がnullの場合なにも行わない。
     * </pre>
     *
     * @param inputList 入力リスト（null可）
     * @param predicate 断定条件（null可）
     */
    public static <E> List<E> exclude(List<E> inputList,
        Predicate<E> predicate) {
        checkNotNull(inputList, "inputList");
        checkNotNull(predicate, "predicate");

        List<E> resultList = newArrayList(inputList);
        resultList.removeIf(predicate);
        return resultList;
    }

    /**
     * 入力リストから断定条件に合致する先頭要素を返却する.
     *
     * <pre>
     *    合致した要素が存在しない場合、nullを返却する。
     * </pre>
     * <pre>
     *    入力リストがnullの場合nullを返却する。
     *    断定条件がnullの場合nullを返却する。
     * </pre>
     *
     * @param inputList 入力リスト（null可）
     * @param predicate 断定条件（null可）
     * @return 断定条件に合致した最初の要素
     */
    public static <E> E find(List<E> inputList,
        Predicate<E> predicate) {
        checkNotNull(inputList, "inputList");
        checkNotNull(predicate, "predicate");
        for (E item : inputList) {
            if (predicate.test(item)) {
                return item;
            }
        }
        return null;
    }

    /**
     * @param collections collections
     * @param <E>         コレクションの要素
     * @return コレクションを保持した ArrayList
     * @deprecated use {@link #join(Collection[])}
     */
    @SafeVarargs
    @Deprecated(forRemoval = true)
    public static <E> ArrayList<E> newArrayList(Collection<? extends E>... collections) {
        return join(collections);
    }

    public static <E> ArrayList<E> newArrayListWithCapacity(int initialArraySize) {
        return new ArrayList<E>(initialArraySize);
    }


    /**
     * 複数のコレクションを結合した結果をリスト形式で返却します。
     *
     * @param collections コレクションを可変引数形式で指定します
     * @param <E>         コレクションの要素の型
     * @return 結合結果
     */
    @SafeVarargs
    public static <E> ArrayList<E> join(Collection<? extends E>... collections) {
        checkNotNull(collections, "collections");
        ArrayList<E> result = newArrayListWithCapacity(totalSize(collections));
        for (Collection<? extends E> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * 複数のコレクションを結合した結果をリスト形式で返却します。
     *
     * @param collections コレクションを可変引数形式で指定します
     * @param <E>         コレクションの要素の型
     * @return 結合結果
     */
    @SafeVarargs
    private static <E> int totalSize(Collection<? extends E>... collections) {
        checkNotNull(collections, "collections");
        int result = 0;
        for (Collection<?> collection : collections) {
            result += collection.size();
        }
        return result;
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        checkNotNull(iterable, "elements");
        return newArrayList(iterable.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Collection<? extends E> elements, E element) {
        checkNotNull(elements, "elements");
        checkNotNull(element, "element");
        ArrayList<E> result = newArrayList(elements);
        result.add(element);
        return result;
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> iterator) {
        checkNotNull(iterator, "iterator");
        ArrayList<E> list = newArrayList();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * 入力リストから断定条件に合致する要素をリストで返却する.
     *
     * @param inputList 入力リスト（null不可）
     * @param predicate 断定条件
     * @throws NullPointerException 入力のリストあるいは出力リストがnullの場合に発生する。
     */
    public static <E> List<E> select(Iterable<E> inputList, Predicate<E> predicate) {
        checkNotNull(inputList, "inputList");
        checkNotNull(predicate, "predicate");

        List<E> outputList = new ArrayList<>();
        for (E item : inputList) {
            if (predicate.test(item)) {
                outputList.add(item);
            }
        }
        return outputList;

    }

    public static <T> List<T> unmodifiableList(List<T> list) {
        return Collections.unmodifiableList(list);
    }

    /**
     * 元リストから指定のページ番号の要素をリストとして返却します
     * <pre>
     * 元リストにnullを設定した場合、空のリストを返却します
     * 該当のページを越えたindexにリストの要素が存在しない場合、空のリストを返却します
     * </pre>
     *
     * @param aSourceList 元リスト
     * @param page        ページ番号(1始まり)
     * @param pageSize    ページサイズ
     * @param <T>         リストの要素の型
     * @return 元リストから指定のページ番号の要素をリスト
     * @throws IllegalArgumentException ページサイズで0以下を指定した場合にスローします。ページで0以下を指定した場合にスローします
     */
    public static <T> @NotNull List<T> getPage(List<T> aSourceList, int page,
        int pageSize) {
        if (pageSize <= 0 || page <= 0) {
            throw new IllegalArgumentException(
                String.format("invalid page:%s page size:%s", pageSize, page));
        }

        int fromIndex = (page - 1) * pageSize;
        if (isNull(aSourceList) || aSourceList.size() < fromIndex) {
            return newArrayList();
        }

        // toIndex exclusive
        return aSourceList.subList(fromIndex, Math.min(fromIndex + pageSize, aSourceList.size()));
    }


    public static <E> List<E> empty() {
        return Collections.emptyList();
    }

    public static <E> void addAll(List<E> anyList, Iterable<E> iterable) {
        for (E entity : iterable) {
            anyList.add(entity);
        }
    }

    static int indexOfImpl(List<?> list, Object element) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, element);
        } else {
            ListIterator<?> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (Objects2.equal(element, listIterator.next())) {
                    return listIterator.previousIndex();
                }
            }
            return -1;
        }
    }

    private static int indexOfRandomAccess(List<?> list, Object element) {
        int size = list.size();
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(list.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int lastIndexOfImpl(List<?> list, Object element) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, element);
        } else {
            ListIterator<?> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (Objects2.equal(element, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
    }

    private static int lastIndexOfRandomAccess(List<?> list, Object element) {
        if (element == null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (element.equals(list.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 対象リストが空かを判定します
     *
     * @param anyList 対象リスト
     * @return 空の場合trueを返却します
     */
    public static boolean isNotEmpty(List<?> anyList) {
        return !anyList.isEmpty();
    }

    /**
     * コレクションを特定の型のリストに変換する
     * <pre>
     *     サンプル
     *     {@code
     *      List<MyBean> sourceList = Lists2.newArrayList(MyBean.of("A"),MyBean.of("B"));
     *      List<String> result = Lists2.transform(sourceList, MyBean::getName);
     *     }
     * </pre>
     *
     * @param collection 基コレクション
     * @param function   変換処理
     * @param <T>        返還前の型
     * @param <E>        返還後の型
     * @return 返還後リスト
     */
    public static <T, E> List<T> transform(Collection<E> collection, Function<E, T> function) {
        return collection.stream().map(function).collect(Collectors.toList());
    }

    /**
     * {@link LinkedList}の新しいインスタンスを作成して返します。
     *
     * @param <E> {@link LinkedList}の要素型
     * @return {@link LinkedList}の新しいインスタンス
     * @see LinkedList#LinkedList()
     */
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    /**
     * {@link LinkedList}の新しいインスタンスを作成して返します。
     *
     * @param <E> {@link LinkedList}の要素型
     * @param c   要素がリストに配置されるコレクション
     * @return {@link LinkedList}の新しいインスタンス
     * @see LinkedList#LinkedList(Collection)
     */
    public static <E> LinkedList<E> newLinkedList(final Collection<? extends E> c) {
        return new LinkedList<>(c);

    }

    public static <T> List<T> defaultIfNull(List<T> list,
        List<T> defaultList) {
        if (isNull(list)) {
            return defaultList;
        }

        if (isNotEmpty(list)) {
            return list;
        }

        return defaultList;

    }

    public static <T> List<T> defaultIfEmpty(List<T> list,
        List<T> defaultList) {
        if (isNull(list)) {
            return defaultIfNull(list, defaultList);
        }

        if (isEmpty(list)) {
            return defaultList;
        }
        return list;

    }

    /**
     * リストが空かを判定する.
     *
     * @param aList リスト
     * @return この呼び出しの結果、リストが空の場合はtrue,リストに要素が存在する場合は false
     */
    public static <T> boolean isEmpty(List<T> aList) {
        return aList.isEmpty();

    }

    /**
     * 最初のリストと二つ目のリストの両方に存在する要素を格納した新しいリストを返却します.
     * <p>
     * EはhashCodeの実装とequalsの実装をしておくこと。
     *
     * @param list1 最初のリスト
     * @param list2 二つ目のリスト
     * @param <E>   要素
     * @return a new list containing all elements that are contained in both given lists.
     * @throws NullPointerException それぞれのリストがnullの場合に本例外を返却します
     */
    public static <E> List<E> intersection(final List<? extends E> list1,
        final List<? extends E> list2) {
        final List<E> result = new ArrayList<>();

        List<? extends E> smaller = list1;
        List<? extends E> larger = list2;
        if (list1.size() > list2.size()) {
            smaller = list2;
            larger = list1;
        }

        final HashSet<E> hashSet = new HashSet<>(smaller);

        for (final E e : larger) {
            if (hashSet.contains(e)) {
                result.add(e);
                hashSet.remove(e);
            }
        }
        return result;
    }

    /**
     * 最初のリストと二つ目のリストをList.addAll(Collection)を使用し新しいリストを返却します。 重複が存在する場合は重複した件数分リストに入っています。
     *
     * @param list1 最初のリスト
     * @param list2 二つ目のリスト
     * @param <E>   要素
     * @return 二つのリストを合わせた新しいリストを返却します
     * @throws NullPointerException それぞれのリストがnullの場合に本例外を返却します.
     */
    public static <E> List<E> union(List<? extends E> list1,
        List<? extends E> list2) {
        checkNotNull(list1, "list1");
        checkNotNull(list2, "list2");
        List<E> result = newArrayList();
        result.addAll(list1);
        result.addAll(list2);
        return result;

    }

    /**
     * 最初のリストの要素から二つ目のリストの要素を抜いたリストを新たに作成し返却します.
     * <p>
     * List.removeAll(Collection)の違いは最初のリストに同じ要素が２つ存在する場合、二つ目のリストに同じ要素が２つ存在しない 場合に残ってしまうのに対応しています。
     *
     * @param list1 最初のリスト
     * @param list2 二つ目のリスト
     * @param <E>   要素
     * @return 結果を新しいリストとして返却します。
     * @throws NullPointerException それぞれのリストがnullの場合に本例外を返却します.
     */
    public static <E> List<E> subtract(List<E> list1,
        List<? extends E> list2) {
        final List<E> result = new ArrayList<>();
        final HashSet<E> set = new HashSet<>(list2);
        for (final E e : list1) {
            if (!set.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * 二つのリストの各要素が一致しているか確認しすべての要素が一致しているかを返却します。
     * <p>
     * 最初のリストか二つ目のリストが<code>null</code>の場合はfalseを返却します
     *
     * @param list1 最初のリスト
     * @param list2 二つ目のリスト
     * @return すべて一致している場合trueを返却します
     * @see List
     */
    public static boolean isEqualList(Collection<?> list1,
        Collection<?> list2) {
        if (list1 == list2) {
            return true;
        }
        if (isNull(list1) || isNull(list2)) {
            return false;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        final Iterator<?> it1 = list1.iterator();
        final Iterator<?> it2 = list2.iterator();
        Object obj1 = null;
        Object obj2 = null;
        while (it1.hasNext() && it2.hasNext()) {
            obj1 = it1.next();
            obj2 = it2.next();

            if (!(isNull(obj1) ? isNull(obj2) : obj1.equals(obj2))) {
                return false;
            }
        }
        return !(it1.hasNext() || it2.hasNext());
    }

    /**
     * 二つのリストを合わせます。重複は省きます
     *
     * @param list1 最初のリスト
     * @param list2 二つ目のリスト
     * @param <E>   要素
     * @return a new list containing the sum of those lists
     * @throws NullPointerException それぞれのリストがnullの場合に本例外を返却します.
     */
    public static <E> List<E> sum(final List<? extends E> list1, final List<? extends E> list2) {
        return subtract(union(list1, list2), intersection(list1, list2));
    }

    /**
     * Returns an unmodifiable list containing the specified first element and backed by the
     * specified array of additional elements. Changes to the {@code rest} array will be reflected
     * in the returned list. Unlike {@link Arrays#asList}, the returned list is unmodifiable.
     *
     * <p>This is useful when a varargs method needs to use a signature such as {@code (Foo
     * firstFoo, Foo... moreFoos)}, in order to avoid overload ambiguity or to enforce a minimum
     * argument count.
     *
     * <p>The returned list is serializable and implements {@link RandomAccess}.
     *
     * @param first the first element
     * @param rest  an array of additional elements, possibly empty
     * @return an unmodifiable list containing the specified elements
     */

    public static <E> List<E> asList(E first, E[] rest) {
        List<E> resultList = newArrayList();
        resultList.add(first);
        resultList.addAll(Arrays.asList(rest));

        return resultList;

    }


    /**
     * Returns an unmodifiable list containing the specified first and second element, and backed
     * by
     * <p>
     * the specified array of additional elements. Changes to the {@code rest} array will be
     * reflected
     * <p>
     * in the returned list. Unlike {@link Arrays#asList}, the returned list is unmodifiable.
     *
     *
     *
     * <p>This is useful when a varargs method needs to use a signature such as {@code (Foo
     * firstFoo,
     * <p>
     * Foo secondFoo, Foo... moreFoos)}, in order to avoid overload ambiguity or to enforce a
     * minimum
     * <p>
     * argument count.
     *
     *
     *
     * <p>The returned list is serializable and implements {@link RandomAccess}.
     *
     * @param first  the first element
     * @param second the second element
     * @param rest   an array of additional elements, possibly empty
     * @return an unmodifiable list containing the specified elements
     */

    public static <E> List<E> asList(E first, E second, E[] rest) {
        List<E> resultList = newArrayList();
        resultList.add(first);
        resultList.add(second);
        resultList.addAll(Arrays.asList(rest));
        return resultList;

    }

    public static <T> T getFirstItemSilently(List<T> list) {
        if (isEmpty(list)) {
            return null;

        }
        return getFirst(list);
    }

    public static <T> T getLastItemSilently(List<T> list) {
        if (isEmpty(list)) {
            return null;

        }
        return getLast(list);
    }

    /**
     * 元になるリストに配列要素を追加したArrayListを返却します。
     *
     * @param list  元になるリスト
     * @param array 配列
     * @param <T>   要素の型
     * @return 元になるリストに配列要素を追加したArrayList
     */
    public static <T> ArrayList<T> newArrayList(List<T> list, T[] array) {
        checkNotNull(list, "list");
        checkNotNull(array, "array");

        ArrayList<T> result = newArrayListWithCapacity(list.size() + array.length);
        result.addAll(list);
        result.addAll(Arrays.asList(array));
        return result;

    }

    /**
     * 最初の要素を取得します。
     *
     * @param list 元になるリスト
     * @param <T>  要素の型
     * @return 最初の要素
     */
    public static <T> @Nullable T getFirst(@NotNull List<T> list) {
        checkNotNull(list, "list");
        if (list.isEmpty()) {
            throw new IllegalArgumentException("リストが空ではいけません");
        }

        return list.get(0);

    }

    /**
     * 最後の要素を取得します。
     *
     * @param list 元になるリスト
     * @param <T>  要素の型
     * @return 最後の要素
     */
    public static <T> @Nullable T getLast(@NotNull List<T> list) {
        checkNotNull(list, "list");
        if (list.isEmpty()) {
            throw new IllegalArgumentException("リストが空ではいけません");
        }

        return list.get(list.size() - 1);

    }

    public static int hash(List<?> list) {
        int hashCode = 1;
        for (Object o : list) {
            hashCode = 31 * hashCode + (o == null ? 0 : o.hashCode());

        }
        return hashCode;
    }

    /**
     * An implementation of {@link List#equals(Object)}.
     */
    public static boolean equal(List<?> thisList, Object other) {
        checkNotNull(thisList, "thisList");
        if (other == thisList) {
            return true;
        }
        if (!(other instanceof List)) {
            return false;
        }
        List<?> otherList = (List<?>) other;
        int size = thisList.size();
        if (size != otherList.size()) {
            return false;
        }
        if (thisList instanceof RandomAccess && otherList instanceof RandomAccess) {
            // avoid allocation and use the faster loop
            for (int i = 0; i < size; i++) {
                if (!Objects2.equal(thisList.get(i), otherList.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return Iterators.equalNumberOfElements(thisList.iterator(), otherList.iterator());
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        checkNotNull(list, "list");
        checkArgument(size > 0);
        return (list instanceof RandomAccess)
            ? new RandomAccessPartition<>(list, size)
            : new Partition<>(list, size);
    }

    private static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException("引数に合致しません");
        }

    }

    private static class Partition<T> extends AbstractList<List<T>> {

        final List<T> list;
        final int size;

        Partition(List<T> list, int size) {
            this.list = list;
            this.size = size;
        }

        @Override
        public List<T> get(int index) {
            checkElementIndex(index, size(), "index");
            int start = index * size;
            int end = Math.min(start + size, list.size());
            return list.subList(start, end);
        }

        private int checkElementIndex(int index, int size, String desc) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(badElementIndex(index, size, desc));
            }
            return index;
        }

        private String badElementIndex(int index, int size, String desc) {
            if (index < 0) {
                return format("%s (%s) must not be negative", desc, index);
            } else if (size < 0) {
                throw new IllegalArgumentException("negative size: " + size);
            } else { // index >= size
                return format("%s (%s) must be less than size (%s)", desc, index, size);
            }
        }

        @Override
        public int size() {
            return IntMath.divide(list.size(), size, RoundingMode.CEILING);
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {

        RandomAccessPartition(List<T> list, int size) {
            super(list, size);
        }
    }

    /**
     * リストに追加したい要素がnull以外の場合に追加します.
     *
     * @param list   リスト
     * @param anItem 追加したい要素
     * @param <I>    要素の型
     */
    public static <I> void addIfNonNull(List<I> list, I anItem) {
        addIf(Objects2::nonNull, list, anItem);

    }

    /**
     * リストに追加したい要素がnull以外の場合に追加したい要素を追加します.
     * <pre>
     *     追加したい要素がnullの場合にはデフォルトの要素を追加します
     * </pre>
     *
     * @param list         リスト
     * @param anItem       追加したい要素
     * @param aDefaultItem デフォルトの要素
     * @param <I>          要素の型
     */
    public static <I> void addIfNullDefault(List<I> list, I anItem, I aDefaultItem) {
        addIfNullDefault(list, anItem, (Supplier<I>) () -> aDefaultItem);

    }

    /**
     * リストに追加したい要素がnull以外の場合に追加したい要素を追加します.
     * <pre>
     *     追加したい要素がnullの場合にはデフォルト要素サプライヤーから要素を追加します
     * </pre>
     *
     * @param list             リスト
     * @param anItem           追加したい要素
     * @param aDefaultSupplier デフォルト要素のサプライヤー
     * @param <I>              要素の型
     * @throws NullPointerException デフォルト要素のサプライヤーがnullの場合にスローします。
     */
    public static <I> void addIfNullDefault(List<I> list, I anItem, Supplier<I> aDefaultSupplier) {
        addIf(Objects2::nonNull, list, anItem, aDefaultSupplier);

    }

    /**
     * リストに追加したい要素がnull以外の場合に追加したい要素を追加します.
     * <pre>
     *     判定子falseの場合にはデフォルト要素サプライヤーから要素を追加します
     * </pre>
     *
     * @param predicate       判定子
     * @param list            リスト
     * @param item            追加したい要素
     * @param defaultSupplier デフォルト要素のサプライヤー
     * @param <I>             要素の型
     * @throws NullPointerException 判定子がnullの場合にストーします.
     * @throws NullPointerException デフォルト要素のサプライヤーがnullの場合にスローします.
     */
    public static <I> void addIf(Predicate<I> predicate, List<I> list, I item,
        Supplier<I> defaultSupplier) {
        checkNotNull(predicate, "predicate");
        checkNotNull(defaultSupplier, "defaultSupplier");
        if (predicate.test(item)) {
            list.add(item);
            return;
        }
        I defaultValue = defaultSupplier.get();

        list.add(defaultValue);

    }

    /**
     * リストに追加したい要素の判定子trueの場合にが追加したい要素を追加します.
     * <pre>
     *     判定子falseの場合には追加しません。
     * </pre>
     *
     * @param predicate 判定子
     * @param list      リスト
     * @param anItem    追加したい要素
     * @param <I>       要素の型
     * @throws NullPointerException デフォルト要素のサプライヤーがnullの場合にスローします.
     */
    public static <I> void addIf(Predicate<I> predicate, List<I> list, I anItem) {
        checkNotNull(predicate, "predicate");
        if (predicate.test(anItem)) {
            list.add(anItem);
        }

    }

    /**
     * リスト1にリスト2の各要素がnull以外の場合に追加します。
     * <pre>
     *     このメソッドを呼ぶとリスト1の中身が変わるので利用者はご注意ください。
     * </pre>
     *
     * @param aList1 リスト1
     * @param aList2 リスト2
     * @param <I>    要素の型
     */
    public static <I> void addALLIfNonNull(List<I> aList1, Collection<? extends I> aList2) {
        for (I item : aList2) {
            addIf(Objects2::nonNull, aList1, item);

        }

    }

    /**
     * リストに追加したい要素がnull以外の場合に追加したい要素を追加します.
     * <pre>
     *     追加したい要素がnullの場合にはデフォルト要素サプライヤーから要素を追加します
     * </pre>
     *
     * @param list1            リスト1
     * @param list2            リスト2
     * @param aDefaultSupplier デフォルト要素のサプライヤー
     * @param <I>              要素の型
     * @throws NullPointerException デフォルト要素のサプライヤーがnullの場合にスローします。
     */
    public static <I> void addAllIfNullDefault(List<I> list1, List<I> list2,
        Supplier<I> aDefaultSupplier) {
        for (I item : list2) {
            addIfNullDefault(list1, item, aDefaultSupplier);

        }

    }

    /**
     * リストに追加したい要素がnull以外の場合に追加したい要素を追加します.
     * <pre>
     *     追加したい要素がnullの場合にはデフォルト要素を追加します
     * </pre>
     *
     * @param list1        リスト1
     * @param list2        リスト2
     * @param aDefaultItem デフォルト要素
     * @param <I>          要素の型
     * @throws NullPointerException デフォルト要素のサプライヤーがnullの場合にスローします。
     */
    public static <I> void addAllIfNullDefault(List<I> list1, List<I> list2,
        I aDefaultItem) {
        for (I item : list2) {
            addIfNullDefault(list1, item, aDefaultItem);

        }

    }

    /**
     * このリストの部分リストであるリストを返します。
     *
     * @param list       リスト
     * @param beginIndex 開始インデックス(この値を含む)
     * @param <I>        リストのItemの型
     * @return 部分リストであるリスト
     */
    public static <I> List<I> subList(List<I> list, int beginIndex) {
        if (beginIndex < 0) {
            throw new IndexOutOfBoundsException(beginIndex);
        }
        int subLen = list.size() - beginIndex;
        if (subLen < 0) {
            throw new IndexOutOfBoundsException(subLen);
        }
        if (beginIndex == 0) {
            return list;
        }

        List<I> result = newArrayList();
        for (int index = beginIndex; index < list.size(); index++) {
            result.add(list.get(index));

        }
        return result;

    }

    /**
     * このリストの部分リストであるリストを返します。
     *
     * @param aList       リスト
     * @param aBeginIndex 開始インデックス(この値を含む)
     * @param anEndIndex  終了インデックス(この値を含まない)
     * @param <I>         リストのItemの型
     * @return 部分リストであるリスト
     */
    public static <I> List<I> subList(List<I> aList, int aBeginIndex, int anEndIndex) {
        if (aBeginIndex < 0) {
            throw new IndexOutOfBoundsException(aBeginIndex);
        }
        int subLen = aList.size() - aBeginIndex;
        if (subLen < 0) {
            throw new IndexOutOfBoundsException(subLen);
        }
        int numberOfItems = aList.size();
        if (aBeginIndex == 0 && anEndIndex == numberOfItems) {
            return aList;
        }
        List<I> result = newArrayList();
        for (int index = aBeginIndex; (index < numberOfItems || index < anEndIndex); index++) {
            result.add(aList.get(index));

        }
        return result;
    }

    /**
     * 重複を抜いてサイズでリストをパーテショニングする
     *
     * @param list リスト
     * @param size パーテショニングしたいサイズ
     * @param <I>  要素の型
     * @return パーテショニング後のリスト
     */
    public static <I> List<List<I>> partitionWithoutDuplication(List<I> list, int size) {
        List<I> favBandWithoutDuplicationKeepOrder = newArrayList(new LinkedHashSet<>(list));
        return partition(favBandWithoutDuplicationKeepOrder, size);

    }

    /**
     * リストのアイテムのいずれかがnullかを調べます。
     *
     * @param aList リスト
     * @param <I>   リストの要素の型
     * @return リストのアイテムのいずれかがnullの場合trueを返します
     * @throws NullPointerException 引数のリストがnullの場合スローします
     */
    public static <I> boolean containsEmptyItem(List<I> aList) {
        checkNotNull(aList, "aList");
        for (I item : aList) {
            if (isNull(item)) {
                return true;
            }
        }
        return false;

    }

    /**
     * リストのアイテムのすべてがnullかを調べます。
     * <pre>引数リストのアイテムが0件の場合はfalseを返却します</pre>
     *
     * @param aList リスト
     * @param <I>   リストの要素の型
     * @return リストのアイテムのすべてがnullの場合trueを返します
     * @throws NullPointerException 引数のリストがnullの場合スローします
     */
    public static <I> boolean isAllNullItems(List<I> aList) {
        checkNotNull(aList, "aList");
        if (aList.isEmpty()) {
            return false;
        }
        for (I item : aList) {
            if (nonNull(item)) {
                return false;
            }
        }
        return true;

    }

    public static <E> List<E> arrayToList(E[] inputArray) {
        return Arrays.asList(inputArray);

    }

    private static <T> void checkNotNull(@NotNull T reference, @NotNull String label) {
        if (Objects2.isNull(label)) {
            throw new IllegalArgumentException("引数のlabelは必須ですが指定されていません");

        }
        if (Strings2.isEmpty(label)) {
            throw new IllegalArgumentException("引数のlabelは必須ですが指定されていません");
        }
        checkNotNull(reference, () -> new NullPointerException(label + "は必須です"));

    }

    private static <T, RE extends RuntimeException> void checkNotNull(@NotNull T reference,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (isNull(reference)) {
            throw exceptionSupplier.get();
        }
    }


}
