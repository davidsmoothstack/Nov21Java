package assignment.four;

import java.util.Collection;

public class Assessment {
    public static Collection<String> removeLetterX(Collection<String> stringCollection) {
        var intStreams = stringCollection.stream()
                .map(Assessment::filterOutX)
                .toList();

        return intStreams;
    }

    private static String filterOutX(String input) {
        var charStream = input.chars().toArray();
        var builder = new StringBuilder();

        for (int ch : charStream) {
            if (ch == 'x')
                continue;

            builder.append((char) ch);
        }

        return builder.toString();
    }
}
