package Hibernate.ServiceHibernate;

import Hibernate.EntityHibernate.ProductHibernate;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceHibernateTest {

    private static ProductServiceHibernate productServiceHibernate = new ProductServiceHibernate();

    @Test
    void add() throws SQLException {
        ProductHibernate productHibernate = new ProductHibernate();
        productHibernate.setIdProduct(20);
        productHibernate.setName("Hollow Knight");
        productHibernate.setDescription("Game");
        productHibernate.setPrice(120);

        productServiceHibernate.add(productHibernate);

        ProductHibernate productFromDB = productServiceHibernate.getById(20);
        assertEquals("Hollow Knight", productFromDB.getName());
        assertEquals("Game", productFromDB.getDescription());
        assertEquals(120, productFromDB.getPrice());
    }

    @Test
    void getAll() throws SQLException {
        List<ProductHibernate> productList = productServiceHibernate.getAll();
        assertEquals(19, productList.size());
    }

    @Test
    void getById() throws SQLException {
        ProductHibernate productFromDB = productServiceHibernate.getById(20);
        assertEquals("Hollow Knight", productFromDB.getName());
        assertEquals("Game", productFromDB.getDescription());
        assertEquals(120, productFromDB.getPrice());
    }

    @Test
    void remove() throws SQLException {
        ProductHibernate productFromDB = productServiceHibernate.getById(20);
        productServiceHibernate.remove(productFromDB);
        assertNull(productServiceHibernate.getById(20));
    }
}