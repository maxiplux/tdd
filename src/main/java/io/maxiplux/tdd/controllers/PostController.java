package io.maxiplux.tdd.controllers;

import io.maxiplux.tdd.models.Post;
import io.maxiplux.tdd.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostServices postServices;


    @GetMapping(value = "/")
    public ResponseEntity<?> findById() {


        return new ResponseEntity<List<Post>>(this.postServices.findAll(), HttpStatus.OK);
    }
}
