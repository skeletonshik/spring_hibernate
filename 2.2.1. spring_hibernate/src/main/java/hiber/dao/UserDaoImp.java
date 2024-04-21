package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void add(String name, String lastName, String email, String car_model, int series) {
        User newUSer = new User(name, lastName, email);
        entityManager.persist(newUSer);
        Car car = new Car(car_model, series);
        car.setUser(newUSer);
        entityManager.persist(car);
        entityManager.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findUserByCar(String model, int series) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(
                "SELECT car.user FROM Car car WHERE car.model = :model AND car.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);

        return query.getSingleResult();
    }
}
