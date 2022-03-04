package Hibernate.ServiceHibernate;

import BusinessLogic.SessionUtil;
import Hibernate.EntityHibernate.ProductHibernate;
import Hibernate.HibernateDAO.ProductHibernateDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceHibernate extends SessionUtil implements ProductHibernateDAO {
    @Override
    public void add(ProductHibernate productHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(productHibernate);

        closeTransactionSession();
    }

    @Override
    public List<ProductHibernate> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM product";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ProductHibernate.class);
        List<ProductHibernate> productHibernateList = query.list();

        closeTransactionSession();
        return productHibernateList;
    }

    @Override
    public ProductHibernate getById(int idProduct) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM product WHERE idProduct = :idProduct";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ProductHibernate.class);
        query.setParameter("idProduct", idProduct);

        ProductHibernate productHibernate = (ProductHibernate) query.getSingleResult();

        closeTransactionSession();
        return productHibernate;
    }

    @Override
    public void update(ProductHibernate productHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(productHibernate);

        closeTransactionSession();
    }

    @Override
    public void remove(ProductHibernate productHibernate) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(productHibernate);

        closeTransactionSession();
    }
}
