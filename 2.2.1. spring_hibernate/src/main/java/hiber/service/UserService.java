package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    void add(String name, String lastName, String email, String car_model, int series);

    List<User> listUsers();

    User findUserByCar(String model, int series);
}
