import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TwitchApiService {
    @Value("${twitch.api.base-url}")
    private String twitchApiBaseUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public TwitchApiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    
    public AnalyticsData getStreamAnalytics(String streamerID) {
        String apiUrl = twitchApiBaseUrl + "/helix/analytics/stream";

        // make HTTP request to twitch API and parse response
        // implement logic to extract relevant analytics data
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = response.getBody();

        // parse
        try{
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            // extract relevant data from JSON
            int streamViews = jsonNode.get("streamViews").asInt();
            int chatActivity = jsonNode.get("chatActivity").asInt();
            int followerGrowth = jsonNode.get("followerGrowth").asInt();

            // create analysticsdata object
            return new AnalyticsData(streamViews, chatActivity, followerGrowth);
        } catch (Exception e) {
            e.printStackTrace();
            return new AnalyticsData();
        }

    }
}