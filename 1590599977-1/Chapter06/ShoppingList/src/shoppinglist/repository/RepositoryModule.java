package shoppinglist.repository;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.wideplay.warp.jpa.JpaUnit;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.TransactionStrategy;
import com.wideplay.warp.persist.UnitOfWork;

public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(JpaUnit.class).to("shoppinglistJpaUnit");
        
        install(PersistenceService.usingJpa()
                          .across(UnitOfWork.REQUEST)
                          .transactedWith(TransactionStrategy.LOCAL)
                          .buildModule());

        bind(ProductRepository.class)
            .to(JpaProductRepository.class)
            .in(Singleton.class);
        
        bind(ShoppingListRepository.class)
            .to(JpaShoppingListRepository.class)
            .in(Singleton.class);
    }
}