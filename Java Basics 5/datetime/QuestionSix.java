package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class QuestionSix {
    public static void main(final String[] args) {
        // Use this dates month
        final LocalDate date = LocalDate.now();

        LocalDate tempDate = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        while (tempDate.getMonth() == date.getMonth()) {
            System.out.println(tempDate);
            tempDate = tempDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
    }
}
