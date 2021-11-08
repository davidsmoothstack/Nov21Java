package assignment.four.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import assignment.four.Assessment;

@RunWith(Parameterized.class)
public class AssessmentTests {
    private final Collection<String> input;
    private final Collection<String> expected;

    public AssessmentTests(Collection<String> input, Collection<String> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> testData() {
        // List of Object[] that contain the input and expected result respectively
        return List.of(
                new Object[]{
                        Arrays.asList("ax", "bb", "cx"),
                        Arrays.asList("a", "bb", "c")
                },
                new Object[]{
                        Arrays.asList("xxax", "xbxbx", "xxcx"),
                        Arrays.asList("a", "bb", "c")
                },
                new Object[]{
                        Arrays.asList("x"),
                        Arrays.asList("")
                }
        );
    }

    @Test
    public void removeLetterX_returns_stringsWithoutLetterX() {
        String[] actual = Assessment.removeLetterX(input)
                .toArray(String[]::new);

        Assert.assertArrayEquals(expected.toArray(), actual);
    }
}
