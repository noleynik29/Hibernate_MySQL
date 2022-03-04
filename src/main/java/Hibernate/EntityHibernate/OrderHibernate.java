package Hibernate.EntityHibernate;

import javax.persistence.*;

@Entity
@Table(name = "`order`")
public class OrderHibernate {
    @Id
    @Column(name = "idOrder")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @Column(name = "total_price")
    private int total_price;

    @Column(name = "datetime")
    private String datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private UserHibernate userHibernate;

    public OrderHibernate(){

    }

    public OrderHibernate(int total_price, String datetime) {
        this.total_price = total_price;
        this.datetime = datetime;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public UserHibernate getUserHibernate() {
        return userHibernate;
    }

    public void setUserHibernate(UserHibernate userHibernate) {
        this.userHibernate = userHibernate;
    }

    @Override
    public String toString() {
        return "OrderHibernate{" +
                "idOrder=" + idOrder +
                ", total_price=" + total_price +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
