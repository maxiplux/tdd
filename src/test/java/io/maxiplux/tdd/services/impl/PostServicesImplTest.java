package io.maxiplux.tdd.services.impl;

import io.maxiplux.tdd.TddApplication;
import io.maxiplux.tdd.repositories.PostRepository;
import io.maxiplux.tdd.services.PostServices;
import io.maxiplux.tdd.utils.Utility;
import org.h2.command.dml.MergeUsing;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.com.google.common.base.Verify;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TddApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
class PostServicesImplTest {


    @MockBean
    private PostRepository postRepository;

    private PostServices postServices;
    @BeforeEach
    void setUp() {
        this.postServices=new PostServicesImpl(postRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        Mockito.when(postRepository.findAll()).thenReturn(Utility.posts);

        Assert.assertTrue(postServices.findAll().size() == 2);

        Mockito.verify(postRepository, atLeast(1)).findAll();
    }
}
