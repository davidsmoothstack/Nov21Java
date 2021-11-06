package lambdas;

import java.util.Arrays;

public class QuestionOne {

    public static void main(String[] args) {
        var words = "Earl and Edward have eaten the most egregious eggs I've ever lain my eyes on"
                .toLowerCase()
                .split("\s+");

        // Sorted by length ascending
        Arrays.sort(words, (s1, s2) -> s1.length() > s2.length() ? 1 : -1);
        printArray(words);

        // Sorted by length descending
        Arrays.sort(words, (s1, s2) -> s1.length() > s2.length() ? -1 : 1);
        printArray(words);

        // Alphabetically sorted ascending
        Arrays.sort(words, (s1, s2) -> s1.charAt(0) > s2.charAt(0) ? 1 : -1);
        printArray(words);

        Arrays.sort(words, (s1, s2) -> s1.charAt(0) == 'e' ? -1 : 0);
        printArray(words);

        Arrays.sort(words, QuestionOne::sortEFirstUtility);
        printArray(words);
    }

    public static Integer sortEFirstUtility(String string1, String string2) {
        if (string1.charAt(0) == 'e')
            return -1;

        return 0;
    }

    public static <T> void printArray(T[] arr) {
        System.out.println();

        for (var item : arr) {
            System.out.println(item);
        }
    }
}