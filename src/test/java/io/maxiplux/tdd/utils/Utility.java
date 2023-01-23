package io.maxiplux.tdd.utils;

import io.maxiplux.tdd.models.Post;
import io.maxiplux.tdd.services.Product;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static List<Product> products=  new ArrayList<>(
                    List.of(
                            Product.builder().id(2L).name("Product 2")

                        .build(),Product.builder().id(1L).name("Product 1").build()
                    ));

    public static List<Post> posts=  new ArrayList<>(
            List.of(
                                 Post.builder().id(2L).title("Post 2").build(),Post.builder().id(1L).title("Post 1").build()

            ));
}
