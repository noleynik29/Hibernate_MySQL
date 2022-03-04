package Hibernate.HibernateDAO;

import Hibernate.EntityHibernate.ProductHibernate;

import java.sql.SQLException;
import java.util.List;

public interface ProductHibernateDAO {
    //create
    void add(ProductHibernate productHibernate) throws SQLException;
    //read
    List<ProductHibernate> getAll() throws SQLException;

    ProductHibernate getById(int idProduct) throws SQLException;
    //update
    void update(ProductHibernate productHibernate) throws SQLException;
    //delete
    void remove(ProductHibernate productHibernate) throws SQLException;
}
