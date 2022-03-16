package Hibernate.HibernateDAO;

import Hibernate.EntityHibernate.ShoppingCartHibernate;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartHibernateDAO {
    //create
    void add(ShoppingCartHibernate shoppingCartHibernate) throws SQLException;
    //read
    List<ShoppingCartHibernate> getAll() throws SQLException;

    ShoppingCartHibernate getById(int idShoppingCart) throws SQLException;
    //update
    void update(ShoppingCartHibernate shoppingCartHibernate) throws SQLException;
    //delete
    void remove(ShoppingCartHibernate shoppingCartHibernate) throws SQLException;
}
