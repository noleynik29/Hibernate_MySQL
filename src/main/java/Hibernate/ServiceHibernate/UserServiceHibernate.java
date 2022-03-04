package Hibernate.ServiceHibernate;

import BusinessLogic.SessionUtil;
import Hibernate.EntityHibernate.UserHibernate;
import Hibernate.HibernateDAO.UserHibernateDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserServiceHibernate extends SessionUtil implements UserHibernateDAO {
    @Override
    public void add(UserHibernate userHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(userHibernate);

        closeTransactionSession();
    }

    @Override
    public List<UserHibernate> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM `user`";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(UserHibernate.class);
        List<UserHibernate> userHibernateList = query.list();

        closeTransactionSession();
        return userHibernateList;
    }

    @Override
    public UserHibernate getById(int idUser) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM `user` WHERE idUser = :idUSer";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(UserHibernate.class);
        query.setParameter("idUSer", idUser);

        UserHibernate userHibernate = (UserHibernate) query.getSingleResult();

        closeTransactionSession();
        return userHibernate;
    }

    @Override
    public void update(UserHibernate userHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(userHibernate);

        closeTransactionSession();
    }

    @Override
    public void remove(UserHibernate userHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(userHibernate);

        closeTransactionSession();
    }
}
