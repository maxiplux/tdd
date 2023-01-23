package io.maxiplux.tdd.services.impl;

import io.maxiplux.tdd.models.Post;
import io.maxiplux.tdd.repositories.PostRepository;
import io.maxiplux.tdd.services.PostServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServicesImpl implements PostServices {
    private final PostRepository postRepository;
    @Override
    public List<Post> findAll() {
        return (List<Post>) this.postRepository.findAll();
    }
}
