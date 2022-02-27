package pl.sda.wheatherApplication;

import lombok.RequiredArgsConstructor;
import pl.sda.wheatherApplication.location.LocationController;


import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface {

    private LocationController locationController;
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("STARTUJEMY\n");

        while (true) {
            System.out.println("Startujemy z info o pogodzie, co chcesz zrobić?");
            System.out.println("0. Kończymy na dziś");
            System.out.println("1. Utwórz lokalizację");

            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    return;
                case 1:
                    createLocation();
                    break;
            }
        }
    }

    private void createLocation() {
        String requestJson = readLocationFromUser();

        String response = this.locationController.createLocation

               (requestJson);
        System.out.println("Zapisana lokalizacja to: " + response);
    }

    private String readLocationFromUser() {
        System.out.println("Podaj nazwę miasta: ");
        String city = scanner.nextLine();
        System.out.println("Podaj długość georaficzną: ");
        float longitude = scanner.nextFloat();
        System.out.println("Podaj szerokość geograficzną: ");
        float latitude = scanner.nextFloat();
        System.out.println("Podaj Kraj: ");
        String country = scanner.nextLine();
        System.out.println("Podaj region: ");
        String region = scanner.nextLine();
        String requestJson = """
                {
                       "city": "%s",
                       "longitude": %s,
                       "latitude": %s,
                       "country": "%s",
                       "region": "%s",
                }
                """.formatted(
                city,
                longitude,
                latitude,
                country,
                region
        );
        return requestJson;
    }


}
