package datetime;

import java.time.LocalDate;

public class QuestionFive {
    public static void main(String[] args) {
        var year = 1998;
        var date = LocalDate.of(year, 1, 1);

        var tempDate = date;

        while (tempDate.getYear() == date.getYear()) {
            var monthName = tempDate.getMonth();
            var monthDays = tempDate.lengthOfMonth();

            System.out.println(String.format("%s has %d days", monthName, monthDays));

            tempDate = tempDate.plusMonths(1);
        }
    }
}
