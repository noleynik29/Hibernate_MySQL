package Hibernate.ServiceHibernate;

import BusinessLogic.SessionUtil;
import Hibernate.EntityHibernate.ShoppingCartHibernate;
import Hibernate.HibernateDAO.ShoppingCartHibernateDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartServiceHibernate extends SessionUtil implements ShoppingCartHibernateDAO {
    @Override
    public void add(ShoppingCartHibernate shoppingCartHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(shoppingCartHibernate);

        closeTransactionSession();
    }

    @Override
    public List<ShoppingCartHibernate> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM shopping_cart";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ShoppingCartHibernate.class);
        List<ShoppingCartHibernate> shoppingCartHibernateList = query.list();

        closeTransactionSession();
        return shoppingCartHibernateList;
    }

    @Override
    public ShoppingCartHibernate getById(int idShoppingCart) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM shopping_cart WHERE idShoppingCart = :idShoppingCart";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ShoppingCartHibernate.class);
        query.setParameter("idShoppingCart", idShoppingCart);

        ShoppingCartHibernate shoppingCartHibernate = (ShoppingCartHibernate) query.getSingleResult();

        closeTransactionSession();
        return shoppingCartHibernate;
    }

    @Override
    public void update(ShoppingCartHibernate shoppingCartHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(shoppingCartHibernate);

        closeTransactionSession();
    }

    @Override
    public void remove(ShoppingCartHibernate shoppingCartHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(shoppingCartHibernate);

        closeTransactionSession();
    }
}
