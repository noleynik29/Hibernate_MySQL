package Hibernate.EntityHibernate;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
public class UserHibernate {
    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    public UserHibernate(){

    }

    public UserHibernate(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserHibernate{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
