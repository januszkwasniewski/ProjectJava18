package pl.coderstrust.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SelectionSortTest {


    private static Stream<Arguments> arrays() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{4, 2, 1}),
                Arguments.of(new int[]{1, 2, 4}, new int[]{4, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    void shouldSortNumbers(int[] inputArray, int[] expectedOutput) {
        // When
        int[] realOutput = SelectionSort.sort(inputArray);

        // Then
        assertThat(realOutput, is(expectedOutput));

    }
}