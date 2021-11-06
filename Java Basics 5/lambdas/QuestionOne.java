package lambdas;

import java.util.Arrays;

public class QuestionOne {

    public static void main(final String[] args) {
        final var words = "Earl and Edward have eaten the most egregious eggs I've ever lain my eyes on"
                .toLowerCase()
                .split("\s+");

        // Sorted by length ascending
        Arrays.sort(words, (s1, s2) -> s1.length() > s2.length() ? 1 : -1);
        QuestionOne.printArray(words, "Sorted by length ascending");

        // Sorted by length descending
        Arrays.sort(words, (s1, s2) -> s1.length() > s2.length() ? -1 : 1);
        QuestionOne.printArray(words, "Sorted by length descending");

        // Alphabetically sorted ascending
        Arrays.sort(words, (s1, s2) -> s1.charAt(0) > s2.charAt(0) ? 1 : -1);
        QuestionOne.printArray(words, "Alphabetically sorted ascending");

        // Letters that start with "e" sorted first
        Arrays.sort(words, (s1, s2) -> s1.charAt(0) == 'e' ? -1 : 0);
        QuestionOne.printArray(words, "Letters that start with e sorted first");

        // Letters that start with e sorted first
        Arrays.sort(words, QuestionOne::sortEFirstUtility);
        QuestionOne.printArray(words, "Letters that start with e sorted first with utility method");
    }

    public static Integer sortEFirstUtility(final String string1, final String string2) {
        if (string1.charAt(0) == 'e')
            return -1;

        return 0;
    }

    public static <T> void printArray(final T[] arr, final String comment) {
        System.out.println();
        System.out.println(comment);

        for (final var item : arr) {
            System.out.println(item);
        }
    }
}