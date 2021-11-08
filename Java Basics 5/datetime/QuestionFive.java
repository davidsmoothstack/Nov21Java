package datetime;

import java.time.LocalDate;
import java.time.Month;

public class QuestionFive {
    public static void main(final String[] args) {
        final int year = 1998;
        final LocalDate date = LocalDate.of(year, 1, 1);

        LocalDate tempDate = date;

        while (tempDate.getYear() == date.getYear()) {
            final Month monthName = tempDate.getMonth();
            final int monthDays = tempDate.lengthOfMonth();

            System.out.printf("%s has %d days\n", monthName, monthDays);

            tempDate = tempDate.plusMonths(1);
        }
    }
}
