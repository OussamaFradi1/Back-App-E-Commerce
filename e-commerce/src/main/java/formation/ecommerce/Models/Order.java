package formation.ecommerce.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int price;
    private String date;
    @ManyToOne
    @JoinColumn(name="idclient")
    private Client client;
    @ManyToMany
    @JoinTable(name ="ORD_PROD",joinColumns =
    @JoinColumn(name="Ord_Id"),inverseJoinColumns = @JoinColumn(name="Prod_Id"))
    private Collection<Product> p;
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
