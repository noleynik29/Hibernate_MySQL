package Hibernate.HibernateDAO;

import Hibernate.EntityHibernate.OrderHibernate;

import java.sql.SQLException;
import java.util.List;

public interface OrderHibernateDAO {
    //create
    void add(OrderHibernate orderHibernate) throws SQLException;
    //read
    List<OrderHibernate> getAll() throws SQLException;

    OrderHibernate getById(int idOrder) throws SQLException;
    //update
    void update(OrderHibernate orderHibernate) throws SQLException;
    //delete
    void remove(OrderHibernate orderHibernate) throws SQLException;
}
