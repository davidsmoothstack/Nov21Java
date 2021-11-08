package assignment.two;

import java.util.Collection;

public class Assessment {
    public static Collection<Integer> getRightMostDigit(Collection<Integer> numbers) {
        return numbers.stream()
                .map(n -> n % 10)
                .toList();
    }
}
