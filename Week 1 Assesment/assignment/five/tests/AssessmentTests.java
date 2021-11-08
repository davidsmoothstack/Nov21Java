package assignment.five.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import assignment.five.Assessment;

@RunWith(Parameterized.class)
public class AssessmentTests {
    private final List<Integer> input;
    private final Integer target;
    private final Boolean expected;

    public AssessmentTests(List<Integer> input, Integer target, Boolean expected) {
        this.input = input;
        this.target = target;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> testData() {
        // List of Object[] that contain the input, target value and expected result respectively
        return List.of(
                new Object[]{ Arrays.asList(1, 1, 2, 1, 1), 3, false },
                new Object[]{ Arrays.asList(1, 1, 2, 1, 1), 6, true },
                new Object[]{ Arrays.asList(2, 4, 8), 10, true },
                new Object[]{ Arrays.asList(1, 2, 4, 8, 1), 14, true },
                new Object[]{ Arrays.asList(2, 4, 4, 8), 14, false }
        );
    }

    @Test
    public void groupSumClump_returns_true_whenClumpIsPossible() {
        Boolean actual = Assessment.groupSumClump(0, input, target);

        Assert.assertEquals(expected, actual);
    }
}


