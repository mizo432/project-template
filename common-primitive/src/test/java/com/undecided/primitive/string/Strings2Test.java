package com.undecided.primitive.string;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class Strings2Test {

    /**
     * Method under test: {@link Strings2#contains(String, char)}
     */
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    @Test
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
    class findFirstByNotEmptySilently {

        @Test
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

        @Test
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

        @Test
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

        @Test
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

        @Test
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
    class checkAllEntityNotNull {

        @Test
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
    class concat {

        @Test
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
        @Test
        void testConcat2() {
            // Arrange
            String[] strings = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> Strings2.concat(strings));
        }

        /**
         * Method under test: {@link Strings2#concat(String[])}
         */
        @Test
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

        @Test
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
        @Test
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
        @Test
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
        @Test
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
        @Test
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
        @Test
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

        @Test
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
        @Test
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
        @Test
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
        @Test
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
        @Test
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
     * Method under test: {@link Strings2#ifIsEmptyToNull(String)}
     */
    @Nested
    class ifIsEmptyToNull {

        @Test
        void _空文字列を渡すとnullが返却される() {
            assertNull(Strings2.ifIsEmptyToNull(Strings2.EMPTY));

        }

        @Test
        void _空文字列ではないStrを渡すとnullが返却される() {
            assertEquals("Str", Strings2.ifIsEmptyToNull("Str"));

        }

        @Test
        void _nullを渡すとnullが返却される() {
            assertNull(Strings2.ifIsEmptyToNull(null));
        }

    }

}

