package lambdas;

import java.util.Arrays;

public class QuestionThree {
    public static void main(String[] args) {
        Arrays.stream("All the apples are named Ann or Abe".split("\s+"))
                .map(word -> word.toLowerCase())
                .filter(word -> word.charAt(0) == 'a')
                .filter(word -> word.length() == 3)
                .forEach(word -> System.out.println(word));
    }
}
