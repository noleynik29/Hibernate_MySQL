package Hibernate.ServiceHibernate;

import Hibernate.EntityHibernate.UserHibernate;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceHibernateTest {

    private static UserServiceHibernate userServiceHibernate = new UserServiceHibernate();

    @Test
    void add() throws SQLException {
        UserHibernate userHibernate = new UserHibernate();
        userHibernate.setIdUser(12);
        userHibernate.setFirstName("Eren");
        userHibernate.setLastName("Yeager");

        userServiceHibernate.add(userHibernate);

        UserHibernate userFromDB = userServiceHibernate.getById(12);
        assertEquals("Eren", userFromDB.getFirstName());
        assertEquals("Yeager", userFromDB.getLastName());
    }

    @Test
    void getAll() throws SQLException {
        List<UserHibernate> listFromDB = userServiceHibernate.getAll();
        assertEquals(11, listFromDB.size());
    }

    @Test
    void getById() throws SQLException {
        UserHibernate userFromDB = userServiceHibernate.getById(12);
        assertEquals("Eren", userFromDB.getFirstName());
        assertEquals("Yeager", userFromDB.getLastName());
    }

    @Test
    void remove() throws SQLException {
        UserHibernate userHibernate = userServiceHibernate.getById(12);
        userServiceHibernate.remove(userHibernate);
        assertNull(userServiceHibernate.getById(12));
    }
}