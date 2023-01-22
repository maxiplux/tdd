package io.maxiplux.tdd.services;

import io.maxiplux.tdd.repositories.ShoppingCartRepository;
import io.maxiplux.tdd.repositories.impl.ShoppingCartRepositoryImpl;
import io.maxiplux.tdd.services.impl.ShoppingCartServicesImpl;
import org.junit.Assert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartServicesTest {

    @Mock
    public ShoppingCartRepository shoppingCartRepository;


    /* @Mock

    @InjectMocks
    private ShoppingCartServices shoppingCartServices;
    */

    @BeforeEach
    void initService() {


    }

    @AfterEach
    void closeService() throws Exception {

    }
    @Test
    public void testAddItem()
    {


        ShoppingCartServices shoppingCartServices = new ShoppingCartServicesImpl(ShoppingCartRepositoryImpl.getInstance());

        shoppingCartServices.addItem(Product.builder().id(1L).name("Product 1").build());
        shoppingCartServices.addItem(Product.builder().id(2L).name("Product 2").build());
        shoppingCartServices.getCurrentCartSize();
        Assert.assertEquals(2, shoppingCartServices.getCurrentCartSize());
    }

    @Test
    public void testAddItemMock()
    {
        //ShoppingCartRepository shoppingCartRepository = Mockito.mock(ShoppingCartRepository.class);
        Mockito.doNothing().when(shoppingCartRepository).addItem(Mockito.any(Product.class));
        Mockito.when(shoppingCartRepository.getCurrentCartSize()).thenReturn(2);


        ShoppingCartServices shoppingCartServices = new ShoppingCartServicesImpl(shoppingCartRepository);

        shoppingCartServices.addItem(Product.builder().id(1L).name("Product 1").build());
        shoppingCartServices.addItem(Product.builder().id(2L).name("Product 2").build());
        shoppingCartServices.getCurrentCartSize();
        Assert.assertEquals(2, shoppingCartServices.getCurrentCartSize());
        Mockito.verify(shoppingCartRepository, Mockito.times(2)).addItem(Mockito.any(Product.class));
        Mockito.verify(shoppingCartRepository, Mockito.atLeast(1)).getCurrentCartSize();

    }

}
