package io.maxiplux.tdd.services;

public interface ShoppingCartServices {
    void addItem(Product build);

    int getCurrentCartSize();
}
