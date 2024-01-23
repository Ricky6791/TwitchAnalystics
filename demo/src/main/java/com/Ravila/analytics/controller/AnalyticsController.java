import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    @Autowired
    private TwitchApiService twitchApiService;

    @GetMapping("/stream/{streamerId}")
    public ResponseEntity<AnalyticsData> getStreamAnalytics(@PathVariable String streamerId) {
        AnalyticsData analyticsData = twitchApiService.getStreamAnalytics(streamerId);
        return ResponseEntity.ok(analyticsData);
    }
}