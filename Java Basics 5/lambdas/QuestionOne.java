package lambdas;

import java.util.Arrays;

public class QuestionOne {

    public static void main(String[] args) {
        var words = "Earl and Edward have eaten the most egregious eggs I've ever lain my eyes on".split("\s+");

        // Sorted by length ascending
        var lengthAscending = Arrays.stream(words)
                .sorted((s1, s2) -> s1.length() > s2.length() ? 1 : -1)
                .toList();

        printIterable(lengthAscending, "Sorted by length ascending");

        // Sorted by length descending
        var lengthDescending = Arrays.stream(words)
                .sorted((s1, s2) -> s1.length() > s2.length() ? -1 : 1)
                .toList();

        printIterable(lengthDescending, "Sorted by length descending");

        // Alphabetically sorted ascending
        var alphabetical = Arrays.stream(words)
                .map(s -> s.toLowerCase())
                .sorted((s1, s2) -> s1.charAt(0) > s2.charAt(0) ? 1 : -1)
                .toList();

        printIterable(alphabetical, "Alphabetically sorted ascending");

        // Words that start with "e" sorted first
        var eFirst = Arrays.stream(words)
                .map(s -> s.toLowerCase())
                .sorted((s1, s2) -> s1.charAt(0) == 'e' ? -1 : 0)
                .toList();

        printIterable(eFirst, "E's first");

        // Words that start with "e" sorted first with a utility method
        var eFirstUtil = Arrays.stream(words)
                .map(s -> s.toLowerCase())
                .sorted(QuestionOne::sortEFirstUtility)
                .toList();

        printIterable(eFirstUtil, "E's first with a utility method");
    }

    public static Integer sortEFirstUtility(String string1, String string2) {
        if (string1.charAt(0) == 'e')
            return -1;

        return 0;
    }

    public static <T> void printIterable(Iterable<T> iterable, String comment) {
        System.out.println();
        System.out.println(comment + ": ");

        for (T itemT : iterable) {
            System.out.println(itemT);
        }
    }
}