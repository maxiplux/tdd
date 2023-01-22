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


    @InjectMocks
    ShoppingCartServicesImpl shoppingCartServicesRealMock;


    /* @Mock

    @InjectMocks // Se inject las concretas en la clase a testear
    private ShoppingCartServices shoppingCartServices;
    */

    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
        //shoppingCartRepository = mock(ShoppingCartRepositoryImpl.class);
        //shoppingCartServices = new ShoppingCartServicesImpl(shoppingCartRepository);Mo

    }

    @AfterEach
    void closeService() throws Exception {

    }
    @Test
    public void testAddItem()
    {


        ShoppingCartServices shoppingCartServicesReal = new ShoppingCartServicesImpl(ShoppingCartRepositoryImpl.getInstance());

        shoppingCartServicesReal.addItem(Product.builder().id(1L).name("Product 1").build());
        shoppingCartServicesReal.addItem(Product.builder().id(2L).name("Product 2").build());
        shoppingCartServicesReal.getCurrentCartSize();
        Assert.assertEquals(2, shoppingCartServicesReal.getCurrentCartSize());
    }

    @Test
    public void testAddItemMock()
    {
        //ShoppingCartRepository shoppingCartRepository = Mockito.mock(ShoppingCartRepository.class);
        Mockito.doNothing().when(shoppingCartRepository).addItem(Mockito.any(Product.class));
        Mockito.when(shoppingCartRepository.getCurrentCartSize()).thenReturn(2);


        ShoppingCartServices shoppingCartServicesReal = new ShoppingCartServicesImpl(shoppingCartRepository);

        shoppingCartServicesReal.addItem(Product.builder().id(1L).name("Product 1").build());
        shoppingCartServicesReal.addItem(Product.builder().id(2L).name("Product 2").build());
        shoppingCartServicesReal.getCurrentCartSize();
        Assert.assertEquals(2, shoppingCartServicesReal.getCurrentCartSize());
        Mockito.verify(shoppingCartRepository, Mockito.times(2)).addItem(Mockito.any(Product.class));
        Mockito.verify(shoppingCartRepository, Mockito.atLeast(1)).getCurrentCartSize();

    }

    @Test
    public void testAddItemInjectMock()
    {
        //ShoppingCartRepository shoppingCartRepository = Mockito.mock(ShoppingCartRepository.class);
        Mockito.doNothing().when(shoppingCartRepository).addItem(Mockito.any(Product.class));
        Mockito.when(shoppingCartRepository.getCurrentCartSize()).thenReturn(2);




        shoppingCartServicesRealMock.addItem(Product.builder().id(1L).name("Product 1").build());
        shoppingCartServicesRealMock.addItem(Product.builder().id(2L).name("Product 2").build());
        shoppingCartServicesRealMock.getCurrentCartSize();
        Assert.assertEquals(2, shoppingCartServicesRealMock.getCurrentCartSize());
        Mockito.verify(shoppingCartRepository, Mockito.times(2)).addItem(Mockito.any(Product.class));
        Mockito.verify(shoppingCartRepository, Mockito.atLeast(1)).getCurrentCartSize();

    }

}
