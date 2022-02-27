package pl.sda.wheatherApplication;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.sda.wheatherApplication.location.LocationController;
import pl.sda.wheatherApplication.location.LocationHibernateRepository;
import pl.sda.wheatherApplication.location.LocationRepository;
import pl.sda.wheatherApplication.location.LocationService;

public class Application {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LocationRepository locationRepository = new LocationHibernateRepository(sessionFactory);
        LocationService locationService = new LocationService(locationRepository);
        LocationController controller = new LocationController(locationService, objectMapper);
        UserInterface userInterface = new UserInterface(controller);
        userInterface.run();
    }
}
