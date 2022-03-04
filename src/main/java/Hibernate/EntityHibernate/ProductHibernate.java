package Hibernate.EntityHibernate;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductHibernate {
    @Id
    @Column(name = "idProduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    public ProductHibernate() {
    }

    public ProductHibernate(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "ProductHibernate{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
