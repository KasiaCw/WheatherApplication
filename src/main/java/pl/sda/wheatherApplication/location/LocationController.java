package pl.sda.wheatherApplication.location;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final ObjectMapper objectMapper;

    //POST:/locations
    public String createLocation(String data){
        try {
            LocationDTO requstBody = objectMapper.readValue(data,LocationDTO.class);
            LocationDTO savedLoction = locationService.createlocation(requstBody);
            return objectMapper.writeValueAsString(savedLoction);
        } catch (Exception e) {
            return String.format("{\"message\":\"%s\"}", e.getMessage());
        }
    }

}
