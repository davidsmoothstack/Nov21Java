package lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionTwo {
    static final Random rng = new Random();

    public static void main(final String[] args) {
        final List<Integer> intCollection = Arrays.stream(new Integer[30]).map(i -> QuestionTwo.rng.nextInt(99)).toList();
        final String output = QuestionTwo.generateIntString(intCollection);

        System.out.println(output);
    }

    public static String generateIntString(final Collection<Integer> collection) {
        return collection.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(Collectors.joining(","));
    }
}
