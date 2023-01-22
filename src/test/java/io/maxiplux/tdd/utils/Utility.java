package io.maxiplux.tdd.utils;

import io.maxiplux.tdd.services.Product;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static List<Product> products=  new ArrayList<>(
                    List.of(
                            Product.builder().id(2L).name("Product 2")

                        .build(),Product.builder().id(1L).name("Product 1").build()
                    ));
}
