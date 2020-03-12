package pl.coderstrust.odd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {


    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 8, 10, 466})
    public void shouldVerifyIsEven(int input) {
        // When
        boolean isOdd = Numbers.isEven(input);

        // Then
        assertTrue(isOdd);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 11, 467})
    public void shouldVerifyIsOdd(int input) {
        // When
        boolean isOdd = Numbers.isEven(input);

        // Then
        assertFalse(isOdd);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, StringUtils.isBlank(input));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNegativeNumber() {
        // Given
        int input = -1;

        // Then
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.printTable(input));
        assertEquals("You cannot use negative number", thrown.getMessage());
    }

}