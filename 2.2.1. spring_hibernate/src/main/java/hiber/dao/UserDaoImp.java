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


    @Override
    public void add(User newUser) {
        sessionFactory.getCurrentSession().save(newUser);
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
                "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);

        return query.getSingleResult();
    }
}
