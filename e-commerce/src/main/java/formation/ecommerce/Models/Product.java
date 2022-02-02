package formation.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String description;
    @ManyToOne
    @JoinColumn(name="idsubcategory")
    private SubCategory subcategory;
    @ManyToOne
    @JoinColumn(name="idprovider")
    private Provider provider;
    @ManyToMany(mappedBy = "p")
    private Collection<Order> o;
    @JsonIgnore
    public Collection<Order> getO() {
        return o;
    }

    public void setO(Collection<Order> o) {
        this.o = o;
    }

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
