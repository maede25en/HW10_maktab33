package view;

import config.BeanConfig;
import dao.OperationLogDao;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.userService.Registration;

public class Main {
    public static User user;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Registration registration = context.getBean(Registration.class);
        user = registration.signIn();
        OperationLogDao operationLogDao = context.getBean(OperationLogDao.class);
        operationLogDao.login(user, "login");
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1)Items");
            System.out.println("2)Add Order");
            System.out.println("3)Show your orders");
            System.out.println("4)Delete order with id");
            System.out.println("5)sorted orders by price");
            System.out.println("6)purchase");
            System.out.println("7)exit");
            System.out.println("--------------------------");
            OnlineShopMenu.execute();
        }
    }
}