package com.undecided.primitive.list;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Lists2Test {

    @Nested
    class addAllIf {

        @Test
        void 偶数を条件とした場合偶数のみ追加される() {
            ArrayList<Integer> sourceList = Lists2.newArrayList(1, 2, 3);
            ArrayList<Integer> destList = Lists2.newArrayList();

            Lists2.addAllIf(sourceList, destList, num -> num % 2 == 0);

            assertThat(destList.size()).isEqualTo(1);
            assertThat(destList.get(0)).isEqualTo(2);

        }

        @Test
        void 元レコードがある場合の確認() {
            ArrayList<Integer> sourceList = Lists2.newArrayList(1, 2, 3);
            ArrayList<Integer> destList = Lists2.newArrayList(10);

            Lists2.addAllIf(sourceList, destList, num -> num % 2 == 0);

            assertThat(destList.size()).isEqualTo(2);
            assertThat(destList.get(0)).isEqualTo(10);
            assertThat(destList.get(1)).isEqualTo(2);

        }

    }

    @Nested
    class isAllNullItems {

        @Test
        void _すべてのアイテムがnullの場合trueを返却する() {
            ArrayList<Integer> sourceList = Lists2.newArrayList((Integer) null, (Integer) null,
                (Integer) null);

            boolean actual = Lists2.isAllNullItems(sourceList);

            assertThat(actual).isTrue();

        }

        @Test
        void _いずれかのアイテムがnonNullの場合falseを返却する() {
            ArrayList<Integer> sourceList = Lists2.newArrayList(1, (Integer) null,
                (Integer) null);

            boolean actual = Lists2.isAllNullItems(sourceList);

            assertThat(actual).isFalse();

        }

    }
}