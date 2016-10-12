package shoppinglist.repository;

import java.util.List;

import shoppinglist.model.ShoppingList;

public interface ShoppingListRepository {
    void create(ShoppingList shoppingList);
    void update(ShoppingList shoppingList);
    void delete(ShoppingList shoppingList);
    List<ShoppingList> findShoppingLists(String login);
}