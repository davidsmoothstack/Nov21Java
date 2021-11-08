package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class QuestionSix {
    public static void main(final String[] args) {
        // Use this dates month
        final LocalDate date = LocalDate.now();

        LocalDate tempDate = date.withDayOfMonth(1);

        while (tempDate.getMonth() == date.getMonth()) {
            if (tempDate.getDayOfWeek() == DayOfWeek.MONDAY)
                System.out.println(tempDate);

            tempDate = tempDate.plusDays(1);
        }
    }
}
