package assignment.two.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import assignment.two.Assessment;

@RunWith(Parameterized.class)
public class AssessmentTests {
    private final Collection<Integer> input;
    private final Collection<Integer> expected;

    public AssessmentTests(Collection<Integer> input, Collection<Integer> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> testData() {
        // List of Object[] that contain the input and expected result respectively
        return List.of(
                new Object[]{
                        Arrays.asList(11, 22, 93),
                        Arrays.asList(1, 2, 3)
                },
                new Object[]{
                        Arrays.asList(16, 8, 886, 8, 1),
                        Arrays.asList(6, 8, 6, 8, 1)
                },
                new Object[]{
                        Arrays.asList(10, 0),
                        Arrays.asList(0, 0)
                }
        );
    }

    @Test
    public void getRightMostDigit_returns_theRightMostDigits() {
        Integer[] actual = Assessment.getRightMostDigit(input)
                .toArray(Integer[]::new);

        Assert.assertArrayEquals(expected.toArray(), actual);
    }
}
