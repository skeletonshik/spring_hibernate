package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.JoinColumn;
import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);


      User user1 = new User("Vovchik", "Vovanov", "Lexa@mail.ru",
              new Car("BMW",5600));
      User user2 = new User("Lexa", "lexov", "Austr@mail.ru",
              new Car("Lada", 12));
      User user3 = new User("Gosha", "Gachivar", "Bebey@mail.ru",
              new Car("Lenovo", 6));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      System.out.println(userService.findUserByCar("Lenovo", 6));
      System.out.println(userService.findUserByCar("BMW", 5600));
   }
}
