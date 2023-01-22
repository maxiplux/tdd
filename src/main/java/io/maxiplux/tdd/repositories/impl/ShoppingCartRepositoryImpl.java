package io.maxiplux.tdd.repositories.impl;

import io.maxiplux.tdd.repositories.ShoppingCartRepository;
import io.maxiplux.tdd.services.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

    private static ShoppingCartRepositoryImpl single_instance = null;

    List<Product> products = new ArrayList<Product>();

    private ShoppingCartRepositoryImpl()
    {
        products = new ArrayList<Product>();
    }


    public static ShoppingCartRepositoryImpl getInstance()
    {
        if (single_instance == null)
            single_instance = new ShoppingCartRepositoryImpl();

        return single_instance;
    }

    @Override
    public void addItem(Product build) {
        this.products.add(build);
        log.info("Product added to cart: {}", build);
        log.info("Total products in cart: {}", this.products.size());
        log.info("Current items {}", this.products);

    }

    @Override
    public int getCurrentCartSize() {
        return this.products.size();
    }
}
