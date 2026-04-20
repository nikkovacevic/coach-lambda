package intervals.control;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class IntervalsServiceTest {

    @Inject
    IntervalsService intervalsService;

    @Test
    public void testGetPastWeeksRides() {
        var activities = intervalsService.getPastWeeksRides();
        assertNotNull(activities, "Activities list should not be null");
    }
}