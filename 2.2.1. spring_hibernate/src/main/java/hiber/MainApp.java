package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      userService.add("Vovchik", "Vovanov", "Lexa@mail.ru", "BMW",5600);
      userService.add("Lexa", "lexov", "Austr@mail.ru", "Lada", 12);
      userService.add("Gosha", "Gachivar", "Bebey@mail.ru", "Lenovo", 6);


      System.out.println(userService.findUserByCar("Lenovo", 6));
      System.out.println(userService.findUserByCar("BMW", 5600));
   }
}
