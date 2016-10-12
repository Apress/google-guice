package shoppinglist.repository;

import java.util.List;

import javax.persistence.EntityManager;

import shoppinglist.model.ShoppingList;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.wideplay.warp.persist.TransactionType;
import com.wideplay.warp.persist.Transactional;
import com.wideplay.warp.persist.dao.Finder;

public class JpaShoppingListRepository implements ShoppingListRepository {
    // Use a Provider, or scope this class to match the WP UnitOfWork
    private final Provider<EntityManager> em;
    
    @Inject
    public JpaShoppingListRepository(Provider<EntityManager> em) {
        this.em = em;
    }
    
    @Finder(namedQuery=ShoppingList.Q_SHOPPING_LIST_FOR_LOGIN)
    @Transactional(type=TransactionType.READ_ONLY)
    public List<ShoppingList> findShoppingLists(@Named("login") String login) {
        return null;
    }
    
    @Transactional
    public void create(ShoppingList shoppingList) {
        em.get().persist(shoppingList);
    }

    @Transactional
    public void update(ShoppingList shoppingList) {
        em.get().merge(shoppingList);
    }
    
    @Transactional
    public void delete(ShoppingList shoppingList) {
        em.get().remove(shoppingList);
    }
}
