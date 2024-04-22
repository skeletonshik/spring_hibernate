package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    void add(User newUser);

    List<User> listUsers();

    User findUserByCar(String model, int series);
}
