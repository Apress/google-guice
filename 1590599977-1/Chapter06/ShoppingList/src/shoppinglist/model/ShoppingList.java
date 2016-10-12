package shoppinglist.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import com.google.inject.util.ToStringBuilder;

@Entity
@NamedQuery(name=ShoppingList.Q_SHOPPING_LIST_FOR_LOGIN, 
            query="SELECT sl FROM ShoppingList sl " +
                  "WHERE sl.login = :login ORDER BY sl.name ASC")
public class ShoppingList implements Serializable {
    public static final String Q_SHOPPING_LIST_FOR_LOGIN = "shoppingListsForLogin";

    private Long id;
    private String name;
    private String login;

    private List<Product> products;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @ManyToMany(targetEntity=Product.class,
                cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="shoppinglist_product", 
               joinColumns={@JoinColumn(name="shoppinglist_id")},
               inverseJoinColumns = {@JoinColumn(name="product_id")})
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 15;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((products == null) ? 0 : products.hashCode());
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
        final ShoppingList that = (ShoppingList) o;

        if (!(id == that.id || (id != null && id.equals(that.id))))
            return false;
        if (!(name == that.name || (name != null && name.equals(that.name))))
            return false;
        if (!(products == that.products || (products != null && products.equals(that.products))))
            return false;
        if (!(login == that.login || (login != null && login.equals(that.login))))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(getClass())
                        .add("id", getId())
                        .add("name", getName())
                        .add("login", getLogin())
                        .add("products", getProducts())
                        .toString();
    }
}
