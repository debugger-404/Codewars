package kyu_7.simple_consecutive_pairs.java;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void basicTests() {
        assertEquals(3, Solution.solve(new int[]{1, 2, 5, 8, -4, -3, 7, 6, 5}));
        assertEquals(2, Solution.solve(new int[]{21, 20, 22, 40, 39, -56, 30, -55, 95, 94}));
        assertEquals(0, Solution.solve(new int[]{81, 44, 80, 26, 12, 27, -34, 37, -35}));
        assertEquals(4, Solution.solve(new int[]{-55, -56, -7, -6, 56, 55, 63, 62}));
    }
}
