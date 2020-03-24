package pl.coderstrust.maximum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMaximumTest {


    @Test
    void shouldFindMaximumValue() {
        // Given
        FindMaximum maximum = new FindMaximum();
        int[] input = {3, 5, 2, 7};

        // When
        int maximumValue = maximum.find(input);

        // Then
        Assertions.assertEquals(7, maximumValue);
    }

}
