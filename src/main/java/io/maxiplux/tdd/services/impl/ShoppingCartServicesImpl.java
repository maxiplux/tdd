package io.maxiplux.tdd.services.impl;

import io.maxiplux.tdd.repositories.ShoppingCartRepository;
import io.maxiplux.tdd.services.Product;
import io.maxiplux.tdd.services.ShoppingCartServices;

public class ShoppingCartServicesImpl implements ShoppingCartServices {

    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServicesImpl(ShoppingCartRepository shoppingCartRepository)
    {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    @Override
    public void addItem(Product build) {
        this.shoppingCartRepository.addItem(build);
    }

    @Override
    public int getCurrentCartSize() {
        return this.shoppingCartRepository.getCurrentCartSize();
    }
}
