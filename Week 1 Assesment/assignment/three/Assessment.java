package assignment.three;

import java.util.Collection;

public class Assessment {
    public static Collection<Integer> multiplyByTwo(Collection<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * 2)
                .toList();
    }
}
