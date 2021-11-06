package datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class QuestionFour {
    public static void main(String[] args) {
        // Instant to zone
        Instant instant = Instant.now();
        ZonedDateTime zone = instant.atZone(ZoneId.of("Asia/Tokyo"));

        // Zone to instant
        zone.toInstant();
    }
}
