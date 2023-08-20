package com.undecided.primitive.string;

import com.undecided.test.size.SmallTest;
import org.junit.jupiter.api.Nested;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Strings2Test {

    /**
     * Method under test: {@link Strings2#contains(String, char)}
     */
    @SmallTest
    void testContains() {
        // Arrange
        String str = null;
        char searchChar = 'A';

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchChar);

        // Assert
        boolean expectedContainsResult = false;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#contains(String, char)}
     */
    @SmallTest
    void testContains2() {
        // Arrange
        String str = Strings2.EMPTY;
        char searchChar = 'A';

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchChar);

        // Assert
        boolean expectedContainsResult = false;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#contains(String, char)}
     */
    @SmallTest
    void testContains3() {
        // Arrange
        String str = ".";
        char searchChar = '.';

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchChar);

        // Assert
        boolean expectedContainsResult = true;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#contains(String, String)}
     */
    @SmallTest
    void testContains4() {
        // Arrange
        String str = "Str";
        String searchStr = "Search Str";

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchStr);

        // Assert
        boolean expectedContainsResult = false;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#contains(String, String)}
     */
    @SmallTest
    void testContains5() {
        // Arrange
        String str = null;
        String searchStr = "Search Str";

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchStr);

        // Assert
        boolean expectedContainsResult = false;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#contains(String, String)}
     */
    @SmallTest
    void testContains6() {
        // Arrange
        String str = "Str";
        String searchStr = null;

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchStr);

        // Assert
        boolean expectedContainsResult = false;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#contains(String, String)}
     */
    @SmallTest
    void testContains7() {
        // Arrange
        String str = "Str";
        String searchStr = Strings2.EMPTY;

        // Act
        boolean actualContainsResult = Strings2.contains(str, searchStr);

        // Assert
        boolean expectedContainsResult = true;
        assertEquals(expectedContainsResult, actualContainsResult);
    }

    /**
     * Method under test: {@link Strings2#defaultIfEmpty(String, String)}
     */
    @SmallTest
    void testDefaultIfEmpty() {
        // Arrange
        String str = "Str";
        String defaultStr = "Default Str";

        // Act
        String actualDefaultIfEmptyResult = Strings2.defaultIfEmpty(str, defaultStr);

        // Assert
        String expectedDefaultIfEmptyResult = "Str";
        assertEquals(expectedDefaultIfEmptyResult, actualDefaultIfEmptyResult);
    }

    /**
     * Method under test: {@link Strings2#defaultIfEmpty(String, String)}
     */
    @SmallTest
    void testDefaultIfEmpty2() {
        // Arrange
        String str = null;
        String defaultStr = "Default Str";

        // Act
        String actualDefaultIfEmptyResult = Strings2.defaultIfEmpty(str, defaultStr);

        // Assert
        String expectedDefaultIfEmptyResult = "Default Str";
        assertEquals(expectedDefaultIfEmptyResult, actualDefaultIfEmptyResult);
    }

    /**
     * Method under test: {@link Strings2#defaultIfEmpty(String, String)}
     */
    @SmallTest
    void testDefaultIfEmpty3() {
        // Arrange
        String str = Strings2.EMPTY;
        String defaultStr = "Default Str";

        // Act
        String actualDefaultIfEmptyResult = Strings2.defaultIfEmpty(str, defaultStr);

        // Assert
        String expectedDefaultIfEmptyResult = "Default Str";
        assertEquals(expectedDefaultIfEmptyResult, actualDefaultIfEmptyResult);
    }

    /**
     * Method under test: {@link Strings2#defaultObjectIfEmpty(String, Function, Supplier)}
     */
    @SmallTest
    void testDefaultObjectIfEmpty() {
        // Arrange
        String str = "Str";
        Function<String, Object> nonEmptyFunction = null;
        Supplier<Object> emptySupplier = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
                () -> Strings2.defaultObjectIfEmpty(str, nonEmptyFunction, emptySupplier));
    }

    /**
     * Method under test: {@link Strings2#decamelize(String)}
     */
    @SmallTest
    void testDecamelize() {
        // Arrange
        String s = "foo";

        // Act
        String actualDecamelizeResult = Strings2.decamelize(s);

        // Assert
        String expectedDecamelizeResult = "FOO";
        assertEquals(expectedDecamelizeResult, actualDecamelizeResult);
    }

    /**
     * Method under test: {@link Strings2#decamelize(String)}
     */
    @SmallTest
    void testDecamelize2() {
        // Arrange
        String s = null;

        // Act
        String actualDecamelizeResult = Strings2.decamelize(s);

        // Assert
        String expectedDecamelizeResult = null;
        assertEquals(expectedDecamelizeResult, actualDecamelizeResult);
    }

    /**
     * Method under test: {@link Strings2#decamelize(String)}
     */
    @SmallTest
    void testDecamelize3() {
        // Arrange
        String s = ".";

        // Act
        String actualDecamelizeResult = Strings2.decamelize(s);

        // Assert
        String expectedDecamelizeResult = ".";
        assertEquals(expectedDecamelizeResult, actualDecamelizeResult);
    }

    /**
     * Method under test: {@link Strings2#decamelize(String)}
     */
    @SmallTest
    void testDecamelize4() {
        // Arrange
        String s = "findFirstByNotEmpty";

        // Act
        String actualDecamelizeResult = Strings2.decamelize(s);

        // Assert
        String expectedDecamelizeResult = "FIND_FIRST_BY_NOT_EMPTY";
        assertEquals(expectedDecamelizeResult, actualDecamelizeResult);
    }

    /**
     * Method under test: {@link Strings2#findFirstByNotEmptySilently(String[])}
     */
    @Nested
    class findFirstByNotEmptySilentlyTest {

        @SmallTest
        void findFirstByNotEmptySilently() {
            // Arrange
            String string = "Strings";
            String[] strings = new String[]{string};

            // Act
            String actualFindFirstByNotEmptySilentlyResult = Strings2.findFirstByNotEmptySilently(
                    strings);

            // Assert
            String expectedFindFirstByNotEmptySilentlyResult = "Strings";
            assertEquals(expectedFindFirstByNotEmptySilentlyResult,
                    actualFindFirstByNotEmptySilentlyResult);
        }

        @SmallTest
        void findFirstByNotEmptySilently2() {
            // Arrange
            String[] strings = null;

            // Act
            String actualFindFirstByNotEmptySilentlyResult = Strings2.findFirstByNotEmptySilently(
                    strings);

            // Assert
            String expectedFindFirstByNotEmptySilentlyResult = null;
            assertEquals(expectedFindFirstByNotEmptySilentlyResult,
                    actualFindFirstByNotEmptySilentlyResult);
        }

        @SmallTest
        void findFirstByNotEmptySilently3() {
            // Arrange
            String string = null;
            String[] strings = new String[]{string};

            // Act
            String actualFindFirstByNotEmptySilentlyResult = Strings2.findFirstByNotEmptySilently(
                    strings);

            // Assert
            String expectedFindFirstByNotEmptySilentlyResult = null;
            assertEquals(expectedFindFirstByNotEmptySilentlyResult,
                    actualFindFirstByNotEmptySilentlyResult);
        }

        @SmallTest
        void findFirstByNotEmptySilently4() {
            // Arrange
            String string = Strings2.EMPTY;
            String[] strings = new String[]{string};

            // Act
            String actualFindFirstByNotEmptySilentlyResult = Strings2.findFirstByNotEmptySilently(
                    strings);

            // Assert
            String expectedFindFirstByNotEmptySilentlyResult = null;
            assertEquals(expectedFindFirstByNotEmptySilentlyResult,
                    actualFindFirstByNotEmptySilentlyResult);
        }

    }

    /**
     * Method under test: {@link Strings2#checkNotNull(Object, String)}
     */
    @Nested
    class checkNotNull {

        @SmallTest
        void _参照値にnullを指定した場合に引数誤り例外を投げる() {
            // Arrange
            Object reference = null;
            String argName = "foo";

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                    () -> Strings2.checkNotNull(reference, argName));
        }

    }

    /**
     * Method under test: {@link Strings2#checkAllEntityNotNull(Object[], String)}
     */
    @Nested
    class checkAllEntityNotNullTest {

        @SmallTest
        void _参照値にnullとインデスクすを指定した場合に引数誤り例外を投げる() {
            // Arrange
            Object[] reference = new Object[]{null};
            String argName = "foo";

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                    () -> Strings2.checkAllEntityNotNull(reference, argName));
        }

    }

    /**
     * Method under test: {@link Strings2#concat(String[])}
     */

    @Nested
    class concatTest {

        @SmallTest
        void testConcat() {
            // Arrange
            String string = "Strings";
            String[] strings = new String[]{string};

            // Act
            String actualConcatResult = Strings2.concat(strings);

            // Assert
            String expectedConcatResult = "Strings";
            assertEquals(expectedConcatResult, actualConcatResult);
        }

        /**
         * Method under test: {@link Strings2#concat(String[])}
         */
        @SmallTest
        void testConcat2() {
            // Arrange
            String[] strings = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> Strings2.concat(strings));
        }

        /**
         * Method under test: {@link Strings2#concat(String[])}
         */
        @SmallTest
        void testConcat3() {
            // Arrange
            String string = null;
            String[] strings = new String[]{string};

            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> Strings2.concat(strings));
        }

    }

    /**
     * Method under test: {@link Strings2#isZenkakuAllCharacters(String)}
     */
    @Nested
    class isZenkakuAllCharacters {

        @SmallTest
        void testIsZenkakuAllCharacters() {
            // Arrange
            String aString = "A String";

            // Act
            boolean actualIsZenkakuAllCharactersResult = Strings2.isZenkakuAllCharacters(aString);

            // Assert
            boolean expectedIsZenkakuAllCharactersResult = false;
            assertEquals(expectedIsZenkakuAllCharactersResult, actualIsZenkakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isZenkakuAllCharacters(String)}
         */
        @SmallTest
        void testIsZenkakuAllCharacters2() {
            // Arrange
            String aString = null;

            // Act
            boolean actualIsZenkakuAllCharactersResult = Strings2.isZenkakuAllCharacters(aString);

            // Assert
            boolean expectedIsZenkakuAllCharactersResult = true;
            assertEquals(expectedIsZenkakuAllCharactersResult, actualIsZenkakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isZenkakuAllCharacters(String)}
         */
        @SmallTest
        void testIsZenkakuAllCharacters3() {
            // Arrange
            String aString = Strings2.EMPTY;

            // Act
            boolean actualIsZenkakuAllCharactersResult = Strings2.isZenkakuAllCharacters(aString);

            // Assert
            boolean expectedIsZenkakuAllCharactersResult = true;
            assertEquals(expectedIsZenkakuAllCharactersResult, actualIsZenkakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isZenkakuAllCharacters(String)}
         */
        @SmallTest
        void testIsZenkakuAllCharacters4() {
            // Arrange
            String aString = "引数emptySupplierがnullです。null以外の値を指定してください";

            // Act
            boolean actualIsZenkakuAllCharactersResult = Strings2.isZenkakuAllCharacters(aString);

            // Assert
            boolean expectedIsZenkakuAllCharactersResult = false;
            assertEquals(expectedIsZenkakuAllCharactersResult, actualIsZenkakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isZenkakuAllCharacters(String)}
         */
        @SmallTest
        void testIsZenkakuAllCharacters5() {
            // Arrange
            String aString = "．";

            // Act
            boolean actualIsZenkakuAllCharactersResult = Strings2.isZenkakuAllCharacters(aString);

            // Assert
            boolean expectedIsZenkakuAllCharactersResult = true;
            assertEquals(expectedIsZenkakuAllCharactersResult, actualIsZenkakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isZenkakuAllCharacters(String)}
         */
        @SmallTest
        void testIsZenkakuAllCharacters6() {
            // Arrange
            String aString = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ";

            // Act
            boolean actualIsZenkakuAllCharactersResult = Strings2.isZenkakuAllCharacters(aString);

            // Assert
            boolean expectedIsZenkakuAllCharactersResult = false;
            assertEquals(expectedIsZenkakuAllCharactersResult, actualIsZenkakuAllCharactersResult);
        }

    }

    /**
     * Method under test: {@link Strings2#isHankakuAllCharacters(String)}
     */
    @Nested
    class isHankakuAllCharacters {

        @SmallTest
        void testIsHankakuAllCharacters() {
            // Arrange
            String aString = "A String";

            // Act
            boolean actualIsHankakuAllCharactersResult = Strings2.isHankakuAllCharacters(aString);

            // Assert
            boolean expectedIsHankakuAllCharactersResult = true;
            assertEquals(expectedIsHankakuAllCharactersResult, actualIsHankakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isHankakuAllCharacters(String)}
         */
        @SmallTest
        void testIsHankakuAllCharacters2() {
            // Arrange
            String aString = null;

            // Act
            boolean actualIsHankakuAllCharactersResult = Strings2.isHankakuAllCharacters(aString);

            // Assert
            boolean expectedIsHankakuAllCharactersResult = true;
            assertEquals(expectedIsHankakuAllCharactersResult, actualIsHankakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isHankakuAllCharacters(String)}
         */
        @SmallTest
        void testIsHankakuAllCharacters3() {
            // Arrange
            String aString = Strings2.EMPTY;

            // Act
            boolean actualIsHankakuAllCharactersResult = Strings2.isHankakuAllCharacters(aString);

            // Assert
            boolean expectedIsHankakuAllCharactersResult = true;
            assertEquals(expectedIsHankakuAllCharactersResult, actualIsHankakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isHankakuAllCharacters(String)}
         */
        @SmallTest
        void testIsHankakuAllCharacters4() {
            // Arrange
            String aString = "引数emptySupplierがnullです。null以外の値を指定してください";

            // Act
            boolean actualIsHankakuAllCharactersResult = Strings2.isHankakuAllCharacters(aString);

            // Assert
            boolean expectedIsHankakuAllCharactersResult = false;
            assertEquals(expectedIsHankakuAllCharactersResult, actualIsHankakuAllCharactersResult);
        }

        /**
         * Method under test: {@link Strings2#isHankakuAllCharacters(String)}
         */
        @SmallTest
        void testIsHankakuAllCharacters5() {
            // Arrange
            String aString = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ";

            // Act
            boolean actualIsHankakuAllCharactersResult = Strings2.isHankakuAllCharacters(aString);

            // Assert
            boolean expectedIsHankakuAllCharactersResult = true;
            assertEquals(expectedIsHankakuAllCharactersResult, actualIsHankakuAllCharactersResult);
        }

    }

    /**
     * Method under test: {@link Strings2#emptyToNull(String)}
     */
    @Nested
    class emptyToNull {

        @SmallTest
        void _引数がnullの場合nullを返却する() {
            // given, when and then
            assertThat(Strings2.emptyToNull(null))
                    .isNull();

        }

        @SmallTest
        void _引数がemptyの場合nullを返却する() {
            // given, when and then
            assertThat(Strings2.emptyToNull(Strings2.EMPTY))
                    .isNull();

        }

        @SmallTest
        void _引数がStrの場合Strを返却する() {
            // given, when and then
            assertThat(Strings2.emptyToNull("Str"))
                    .isEqualTo("Str");

        }


    }

}

