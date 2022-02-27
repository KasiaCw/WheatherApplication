package pl.sda.wheatherApplication.location;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationDTO createlocation(LocationDTO requstBody) {
        Location location = mapToEntity(requstBody);
        location = locationRepository.save(location);
        return mapToDto(location);
    }

    private LocationDTO mapToDto(Location location) {
        return LocationDTO.builder()
                .city(location.getCity())
                .id(location.getId())
                .country(location.getCountry())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .region(location.getRegion())
                .build();
    }

    private Location mapToEntity(LocationDTO locationDTO) {
        return Location.builder()
                .city(locationDTO.getCity())
                .id(locationDTO.getId())
                .country(locationDTO.getCountry())
                .latitude(locationDTO.getLatitude())
                .longitude(locationDTO.getLongitude())
                .region(locationDTO.getRegion())
                .build();
    }


}
