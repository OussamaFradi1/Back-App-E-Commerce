package formation.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "category")
    private Collection<SubCategory> subcategories;
    @JsonIgnore
    public Collection<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
