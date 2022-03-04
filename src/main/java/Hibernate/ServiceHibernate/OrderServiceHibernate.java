package Hibernate.ServiceHibernate;

import BusinessLogic.SessionUtil;
import Hibernate.EntityHibernate.OrderHibernate;
import Hibernate.HibernateDAO.OrderHibernateDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceHibernate extends SessionUtil implements OrderHibernateDAO {

    @Override
    public void add(OrderHibernate orderHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(orderHibernate);

        closeTransactionSession();
    }

    @Override
    public List<OrderHibernate> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM `order`";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(OrderHibernate.class);
        List<OrderHibernate> orderHibernateList = query.list();

        closeTransactionSession();
        return orderHibernateList;
    }

    @Override
    public OrderHibernate getById(int idOrder) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM `order` WHERE idOrder = :idOrder";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(OrderHibernate.class);
        query.setParameter("idOrder", idOrder);

        OrderHibernate orderHibernate = (OrderHibernate) query.getSingleResult();

        closeTransactionSession();
        return orderHibernate;
    }

    @Override
    public void update(OrderHibernate orderHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(orderHibernate);

        closeTransactionSession();
    }

    @Override
    public void remove(OrderHibernate orderHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(orderHibernate);

        closeTransactionSession();
    }
}
