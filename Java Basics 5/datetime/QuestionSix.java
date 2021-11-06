package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class QuestionSix {
    public static void main(String[] args) {
        // Use this dates month
        var date = LocalDate.now();

        var tempDate = date.withDayOfMonth(1);

        while (tempDate.getMonth() == date.getMonth()) {
            if (tempDate.getDayOfWeek() == DayOfWeek.MONDAY)
                System.out.println(tempDate);

            tempDate = tempDate.plusDays(1);
        }
    }
}
