package intervals.boundary;

import java.math.BigDecimal;

public record ZoneTime(
        String id,
        BigDecimal secs
) {
}
