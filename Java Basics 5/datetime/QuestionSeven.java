package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class QuestionSeven {
    public static void main(String[] args) {
        var fridayThirteen = LocalDate.of(2021, 8, 13);
        var notFridayThirteen = LocalDate.of(2021, 8, 14);

        // True
        System.out.println(isFridayTheThirteenth(fridayThirteen));

        // False
        System.out.println(isFridayTheThirteenth(notFridayThirteen));
    }

    public static Boolean isFridayTheThirteenth(LocalDate date) {
        if (date.getDayOfMonth() == 13
                && date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return true;
        }

        return false;
    }
}
