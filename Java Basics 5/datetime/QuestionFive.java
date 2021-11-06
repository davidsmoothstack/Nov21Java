package datetime;

import java.io.PrintStream;
import java.time.LocalDate;

public class QuestionFive {
    public static void main(final String[] args) {
        final var year = 1998;
        final var date = LocalDate.of(year, 1, 1);

        var tempDate = date;

        while (tempDate.getYear() == date.getYear()) {
            final var monthName = tempDate.getMonth();
            final var monthDays = tempDate.lengthOfMonth();

            System.out.printf("%s has %d days\n", monthName, monthDays);

            tempDate = tempDate.plusMonths(1);
        }
    }
}
