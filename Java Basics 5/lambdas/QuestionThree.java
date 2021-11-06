package lambdas;

import java.util.Arrays;
import java.util.Collection;

public class QuestionThree {
    public static void main(final String[] args) {
        final var result = QuestionThree.getQualifiedElements("All the apples are named Ann or Abe");

        for (final var item : result) {
            System.out.println(item);
        }
    }

    // Qualified elements must start with the letter "a" and be 3 characters long
    public static Collection<String> getQualifiedElements(final String input) {
        return Arrays.stream(input.split("\s+"))
                .map(String::toLowerCase)
                .filter(word -> word.charAt(0) == 'a')
                .filter(word -> word.length() == 3)
                .toList();
    }
}
