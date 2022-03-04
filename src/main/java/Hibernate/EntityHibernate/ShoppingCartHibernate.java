package Hibernate.EntityHibernate;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartHibernate {
    @Id
    @Column(name = "idShoppingCart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrder")
    private OrderHibernate orderHibernate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    private ProductHibernate productHibernate;

    @Column(name = "order_quantity")
    private int order_quantity;

    public ShoppingCartHibernate(){

    }

    public int getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(int idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public OrderHibernate getOrderHibernate() {
        return orderHibernate;
    }

    public void setOrderHibernate(OrderHibernate orderHibernate) {
        this.orderHibernate = orderHibernate;
    }

    public ProductHibernate getProductHibernate() {
        return productHibernate;
    }

    public void setProductHibernate(ProductHibernate productHibernate) {
        this.productHibernate = productHibernate;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCartHibernate{" +
                "idShoppingCart=" + idShoppingCart +
                ", orderHibernate=" + orderHibernate +
                ", productHibernate=" + productHibernate +
                ", order_quantity=" + order_quantity +
                '}';
    }
}
