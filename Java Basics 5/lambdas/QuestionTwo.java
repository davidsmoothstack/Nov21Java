package lambdas;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionTwo {
    static Random rng = new Random();

    public static void main(String[] args) {
        var output = Arrays.stream(new Integer[30])
                .map(i -> rng.nextInt(99))
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(Collectors.joining(","));

        System.out.println(output);
    }
}
