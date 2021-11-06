package lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionTwo {
    static Random rng = new Random();

    public static void main(String[] args) {
        var intCollection = Arrays.stream(new Integer[30]).map(i -> rng.nextInt(99)).toList();
        var output = generateIntString(intCollection);

        System.out.println(output);
    }

    public static String generateIntString(Collection<Integer> collection) {

        return collection.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(Collectors.joining(","));
    }
}
