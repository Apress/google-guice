package shoppinglist.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.google.inject.util.ToStringBuilder;

/**
 * Product that can go on someone's shopping list.
 * 
 * @author Robbie Vanbrabant
 */
@Entity
@NamedQueries({
    @NamedQuery(name=Product.Q_PRODUCTS_COMPLEMENT, 
                query="SELECT p FROM Product p WHERE p NOT IN(:products)"),
    @NamedQuery(name=Product.Q_PRODUCTS_WITH_IDS, 
                query="SELECT p FROM Product p WHERE p.id IN(:ids)"),
    @NamedQuery(name=Product.Q_ALL_PRODUCTS, query="SELECT p FROM Product p")
})
public class Product implements Serializable {
    public static final String Q_PRODUCTS_COMPLEMENT = "productsComplement";
    public static final String Q_PRODUCTS_WITH_IDS = "productsWithIds";
    public static final String Q_ALL_PRODUCTS = "allProducts";
    
    private Long id;
    private String name;

    @GeneratedValue @Id
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

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 15;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        final Product that = (Product) o;
        
        if (!(id == that.id || (id != null && id.equals(that.id)))) 
            return false;
        if (!(name == that.name || (name != null && name.equals(that.name))))
            return false;

        return true;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(getClass())
                    .add("id", getId())
                    .add("name", getName())
                    .toString();
    }
}
