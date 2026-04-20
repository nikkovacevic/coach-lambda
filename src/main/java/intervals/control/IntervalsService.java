package intervals.control;

import intervals.boundary.ActivitySummary;
import intervals.boundary.IntervalsClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@ApplicationScoped
public class IntervalsService {

    private final List<String> listOfFields = List.of(
            "type",
            "icu_atl",
            "icu_ctl",
            "icu_training_load",
            "icu_rolling_ftp",
            "icu_weighted_avg_watts",
            "icu_average_watts",
            "icu_variability_index",
            "icu_intensity",
            "average_heartrate",
            "max_heartrate",
            "average_cadence",
            "icu_efficiency_factor",
            "decoupling",
            "icu_zone_times",
            "icu_hr_zone_times",
            "moving_time",
            "distance",
            "total_elevation_gain",
            "start_date_local",
            "average_temp",
            "carbs_used",
            "perceived_exertion",
            "feel"
    );

    private final IntervalsClient intervalsClient;

    @Inject
    public IntervalsService(@RestClient IntervalsClient intervalsClient) {
        this.intervalsClient = intervalsClient;
    }

    public List<ActivitySummary> getPastWeeksRides() {
        LocalDate startOfCurrentWeek = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        List<ActivitySummary> activities = intervalsClient.getActivities(startOfCurrentWeek.toString(), listOfFields, 7);
        return activities.stream().filter(activitySummary -> "Ride".equals(activitySummary.type())).toList();
    }
}
