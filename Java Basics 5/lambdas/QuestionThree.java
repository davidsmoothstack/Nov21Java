package lambdas;

import java.util.Arrays;
import java.util.Collection;

public class QuestionThree {
    public static void main(String[] args) {
        var result = getQualifiedElements("All the apples are named Ann or Abe");

        for (var item : result) {
            System.out.println(item);
        }
    }

    // Qualified elements must start with the letter "a" and be 3 characters long
    public static Collection<String> getQualifiedElements(String input) {
        return Arrays.stream(input.split("\s+"))
                .map(word -> word.toLowerCase())
                .filter(word -> word.charAt(0) == 'a')
                .filter(word -> word.length() == 3)
                .toList();
    }
}
