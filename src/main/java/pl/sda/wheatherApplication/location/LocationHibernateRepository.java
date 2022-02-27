package pl.sda.wheatherApplication.location;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class LocationHibernateRepository implements LocationRepository{
    private final SessionFactory sessionFactory;

    @Override
    public Location save(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(location);
        transaction.commit();
        session.close();
        return location;
    }
}
