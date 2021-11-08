package assignment.four;

import java.util.Collection;
import java.util.List;

public class Assessment {
    public static Collection<String> removeLetterX(Collection<String> stringCollection) {
        List<String> intStreams = stringCollection.stream()
                .map(Assessment::filterOutX)
                .toList();

        return intStreams;
    }

    private static String filterOutX(String input) {
        int[] charStream = input.chars().toArray();
        StringBuilder builder = new StringBuilder();

        for (int ch : charStream) {
            if (ch == 'x')
                continue;

            builder.append((char) ch);
        }

        return builder.toString();
    }
}
