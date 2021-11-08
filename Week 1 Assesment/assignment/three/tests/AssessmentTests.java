package assignment.three.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import assignment.three.Assessment;

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
                new Object[]{ Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 6) },
                new Object[]{ Arrays.asList(6, 8, 6, 8, -1), Arrays.asList(12, 16, 12, 16, -2) },
                new Object[]{ Collections.emptyList(), Collections.emptyList() }
        );
    }

    @Test
    public void multiplyByTwo_multiplies_eachElementByTwo() {
        Integer[] actual = Assessment.multiplyByTwo(input)
                .toArray(Integer[]::new);

        Assert.assertArrayEquals(expected.toArray(), actual);
    }
}
