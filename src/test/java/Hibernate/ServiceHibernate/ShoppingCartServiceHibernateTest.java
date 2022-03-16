package Hibernate.ServiceHibernate;

import Hibernate.EntityHibernate.OrderHibernate;
import Hibernate.EntityHibernate.ProductHibernate;
import Hibernate.EntityHibernate.ShoppingCartHibernate;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceHibernateTest {

    private static ShoppingCartServiceHibernate shoppingCartServiceHibernate = new ShoppingCartServiceHibernate();
    private static OrderHibernate orderHibernate = new OrderHibernate();
    private static ProductHibernate productHibernate = new ProductHibernate();

    @Test
    void add() throws SQLException {
        ShoppingCartHibernate shoppingCartHibernate = new ShoppingCartHibernate();
        shoppingCartHibernate.setIdShoppingCart(16);
        shoppingCartHibernate.setOrderHibernate(orderHibernate);
        shoppingCartHibernate.setProductHibernate(productHibernate);
        shoppingCartHibernate.setOrder_quantity(1);

        shoppingCartServiceHibernate.add(shoppingCartHibernate);

        ShoppingCartHibernate shoppingCartFromDB = shoppingCartServiceHibernate.getById(16);
        assertEquals(orderHibernate, shoppingCartFromDB.getOrderHibernate());
        assertEquals(productHibernate, shoppingCartFromDB.getProductHibernate());
        assertEquals(1, shoppingCartFromDB.getOrder_quantity());
    }

    @Test
    void getAll() throws SQLException {
        List<ShoppingCartHibernate> shoppingCartList = shoppingCartServiceHibernate.getAll();
        assertEquals(15, shoppingCartList.size());
    }

    @Test
    void getById() throws SQLException {
        ShoppingCartHibernate shoppingCartFromDB = shoppingCartServiceHibernate.getById(16);
        assertEquals(orderHibernate, shoppingCartFromDB.getOrderHibernate());
        assertEquals(productHibernate, shoppingCartFromDB.getProductHibernate());
        assertEquals(1, shoppingCartFromDB.getOrder_quantity());
    }

    @Test
    void remove() throws SQLException {
        ShoppingCartHibernate shoppingCartFromDB = shoppingCartServiceHibernate.getById(16);
        shoppingCartServiceHibernate.remove(shoppingCartFromDB);
        assertNull(shoppingCartServiceHibernate.getById(16));
    }
}