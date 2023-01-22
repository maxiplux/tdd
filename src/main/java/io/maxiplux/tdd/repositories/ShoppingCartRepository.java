package io.maxiplux.tdd.repositories;

import io.maxiplux.tdd.services.Product;

public interface ShoppingCartRepository {
    void addItem(Product build);

    int getCurrentCartSize();
}
