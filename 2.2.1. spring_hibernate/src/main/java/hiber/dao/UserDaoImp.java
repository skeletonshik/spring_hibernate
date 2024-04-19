package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
     sessionFactory.getCurrentSession().save(user);
   }
   public void addCarUser(User user, Car car)   {
      EntityManager manager = sessionFactory.createEntityManager();
      manager.persist(user);
      car.setUser(user);
      manager.persist(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
      String hql = "from User user where user.car.model = :model and user.car.series = :series";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("model" , model).setParameter("series", series);
      return query.getSingleResult();
   }

   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }


}
