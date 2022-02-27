package pl.sda.wheatherApplication.location;

import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

     private Long id;
     private String city;
     private float longitude;
     private float latitude;
     private String country;
     private String region;
}
