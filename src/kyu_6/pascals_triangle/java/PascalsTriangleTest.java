package kyu_6.pascals_triangle.java;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PascalsTriangleTest {
    @Test
    public void testOneLevelTriangle() {
        final long[] terms = { 1L };
        assertThat(PascalsTriangle.generate(1), is(terms));
    }

    @Test
    public void testTwoLevelsTriangle() {
        final long[] terms = { 1L, 1L, 1L };
        assertThat(PascalsTriangle.generate(2), is(terms));
    }

    @Test
    public void testFourLevelsTriangle() {
        final long[] terms = { 1L, 1L, 1L, 1L, 2L, 1L, 1L, 3L, 3L, 1L };
        assertThat(PascalsTriangle.generate(4), is(terms));
    }
}