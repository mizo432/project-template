package org.venusPj.primitive.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.venusPj.primitive.string.CharSequences;
import org.venusPj.primitive.string.Strings2;

class CharSequencesTest {

    /**
     * Method under test: {@link CharSequences#isEmpty(CharSequence)}
     */
    @Test
    void testIsEmpty() {
        // Arrange
        String cs = System.lineSeparator();

        // Act
        boolean actualIsEmptyResult = CharSequences.isEmpty(cs);

        // Assert
        boolean expectedIsEmptyResult = false;
        assertEquals(expectedIsEmptyResult, actualIsEmptyResult);
    }

    /**
     * Method under test: {@link CharSequences#isEmpty(CharSequence)}
     */
    @Test
    void testIsEmpty2() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean actualIsEmptyResult = CharSequences.isEmpty(cs);

        // Assert
        boolean expectedIsEmptyResult = true;
        assertEquals(expectedIsEmptyResult, actualIsEmptyResult);
    }

    /**
     * Method under test: {@link CharSequences#isEmpty(CharSequence)}
     */
    @Test
    void testIsEmpty3() {
        // Arrange
        StringBuilder cs = new StringBuilder();

        // Act
        boolean actualIsEmptyResult = CharSequences.isEmpty(cs);

        // Assert
        boolean expectedIsEmptyResult = true;
        assertEquals(expectedIsEmptyResult, actualIsEmptyResult);
    }

    /**
     * Method under test: {@link CharSequences#subSequence(CharSequence, int)}
     */
    @Test
    void testSubSequence() {
        // Arrange
        String cs = System.lineSeparator();
        int start = 1;

        // Act
        CharSequence actualSubSequenceResult = CharSequences.subSequence(cs, start);

        // Assert
        String expectedSubSequenceResult = Strings2.EMPTY;
        assertEquals(expectedSubSequenceResult, actualSubSequenceResult);
    }

    /**
     * Method under test: {@link CharSequences#subSequence(CharSequence, int)}
     */
    @Test
    void testSubSequence2() {
        // Arrange
        CharSequence cs = null;
        int start = 1;

        // Act
        CharSequence actualSubSequenceResult = CharSequences.subSequence(cs, start);

        // Assert
        CharSequence expectedSubSequenceResult = null;
        assertEquals(expectedSubSequenceResult, actualSubSequenceResult);
    }

    /**
     * Method under test: {@link CharSequences#indexOf(CharSequence, int, int)}
     */
    @Test
    void testIndexOf() {
        // Arrange
        String cs = System.lineSeparator();
        int searchChar = 1;
        int start = 1;

        // Act
        int actualIndexOfResult = CharSequences.indexOf(cs, searchChar, start);

        // Assert
        int expectedIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedIndexOfResult, actualIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#indexOf(CharSequence, int, int)}
     */
    @Test
    void testIndexOf2() {
        // Arrange
        StringBuffer cs = new StringBuffer();
        int searchChar = 1;
        int start = 1;

        // Act
        int actualIndexOfResult = CharSequences.indexOf(cs, searchChar, start);

        // Assert
        int expectedIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedIndexOfResult, actualIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#indexOf(CharSequence, int, int)}
     */
    @Test
    void testIndexOf3() {
        // Arrange
        StringBuffer stringBuffer = new StringBuffer();
        String obj = "Obj";
        stringBuffer.append((Object) obj);
        int searchChar = 1;
        int start = 1;

        // Act
        int actualIndexOfResult = CharSequences.indexOf(stringBuffer, searchChar, start);

        // Assert
        int expectedIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedIndexOfResult, actualIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#indexOf(CharSequence, int, int)}
     */
    @Test
    void testIndexOf4() {
        // Arrange
        StringBuffer stringBuffer = new StringBuffer();
        char resultChar = '\u0001';
        char resultChar1 = '\u0001';
        char resultChar2 = '\u0001';
        char resultChar3 = '\u0001';
        char[] str = new char[]{resultChar, resultChar1, resultChar2, resultChar3};
        stringBuffer.append(str);
        String obj = "Obj";
        stringBuffer.append((Object) obj);
        int searchChar = 1;
        int start = 1;

        // Act
        int actualIndexOfResult = CharSequences.indexOf(stringBuffer, searchChar, start);

        // Assert
        int expectedIndexOfResult = 1;
        assertEquals(expectedIndexOfResult, actualIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#indexOf(CharSequence, CharSequence, int)}
     */
    @Test
    void testIndexOf5() {
        // Arrange
        String cs = System.lineSeparator();
        String searchChar = System.lineSeparator();
        int start = 1;

        // Act
        int actualIndexOfResult = CharSequences.indexOf(cs, searchChar, start);

        // Assert
        int expectedIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedIndexOfResult, actualIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#lastIndexOf(CharSequence, int, int)}
     */
    @Test
    void testLastIndexOf() {
        // Arrange
        String cs = System.lineSeparator();
        int searchChar = 1;
        int start = 1;

        // Act
        int actualLastIndexOfResult = CharSequences.lastIndexOf(cs, searchChar, start);

        // Assert
        int expectedLastIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedLastIndexOfResult, actualLastIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#lastIndexOf(CharSequence, int, int)}
     */
    @Test
    void testLastIndexOf2() {
        // Arrange
        StringBuffer cs = new StringBuffer();
        int searchChar = 1;
        int start = 1;

        // Act
        int actualLastIndexOfResult = CharSequences.lastIndexOf(cs, searchChar, start);

        // Assert
        int expectedLastIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedLastIndexOfResult, actualLastIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#lastIndexOf(CharSequence, int, int)}
     */
    @Test
    void testLastIndexOf3() {
        // Arrange
        StringBuffer stringBuffer = new StringBuffer();
        String obj = "Obj";
        stringBuffer.append((Object) obj);
        int searchChar = 1;
        int start = 1;

        // Act
        int actualLastIndexOfResult = CharSequences.lastIndexOf(stringBuffer, searchChar, start);

        // Assert
        int expectedLastIndexOfResult = Strings2.INDEX_NOT_FOUND;
        assertEquals(expectedLastIndexOfResult, actualLastIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#lastIndexOf(CharSequence, int, int)}
     */
    @Test
    void testLastIndexOf4() {
        // Arrange
        StringBuffer stringBuffer = new StringBuffer();
        char resultChar = '\u0001';
        char resultChar1 = '\u0001';
        char resultChar2 = '\u0001';
        char resultChar3 = '\u0001';
        char[] str = new char[]{resultChar, resultChar1, resultChar2, resultChar3};
        stringBuffer.append(str);
        String obj = "Obj";
        stringBuffer.append((Object) obj);
        int searchChar = 1;
        int start = 1;

        // Act
        int actualLastIndexOfResult = CharSequences.lastIndexOf(stringBuffer, searchChar, start);

        // Assert
        int expectedLastIndexOfResult = 1;
        assertEquals(expectedLastIndexOfResult, actualLastIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#lastIndexOf(CharSequence, CharSequence, int)}
     */
    @Test
    void testLastIndexOf5() {
        // Arrange
        String cs = System.lineSeparator();
        String searchChar = System.lineSeparator();
        int start = 1;

        // Act
        int actualLastIndexOfResult = CharSequences.lastIndexOf(cs, searchChar, start);

        // Assert
        int expectedLastIndexOfResult = 0;
        assertEquals(expectedLastIndexOfResult, actualLastIndexOfResult);
    }

    /**
     * Method under test: {@link CharSequences#toCharArray(CharSequence)}
     */
    @Test
    void testToCharArray() {
        // Arrange
        String cs = System.lineSeparator();

        // Act
        char[] actualToCharArrayResult = CharSequences.toCharArray(cs);

        // Assert
        int expectedResultInt = 1;
        int actualResultInt = actualToCharArrayResult.length;
        assertEquals(expectedResultInt, actualResultInt);
        char expectedResultChar = '\n';
        int resultInt = 0;
        char actualResultChar = actualToCharArrayResult[resultInt];
        assertEquals(expectedResultChar, actualResultChar);
    }

    /**
     * Method under test: {@link CharSequences#toCharArray(CharSequence)}
     */
    @Test
    void testToCharArray2() {
        // Arrange
        StringBuffer cs = new StringBuffer();

        // Act
        char[] actualToCharArrayResult = CharSequences.toCharArray(cs);

        // Assert
        int expectedResultInt = 0;
        int actualResultInt = actualToCharArrayResult.length;
        assertEquals(expectedResultInt, actualResultInt);
    }

    /**
     * Method under test: {@link CharSequences#toCharArray(CharSequence)}
     */
    @Test
    void testToCharArray3() {
        // Arrange
        StringBuffer stringBuffer = new StringBuffer();
        String obj = "Obj";
        stringBuffer.append((Object) obj);

        // Act
        char[] actualToCharArrayResult = CharSequences.toCharArray(stringBuffer);

        // Assert
        int expectedResultInt = 3;
        int actualResultInt = actualToCharArrayResult.length;
        assertEquals(expectedResultInt, actualResultInt);
        char expectedResultChar = 'O';
        int resultInt = 0;
        char actualResultChar = actualToCharArrayResult[resultInt];
        assertEquals(expectedResultChar, actualResultChar);
        char expectedResultChar1 = 'b';
        int resultInt1 = 1;
        char actualResultChar1 = actualToCharArrayResult[resultInt1];
        assertEquals(expectedResultChar1, actualResultChar1);
        char expectedResultChar2 = 'j';
        int resultInt2 = 2;
        char actualResultChar2 = actualToCharArrayResult[resultInt2];
        assertEquals(expectedResultChar2, actualResultChar2);
    }

    /**
     * Method under test:
     * {@link CharSequences#regionMatches(CharSequence, boolean, int, CharSequence, int, int)}
     */
    @Test
    void testRegionMatches() {
        // Arrange
        String cs = System.lineSeparator();
        boolean ignoreCase = true;
        int thisStart = 1;
        String substring = System.lineSeparator();
        int start = 1;
        int length = 3;

        // Act
        boolean actualRegionMatchesResult = CharSequences.regionMatches(cs, ignoreCase, thisStart,
            substring, start,
            length);

        // Assert
        boolean expectedRegionMatchesResult = false;
        assertEquals(expectedRegionMatchesResult, actualRegionMatchesResult);
    }

    /**
     * Method under test:
     * {@link CharSequences#regionMatches(CharSequence, boolean, int, CharSequence, int, int)}
     */
    @Test
    void testRegionMatches2() {
        // Arrange
        StringBuffer cs = new StringBuffer();
        boolean ignoreCase = true;
        int thisStart = 1;
        String substring = System.lineSeparator();
        int start = 1;
        int length = 3;

        // Act
        boolean actualRegionMatchesResult = CharSequences.regionMatches(cs, ignoreCase, thisStart,
            substring, start,
            length);

        // Assert
        boolean expectedRegionMatchesResult = false;
        assertEquals(expectedRegionMatchesResult, actualRegionMatchesResult);
    }

    /**
     * Method under test:
     * {@link CharSequences#regionMatches(CharSequence, boolean, int, CharSequence, int, int)}
     */
    @Test
    void testRegionMatches3() {
        // Arrange
        String cs = System.lineSeparator();
        boolean ignoreCase = true;
        int thisStart = 1;
        StringBuffer substring = new StringBuffer();
        int start = 1;
        int length = 3;

        // Act
        boolean actualRegionMatchesResult = CharSequences.regionMatches(cs, ignoreCase, thisStart,
            substring, start,
            length);

        // Assert
        boolean expectedRegionMatchesResult = false;
        assertEquals(expectedRegionMatchesResult, actualRegionMatchesResult);
    }

    /**
     * Method under test:
     * {@link CharSequences#regionMatches(CharSequence, boolean, int, CharSequence, int, int)}
     */
    @Test
    void testRegionMatches4() {
        // Arrange
        String cs = System.lineSeparator();
        boolean ignoreCase = true;
        int thisStart = 1;
        String substring = System.lineSeparator();
        int start = 1;
        int length = 0;

        // Act
        boolean actualRegionMatchesResult = CharSequences.regionMatches(cs, ignoreCase, thisStart,
            substring, start,
            length);

        // Assert
        boolean expectedRegionMatchesResult = true;
        assertEquals(expectedRegionMatchesResult, actualRegionMatchesResult);
    }

    /**
     * Method under test:
     * {@link CharSequences#regionMatches(CharSequence, boolean, int, CharSequence, int, int)}
     */
    @Test
    void testRegionMatches5() {
        // Arrange
        StringBuffer stringBuffer = new StringBuffer();
        char resultChar = '\u0001';
        char resultChar1 = '\u0001';
        char resultChar2 = '\u0001';
        char resultChar3 = '\u0001';
        char[] str = new char[]{resultChar, resultChar1, resultChar2, resultChar3};
        stringBuffer.append(str);
        boolean ignoreCase = true;
        int thisStart = 1;
        String substring = System.lineSeparator();
        int start = 1;
        int length = 3;

        // Act
        boolean actualRegionMatchesResult = CharSequences.regionMatches(stringBuffer, ignoreCase,
            thisStart, substring,
            start, length);

        // Assert
        boolean expectedRegionMatchesResult = false;
        assertEquals(expectedRegionMatchesResult, actualRegionMatchesResult);
    }

    /**
     * Method under test: {@link CharSequences#isDigit(CharSequence)}
     */
    @Test
    void testIsDigit() {
        // Arrange
        String cs = System.lineSeparator();

        // Act
        boolean actualIsDigitResult = CharSequences.isDigit(cs);

        // Assert
        boolean expectedIsDigitResult = false;
        assertEquals(expectedIsDigitResult, actualIsDigitResult);
    }

    /**
     * Method under test: {@link CharSequences#isDigit(CharSequence)}
     */
    @Test
    void testIsDigit2() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean actualIsDigitResult = CharSequences.isDigit(cs);

        // Assert
        boolean expectedIsDigitResult = false;
        assertEquals(expectedIsDigitResult, actualIsDigitResult);
    }

    /**
     * Method under test: {@link CharSequences#isDigit(CharSequence)}
     */
    @Test
    void testIsDigit3() {
        // Arrange
        String cs = "42";

        // Act
        boolean actualIsDigitResult = CharSequences.isDigit(cs);

        // Assert
        boolean expectedIsDigitResult = true;
        assertEquals(expectedIsDigitResult, actualIsDigitResult);
    }

    /**
     * Method under test: {@link CharSequences#isDigit(CharSequence)}
     */
    @Test
    void testIsDigit4() {
        // Arrange
        StringBuilder cs = new StringBuilder();

        // Act
        boolean actualIsDigitResult = CharSequences.isDigit(cs);

        // Assert
        boolean expectedIsDigitResult = false;
        assertEquals(expectedIsDigitResult, actualIsDigitResult);
    }

    static class Strings2Test {

        /**
         * Method under test: {@link Strings2#collectionToDelimitedString(Collection, String)}
         */
        @Test
        void testCollectionToDelimitedString() {
            // Arrange
            ArrayList<Object> coll = new ArrayList<>();
            String delim = "Delim";

            // Act
            String actualCollectionToDelimitedStringResult = Strings2.collectionToDelimitedString(
                coll,
                delim);

            // Assert
            String expectedCollectionToDelimitedStringResult = Strings2.EMPTY;
            assertEquals(expectedCollectionToDelimitedStringResult,
                actualCollectionToDelimitedStringResult);
        }

        /**
         * Method under test: {@link Strings2#collectionToDelimitedString(Collection, String)}
         */
        @Test
        void testCollectionToDelimitedString2() {
            // Arrange
            ArrayList<Object> objectList = new ArrayList<>();
            String e = "42";
            objectList.add(e);
            String delim = "Delim";

            // Act
            String actualCollectionToDelimitedStringResult = Strings2.collectionToDelimitedString(
                objectList, delim);

            // Assert
            String expectedCollectionToDelimitedStringResult = "42";
            assertEquals(expectedCollectionToDelimitedStringResult,
                actualCollectionToDelimitedStringResult);
        }

        /**
         * Method under test: {@link Strings2#collectionToDelimitedString(Collection, String)}
         */
        @Test
        void testCollectionToDelimitedString3() {
            // Arrange
            ArrayList<Object> objectList = new ArrayList<>();
            String e = "42";
            objectList.add(e);
            String e1 = "42";
            objectList.add(e1);
            String delim = "Delim";

            // Act
            String actualCollectionToDelimitedStringResult = Strings2.collectionToDelimitedString(
                objectList, delim);

            // Assert
            String expectedCollectionToDelimitedStringResult = "42Delim42";
            assertEquals(expectedCollectionToDelimitedStringResult,
                actualCollectionToDelimitedStringResult);
        }

        /**
         * Method under test:
         * {@link Strings2#collectionToDelimitedString(Collection, String, String, String)}
         */
        @Test
        void testCollectionToDelimitedString4() {
            // Arrange
            ArrayList<Object> coll = new ArrayList<>();
            String delim = "Delim";
            String prefix = "Prefix";
            String suffix = "Suffix";

            // Act
            String actualCollectionToDelimitedStringResult = Strings2.collectionToDelimitedString(
                coll,
                delim, prefix,
                suffix);

            // Assert
            String expectedCollectionToDelimitedStringResult = Strings2.EMPTY;
            assertEquals(expectedCollectionToDelimitedStringResult,
                actualCollectionToDelimitedStringResult);
        }

        /**
         * Method under test:
         * {@link Strings2#collectionToDelimitedString(Collection, String, String, String)}
         */
        @Test
        void testCollectionToDelimitedString5() {
            // Arrange
            ArrayList<Object> objectList = new ArrayList<>();
            String e = "42";
            objectList.add(e);
            String delim = "Delim";
            String prefix = "Prefix";
            String suffix = "Suffix";

            // Act
            String actualCollectionToDelimitedStringResult = Strings2.collectionToDelimitedString(
                objectList, delim, prefix,
                suffix);

            // Assert
            String expectedCollectionToDelimitedStringResult = "Prefix42Suffix";
            assertEquals(expectedCollectionToDelimitedStringResult,
                actualCollectionToDelimitedStringResult);
        }

        /**
         * Method under test:
         * {@link Strings2#collectionToDelimitedString(Collection, String, String, String)}
         */
        @Test
        void testCollectionToDelimitedString6() {
            // Arrange
            ArrayList<Object> objectList = new ArrayList<>();
            String e = "42";
            objectList.add(e);
            String e1 = "42";
            objectList.add(e1);
            String delim = "Delim";
            String prefix = "Prefix";
            String suffix = "Suffix";

            // Act
            String actualCollectionToDelimitedStringResult = Strings2.collectionToDelimitedString(
                objectList, delim, prefix,
                suffix);

            // Assert
            String expectedCollectionToDelimitedStringResult = "Prefix42SuffixDelimPrefix42Suffix";
            assertEquals(expectedCollectionToDelimitedStringResult,
                actualCollectionToDelimitedStringResult);
        }

        /**
         * Method under test: {@link Strings2#collectionToCommaDelimitedString(Collection)}
         */
        @Test
        void testCollectionToCommaDelimitedString() {
            // Arrange
            ArrayList<Object> coll = new ArrayList<>();

            // Act
            String actualCollectionToCommaDelimitedStringResult = Strings2.collectionToCommaDelimitedString(
                coll);

            // Assert
            String expectedCollectionToCommaDelimitedStringResult = Strings2.EMPTY;
            assertEquals(expectedCollectionToCommaDelimitedStringResult,
                actualCollectionToCommaDelimitedStringResult);
        }

        /**
         * Method under test: {@link Strings2#collectionToCommaDelimitedString(Collection)}
         */
        @Test
        void testCollectionToCommaDelimitedString2() {
            // Arrange
            ArrayList<Object> objectList = new ArrayList<>();
            String e = "42";
            objectList.add(e);

            // Act
            String actualCollectionToCommaDelimitedStringResult = Strings2.collectionToCommaDelimitedString(
                objectList);

            // Assert
            String expectedCollectionToCommaDelimitedStringResult = "42";
            assertEquals(expectedCollectionToCommaDelimitedStringResult,
                actualCollectionToCommaDelimitedStringResult);
        }

        /**
         * Method under test: {@link Strings2#collectionToCommaDelimitedString(Collection)}
         */
        @Test
        void testCollectionToCommaDelimitedString3() {
            // Arrange
            ArrayList<Object> objectList = new ArrayList<>();
            String e = "42";
            objectList.add(e);
            String e1 = "42";
            objectList.add(e1);

            // Act
            String actualCollectionToCommaDelimitedStringResult = Strings2.collectionToCommaDelimitedString(
                objectList);

            // Assert
            String expectedCollectionToCommaDelimitedStringResult = "42,42";
            assertEquals(expectedCollectionToCommaDelimitedStringResult,
                actualCollectionToCommaDelimitedStringResult);
        }

        /**
         * Method under test: {@link Strings2#capitalize(String)}
         */
        @Test
        void testCapitalize() {
            // Arrange
            String name = "Name";

            // Act
            String actualCapitalizeResult = Strings2.capitalize(name);

            // Assert
            String expectedCapitalizeResult = "Name";
            assertEquals(expectedCapitalizeResult, actualCapitalizeResult);
        }

        /**
         * Method under test: {@link Strings2#capitalize(String)}
         */
        @Test
        void testCapitalize2() {
            // Arrange
            String name = null;

            // Act
            String actualCapitalizeResult = Strings2.capitalize(name);

            // Assert
            String expectedCapitalizeResult = null;
            assertEquals(expectedCapitalizeResult, actualCapitalizeResult);
        }

        /**
         * Method under test: {@link Strings2#capitalize(String)}
         */
        @Test
        void testCapitalize3() {
            // Arrange
            String name = Strings2.EMPTY;

            // Act
            String actualCapitalizeResult = Strings2.capitalize(name);

            // Assert
            String expectedCapitalizeResult = Strings2.EMPTY;
            assertEquals(expectedCapitalizeResult, actualCapitalizeResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCase(String)}
         */
        @Test
        void testCamelUpperCase() {
            // Arrange
            String s = "foo";

            // Act
            String actualCamelUpperCaseResult = Strings2.camelUpperCase(s);

            // Assert
            String expectedCamelUpperCaseResult = "Foo";
            assertEquals(expectedCamelUpperCaseResult, actualCamelUpperCaseResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCase(String)}
         */
        @Test
        void testCamelUpperCase2() {
            // Arrange
            String s = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> Strings2.camelUpperCase(s));
        }

        /**
         * Method under test: {@link Strings2#camelUpperCase(String)}
         */
        @Test
        void testCamelUpperCase3() {
            // Arrange
            String string = Strings2.EMPTY;

            // Act
            String actualCamelUpperCaseResult = Strings2.camelUpperCase((String) string);

            // Assert
            String expectedCamelUpperCaseResult = Strings2.EMPTY;
            assertEquals(expectedCamelUpperCaseResult, actualCamelUpperCaseResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCase(String)}
         */
        @Test
        void testCamelUpperCase4() {
            // Arrange
            String s = ".";

            // Act
            String actualCamelUpperCaseResult = Strings2.camelUpperCase(s);

            // Assert
            String expectedCamelUpperCaseResult = ".";
            assertEquals(expectedCamelUpperCaseResult, actualCamelUpperCaseResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCaseSilently(String)}
         */
        @Test
        void testCamelUpperCaseSilently() {
            // Arrange
            String s = "foo";

            // Act
            String actualCamelUpperCaseSilentlyResult = Strings2.camelUpperCaseSilently(s);

            // Assert
            String expectedCamelUpperCaseSilentlyResult = "Foo";
            assertEquals(expectedCamelUpperCaseSilentlyResult, actualCamelUpperCaseSilentlyResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCaseSilently(String)}
         */
        @Test
        void testCamelUpperCaseSilently2() {
            // Arrange
            String s = null;

            // Act
            String actualCamelUpperCaseSilentlyResult = Strings2.camelUpperCaseSilently(s);

            // Assert
            String expectedCamelUpperCaseSilentlyResult = null;
            assertEquals(expectedCamelUpperCaseSilentlyResult, actualCamelUpperCaseSilentlyResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCaseSilently(String)}
         */
        @Test
        void testCamelUpperCaseSilently3() {
            // Arrange
            String string = Strings2.EMPTY;

            // Act
            String actualCamelUpperCaseSilentlyResult = Strings2.camelUpperCaseSilently(
                (String) string);

            // Assert
            String expectedCamelUpperCaseSilentlyResult = Strings2.EMPTY;
            assertEquals(expectedCamelUpperCaseSilentlyResult, actualCamelUpperCaseSilentlyResult);
        }

        /**
         * Method under test: {@link Strings2#camelUpperCaseSilently(String)}
         */
        @Test
        void testCamelUpperCaseSilently4() {
            // Arrange
            String s = ".";

            // Act
            String actualCamelUpperCaseSilentlyResult = Strings2.camelUpperCaseSilently(s);

            // Assert
            String expectedCamelUpperCaseSilentlyResult = ".";
            assertEquals(expectedCamelUpperCaseSilentlyResult, actualCamelUpperCaseSilentlyResult);
        }

        /**
         * Method under test: {@link Strings2#camelize(String)}
         */
        @Test
        void testCamelize() {
            // Arrange
            String s = "foo";

            // Act
            String actualCamelizeResult = Strings2.camelize(s);

            // Assert
            String expectedCamelizeResult = "Foo";
            assertEquals(expectedCamelizeResult, actualCamelizeResult);
        }

        /**
         * Method under test: {@link Strings2#camelize(String)}
         */
        @Test
        void testCamelize2() {
            // Arrange
            String s = null;

            // Act
            String actualCamelizeResult = Strings2.camelize(s);

            // Assert
            String expectedCamelizeResult = null;
            assertEquals(expectedCamelizeResult, actualCamelizeResult);
        }

        /**
         * Method under test: {@link Strings2#camelize(String)}
         */
        @Test
        void testCamelize3() {
            // Arrange
            String s = "_";

            // Act
            String actualCamelizeResult = Strings2.camelize(s);

            // Assert
            String expectedCamelizeResult = Strings2.EMPTY;
            assertEquals(expectedCamelizeResult, actualCamelizeResult);
        }

        /**
         * Method under test: {@link Strings2#camelize(String)}
         */
        @Test
        void testCamelize4() {
            // Arrange
            String s = Strings2.EMPTY;

            // Act
            String actualCamelizeResult = Strings2.camelize(s);

            // Assert
            String expectedCamelizeResult = Strings2.EMPTY;
            assertEquals(expectedCamelizeResult, actualCamelizeResult);
        }

        /**
         * Method under test: {@link Strings2#camelize(String)}
         */
        @Test
        void testCamelize5() {
            // Arrange
            String s = "foo_";

            // Act
            String actualCamelizeResult = Strings2.camelize(s);

            // Assert
            String expectedCamelizeResult = "Foo_";
            assertEquals(expectedCamelizeResult, actualCamelizeResult);
        }

        /**
         * Method under test: {@link Strings2#appendHex(StringBuilder, byte)}
         */
        @Test
        @Disabled("TODO: Complete this test")
        void testAppendHex() {
            // TODO: Complete this test.
            //   Reason: R013 No inputs found that don't throw a trivial exception.
            //   Diffblue Cover tried to run the arrange/act section, but the method under
            //   test threw
            //   java.lang.NullPointerException: Cannot invoke "java.lang.StringBuilder.append(char)" because "buf" is null
            //       at org.venusPj.primitive.string.Strings2.appendHex(Strings2.java:1779)
            //   See https://diff.blue/R013 to resolve this issue.

            // Arrange
            StringBuilder buf = null;
            char resultChar = 'A';

            // Act
            Strings2.appendHex(buf, (byte) resultChar);
        }

        /**
         * Method under test: {@link Strings2#appendHex(StringBuilder, int)}
         */
        @Test
        @Disabled("TODO: Complete this test")
        void testAppendHex2() {
            // TODO: Complete this test.
            //   Reason: R013 No inputs found that don't throw a trivial exception.
            //   Diffblue Cover tried to run the arrange/act section, but the method under
            //   test threw
            //   java.lang.NullPointerException: Cannot invoke "java.lang.StringBuilder.append(String)" because "buf" is null
            //       at org.venusPj.primitive.string.Strings2.appendHex(Strings2.java:1790)
            //   See https://diff.blue/R013 to resolve this issue.

            // Arrange
            StringBuilder buf = null;
            int i = 1;

            // Act
            Strings2.appendHex(buf, i);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        void testChangeHankakuToZenkaku() {
            // Arrange
            String aString = "A String";

            // Act
            String actualChangeHankakuToZenkakuResult = Strings2.changeHankakuToZenkaku(aString);

            // Assert
            String expectedChangeHankakuToZenkakuResult = "Ａ Ｓｔｒｉｎｇ";
            assertEquals(expectedChangeHankakuToZenkakuResult, actualChangeHankakuToZenkakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        @Disabled("TODO: Complete this test")
        void testChangeHankakuToZenkaku2() {
            // TODO: Complete this test.
            //   Reason: R013 No inputs found that don't throw a trivial exception.
            //   Diffblue Cover tried to run the arrange/act section, but the method under
            //   test threw
            //   java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
            //       at java.lang.AbstractStringBuilder.<init>(AbstractStringBuilder.java:105)
            //       at java.lang.StringBuffer.<init>(StringBuffer.java:158)
            //       at org.venusPj.primitive.string.Strings2.hankakuKatakanaTokubetsuHenkan(Strings2.java:2090)
            //       at org.venusPj.primitive.string.Strings2.changeHankakuToZenkaku(Strings2.java:1971)
            //   See https://diff.blue/R013 to resolve this issue.

            // Arrange
            String aString = null;

            // Act
            Strings2.changeHankakuToZenkaku(aString);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        void testChangeHankakuToZenkaku3() {
            // Arrange
            String aString = Strings2.EMPTY;

            // Act
            String actualChangeHankakuToZenkakuResult = Strings2.changeHankakuToZenkaku(aString);

            // Assert
            String expectedChangeHankakuToZenkakuResult = Strings2.EMPTY;
            assertEquals(expectedChangeHankakuToZenkakuResult, actualChangeHankakuToZenkakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        void testChangeHankakuToZenkaku4() {
            // Arrange
            String aString = "42";

            // Act
            String actualChangeHankakuToZenkakuResult = Strings2.changeHankakuToZenkaku(aString);

            // Assert
            String expectedChangeHankakuToZenkakuResult = "４２";
            assertEquals(expectedChangeHankakuToZenkakuResult, actualChangeHankakuToZenkakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        void testChangeHankakuToZenkaku5() {
            // Arrange
            String aString = ".";

            // Act
            String actualChangeHankakuToZenkakuResult = Strings2.changeHankakuToZenkaku(aString);

            // Assert
            String expectedChangeHankakuToZenkakuResult = "．";
            assertEquals(expectedChangeHankakuToZenkakuResult, actualChangeHankakuToZenkakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        void testChangeHankakuToZenkaku6() {
            // Arrange
            String aString = "A String.";

            // Act
            String actualChangeHankakuToZenkakuResult = Strings2.changeHankakuToZenkaku(aString);

            // Assert
            String expectedChangeHankakuToZenkakuResult = "Ａ Ｓｔｒｉｎｇ．";
            assertEquals(expectedChangeHankakuToZenkakuResult, actualChangeHankakuToZenkakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkaku(String)}
         */
        @Test
        void testChangeHankakuToZenkaku7() {
            // Arrange
            String aString = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ";

            // Act
            String actualChangeHankakuToZenkakuResult = Strings2.changeHankakuToZenkaku(aString);

            // Assert
            String expectedChangeHankakuToZenkakuResult = "カキクケコサシスセソタチツテトハヒフヘホ";
            assertEquals(expectedChangeHankakuToZenkakuResult, actualChangeHankakuToZenkakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeZenkakuToHankaku(String)}
         */
        @Test
        void testChangeZenkakuToHankaku() {
            // Arrange
            String targetString = "Target String";

            // Act
            String actualChangeZenkakuToHankakuResult = Strings2.changeZenkakuToHankaku(
                targetString);

            // Assert
            String expectedChangeZenkakuToHankakuResult = "Target String";
            assertEquals(expectedChangeZenkakuToHankakuResult, actualChangeZenkakuToHankakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeZenkakuToHankaku(String)}
         */
        @Test
        @Disabled("TODO: Complete this test")
        void testChangeZenkakuToHankaku2() {
            // TODO: Complete this test.
            //   Reason: R013 No inputs found that don't throw a trivial exception.
            //   Diffblue Cover tried to run the arrange/act section, but the method under
            //   test threw
            //   java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
            //       at java.lang.AbstractStringBuilder.<init>(AbstractStringBuilder.java:105)
            //       at java.lang.StringBuffer.<init>(StringBuffer.java:158)
            //       at org.venusPj.primitive.string.Strings2.zenkakuToHankakuTokubetsuHenkan(Strings2.java:2063)
            //       at org.venusPj.primitive.string.Strings2.changeZenkakuToHankaku(Strings2.java:2013)
            //   See https://diff.blue/R013 to resolve this issue.

            // Arrange
            String targetString = null;

            // Act
            Strings2.changeZenkakuToHankaku(targetString);
        }

        /**
         * Method under test: {@link Strings2#changeZenkakuToHankaku(String)}
         */
        @Test
        void testChangeZenkakuToHankaku3() {
            // Arrange
            String targetString = "引数emptySupplierがnullです。null以外の値を指定してください";

            // Act
            String actualChangeZenkakuToHankakuResult = Strings2.changeZenkakuToHankaku(
                targetString);

            // Assert
            String expectedChangeZenkakuToHankakuResult = "引数emptySupplierがnullです。null以外の値を指定してください";
            assertEquals(expectedChangeZenkakuToHankakuResult, actualChangeZenkakuToHankakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeZenkakuToHankaku(String)}
         */
        @Test
        void testChangeZenkakuToHankaku4() {
            // Arrange
            String targetString = "．";

            // Act
            String actualChangeZenkakuToHankakuResult = Strings2.changeZenkakuToHankaku(
                targetString);

            // Assert
            String expectedChangeZenkakuToHankakuResult = ".";
            assertEquals(expectedChangeZenkakuToHankakuResult, actualChangeZenkakuToHankakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeZenkakuToHankaku(String)}
         */
        @Test
        void testChangeZenkakuToHankaku5() {
            // Arrange
            String targetString = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ";

            // Act
            String actualChangeZenkakuToHankakuResult = Strings2.changeZenkakuToHankaku(
                targetString);

            // Assert
            String expectedChangeZenkakuToHankakuResult = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ";
            assertEquals(expectedChangeZenkakuToHankakuResult, actualChangeZenkakuToHankakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeZenkakuToHankaku(String)}
         */
        @Test
        void testChangeZenkakuToHankaku6() {
            // Arrange
            String targetString = "Target String．";

            // Act
            String actualChangeZenkakuToHankakuResult = Strings2.changeZenkakuToHankaku(
                targetString);

            // Assert
            String expectedChangeZenkakuToHankakuResult = "Target String.";
            assertEquals(expectedChangeZenkakuToHankakuResult, actualChangeZenkakuToHankakuResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkakuKigou(String)}
         */
        @Test
        void testChangeHankakuToZenkakuKigou() {
            // Arrange
            String string = "String";

            // Act
            String actualChangeHankakuToZenkakuKigouResult = Strings2.changeHankakuToZenkakuKigou(
                string);

            // Assert
            String expectedChangeHankakuToZenkakuKigouResult = "String";
            assertEquals(expectedChangeHankakuToZenkakuKigouResult,
                actualChangeHankakuToZenkakuKigouResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkakuKigou(String)}
         */
        @Test
        void testChangeHankakuToZenkakuKigou2() {
            // Arrange
            String string = null;

            // Act
            String actualChangeHankakuToZenkakuKigouResult = Strings2.changeHankakuToZenkakuKigou(
                string);

            // Assert
            String expectedChangeHankakuToZenkakuKigouResult = null;
            assertEquals(expectedChangeHankakuToZenkakuKigouResult,
                actualChangeHankakuToZenkakuKigouResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkakuKigou(String)}
         */
        @Test
        void testChangeHankakuToZenkakuKigou3() {
            // Arrange
            String string = ".";

            // Act
            String actualChangeHankakuToZenkakuKigouResult = Strings2.changeHankakuToZenkakuKigou(
                string);

            // Assert
            String expectedChangeHankakuToZenkakuKigouResult = "．";
            assertEquals(expectedChangeHankakuToZenkakuKigouResult,
                actualChangeHankakuToZenkakuKigouResult);
        }

        /**
         * Method under test: {@link Strings2#changeHankakuToZenkakuKigou(String)}
         */
        @Test
        void testChangeHankakuToZenkakuKigou4() {
            // Arrange
            String string = "String.";

            // Act
            String actualChangeHankakuToZenkakuKigouResult = Strings2.changeHankakuToZenkakuKigou(
                string);

            // Assert
            String expectedChangeHankakuToZenkakuKigouResult = "String．";
            assertEquals(expectedChangeHankakuToZenkakuKigouResult,
                actualChangeHankakuToZenkakuKigouResult);
        }

        /**
         * Method under test: {@link Strings2#concat(String[])}
         */
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
            String string = null;
            String[] strings = new String[]{string};

            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> Strings2.concat(strings));
        }

        /**
         * Method under test: {@link Strings2#concat(String[])}
         */
        @Test
        void testConcat3() {
            // Arrange
            String[] strings = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class, () -> Strings2.concat(strings));
        }
    }
}

