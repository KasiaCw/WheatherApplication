package pl.sda.wheatherApplication.location;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table
@Builder
public class Location {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(nullable = false)
    private String city;
    private float longitude;
    private float latitude;
    private String country;
    private String region;


    public Location(Long id, String city, float longitude, float latitude, String country, String region) {
        this.id = id;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
        this.region = region;
    }
}
