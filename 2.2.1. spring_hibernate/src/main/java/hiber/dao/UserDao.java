package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   public void addCarUser(User user, Car car);
   List<User> listUsers();
   User getUserByCar(String model, int series);
   void addCar(Car car);
   public User findUserByCar(String model, int series);
}
