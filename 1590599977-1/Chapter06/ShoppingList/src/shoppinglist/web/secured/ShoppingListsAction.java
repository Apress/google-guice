package shoppinglist.web.secured;

import static shoppinglist.util.Collectionz.newHashMap;

import java.util.List;
import java.util.Map;

import net.jcip.annotations.NotThreadSafe;
import shoppinglist.model.ShoppingList;
import shoppinglist.repository.ShoppingListRepository;
import shoppinglist.web.util.UserToken;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Actions related to collections of {@link ShoppingList} instances.
 * @author Robbie Vanbrabant
 */
@NotThreadSafe
public class ShoppingListsAction extends ActionSupport {
    // Data sources
    private final ShoppingListRepository shoppingListRepo;
    private final Provider<UserToken> userToken;
    
    // UI
    private Map<String, String> view = newHashMap();
    private Map<String, String> edit = newHashMap();
    private Map<String, String> remove = newHashMap();
    
    // State
    private List<ShoppingList> shoppingLists;
    private ShoppingList shoppingList;
    
    @Inject
    public ShoppingListsAction(ShoppingListRepository shoppingListRepo, Provider<UserToken> userToken) {
        this.shoppingListRepo = shoppingListRepo;
        this.userToken = userToken;
    }
    
    //-------------------------------------------------------------------------
    // Action methods
    //------------------------------------------------------------------------- 
    
    public String execute() {
        this.shoppingLists = shoppingListRepo.findShoppingLists(userToken.get().getLogin());
        if (view.size() > 0) return view();
        if (edit.size() > 0) return edit();
        if (remove.size() > 0) return remove();
        return SUCCESS;
    }
    
    private String view() {
        shoppingList = currentShoppingList(view);
        return "viewSL";
    }
    
    private String edit() {
        shoppingList = currentShoppingList(edit);
        return "editSL";
    }
    
    private String remove() {
        // delete the source data
        shoppingListRepo.delete(currentShoppingList(remove));
        // update the in-memory list
        shoppingLists.remove(currentShoppingListIndex(remove));
        return SUCCESS;
    }
    
    public String create() {
        return "createSL";
    }

    //-------------------------------------------------------------------------
    // Buttons
    //------------------------------------------------------------------------- 
    
    public Map<String, String> getView() {
        return view;
    }

    public Map<String, String> getEdit() {
        return edit;
    }

    public Map<String, String> getRemove() {
        return remove;
    }
    
    //-------------------------------------------------------------------------
    // Mutators / Accessors
    //------------------------------------------------------------------------- 

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }
    
    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
    
    //-------------------------------------------------------------------------
    // Utility
    //-------------------------------------------------------------------------
    
    private ShoppingList currentShoppingList(Map<String, String> map) {
        // get the submitted list index and get it from the list.
        return shoppingLists.get(currentShoppingListIndex(map));
    }

    private int currentShoppingListIndex(Map<String, String> map) {
        // always sure that there's one element at this point
        return Integer.parseInt(map.keySet().iterator().next());
    }
}
