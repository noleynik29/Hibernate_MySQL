import BusinessLogic.HibernateUtil;
import Hibernate.EntityHibernate.OrderHibernate;
import Hibernate.EntityHibernate.ProductHibernate;
import Hibernate.EntityHibernate.ShoppingCartHibernate;
import Hibernate.EntityHibernate.UserHibernate;
import Hibernate.ServiceHibernate.OrderServiceHibernate;
import Hibernate.ServiceHibernate.ProductServiceHibernate;
import Hibernate.ServiceHibernate.ShoppingCartServiceHibernate;
import Hibernate.ServiceHibernate.UserServiceHibernate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        /*logger.info("Log4j2ExampleApp started.");
        logger.warn("Something to warn");
        logger.error("Something failed.");
        try {
            Files.readAllBytes(Paths.get("/file/does/not/exist"));
        } catch (IOException ioex) {
            logger.error("Error message", ioex);
        }*/ //log4j2

        OrderServiceHibernate orderServiceHibernate = new OrderServiceHibernate();
        ProductServiceHibernate productServiceHibernate = new ProductServiceHibernate();
        ShoppingCartServiceHibernate shoppingCartServiceHibernate = new ShoppingCartServiceHibernate();
        UserServiceHibernate userServiceHibernate = new UserServiceHibernate();

        UserHibernate userHibernate = new UserHibernate();
        userHibernate.setIdUser(12);
        userHibernate.setFirstName("George");
        userHibernate.setLastName("Miller2");

        ProductHibernate productHibernate = new ProductHibernate();
        productHibernate.setIdProduct(20);
        productHibernate.setName("Assassins creed");
        productHibernate.setDescription("Game");
        productHibernate.setPrice(75);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        OrderHibernate orderHibernate = new OrderHibernate();
        orderHibernate.setIdOrder(12);
        orderHibernate.setUserHibernate(userHibernate);
        orderHibernate.setDatetime(dateFormat.format(date));
        orderHibernate.setTotal_price(75);

        ShoppingCartHibernate shoppingCartHibernate = new ShoppingCartHibernate();
        shoppingCartHibernate.setProductHibernate(productHibernate);
        shoppingCartHibernate.setOrderHibernate(orderHibernate);
        shoppingCartHibernate.setOrder_quantity(1);

        try {
            userServiceHibernate.add(userHibernate);
            productServiceHibernate.add(productHibernate);
            orderServiceHibernate.add(orderHibernate);
            shoppingCartServiceHibernate.add(shoppingCartHibernate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HibernateUtil.shutDown();
    }
}
