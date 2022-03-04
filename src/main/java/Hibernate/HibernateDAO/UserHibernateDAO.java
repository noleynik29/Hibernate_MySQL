package Hibernate.HibernateDAO;

import Hibernate.EntityHibernate.UserHibernate;

import java.sql.SQLException;
import java.util.List;

public interface UserHibernateDAO {
    //create
    void add(UserHibernate userHibernate) throws SQLException;
    //read
    List<UserHibernate> getAll() throws SQLException;

    UserHibernate getById(int idUser) throws SQLException;
    //update
    void update(UserHibernate userHibernate) throws SQLException;
    //delete
    void remove(UserHibernate userHibernate) throws SQLException;
}
