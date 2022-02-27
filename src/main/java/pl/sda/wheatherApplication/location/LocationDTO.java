package pl.sda.wheatherApplication.location;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class LocationDTO {

     Long id;
     String city;
     float longitude;
     float latitude;
     String country;
     String region;
}
