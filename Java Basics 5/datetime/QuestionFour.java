package datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class QuestionFour {
    public static void main(final String[] args) {
        final Instant reference = Instant.now();

        // Instant to zone
        final ZonedDateTime zone = reference.atZone(ZoneId.of("Asia/Tokyo"));

        // Zone to instant
        final Instant instant = zone.toInstant();
    }
}
