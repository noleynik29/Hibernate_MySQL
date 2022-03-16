package Hibernate.ServiceHibernate;

import Hibernate.EntityHibernate.OrderHibernate;
import Hibernate.EntityHibernate.UserHibernate;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceHibernateTest {

    private static OrderServiceHibernate orderServiceHibernate = new OrderServiceHibernate();
    private static UserHibernate userHibernate = new UserHibernate();

    @Test
    void add() throws SQLException {
        OrderHibernate orderHibernate = new OrderHibernate();
        orderHibernate.setIdOrder(20);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        orderHibernate.setDatetime(dateFormat.format(date));
        orderHibernate.setTotal_price(120);
        orderHibernate.setUserHibernate(userHibernate);

        orderServiceHibernate.add(orderHibernate);

        OrderHibernate orderFromDB = orderServiceHibernate.getById(20);
        assertEquals(120, orderFromDB.getTotal_price());
        assertEquals(userHibernate, orderFromDB.getUserHibernate());
    }

    @Test
    void getAll() throws SQLException {
        List<OrderHibernate> ordersList = orderServiceHibernate.getAll();
        assertEquals(19, ordersList.size());
    }

    @Test
    void getById() throws SQLException {
        OrderHibernate orderFromDB = orderServiceHibernate.getById(20);
        assertEquals(120, orderFromDB.getTotal_price());
        assertEquals(userHibernate, orderFromDB.getUserHibernate());
    }

    @Test
    void remove() throws SQLException {
        OrderHibernate orderFromDB = orderServiceHibernate.getById(20);
        orderServiceHibernate.remove(orderFromDB);
        assertNull(orderServiceHibernate.getById(20));
    }
}