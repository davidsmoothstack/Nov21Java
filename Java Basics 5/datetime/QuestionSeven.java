package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class QuestionSeven {
    public static void main(final String[] args) {
        final LocalDate fridayThirteen = LocalDate.of(2021, 8, 13);
        final LocalDate notFridayThirteen = LocalDate.of(2021, 8, 14);

        // True
        System.out.println(isFridayTheThirteenth(fridayThirteen));

        // False
        System.out.println(isFridayTheThirteenth(notFridayThirteen));
    }

    public static Boolean isFridayTheThirteenth(final LocalDate date) {
        return date.getDayOfMonth() == 13
                && date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }
}
