package datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class QuestionFour {
    public static void main(final String[] args) {
        // Instant to zone
        final Instant instant = Instant.now();
        final ZonedDateTime zone = instant.atZone(ZoneId.of("Asia/Tokyo"));

        // Zone to instant
        zone.toInstant();
    }
}
