package intervals.boundary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ActivitySummary(
        String type,
        BigDecimal icu_atl,
        BigDecimal icu_ctl,
        BigDecimal icu_training_load,
        BigDecimal icu_rolling_ftp,
        BigDecimal icu_weighted_avg_watts,
        BigDecimal icu_average_watts,
        BigDecimal icu_variability_index,
        BigDecimal icu_intensity,
        BigDecimal average_heartrate,
        BigDecimal max_heartrate,
        BigDecimal average_cadence,
        BigDecimal icu_efficiency_factor,
        BigDecimal decoupling,
        ZoneTime icu_zone_times,
        List<BigDecimal> icu_hr_zone_times,
        BigDecimal moving_time,
        BigDecimal distance,
        BigDecimal total_elevation_gain ,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime start_date_local,
        BigDecimal average_temp,
        BigDecimal carbs_used,
        BigDecimal perceived_exertion,
        BigDecimal feel
) {
}
