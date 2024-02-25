package kyu_7.round_up_to_the_next_multiple_of_5.java;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RoundToTheNextMultipleOf5Test {

    @Test
    public void basicTests() {
        int[][] arr = {
                {0, 0},
                {1, 5},
                {3, 5},
                {5, 5},
                {7, 10},
                {39, 40}
        };
        Arrays.stream(arr)
                .forEach(
                        (testCase) -> {
                            assertEquals(
                                    "Input: " + testCase[0],
                                    testCase[1],
                                    RoundToTheNextMultipleOf5.roundToNext5(testCase[0]));
                        });
    }
}