package io.maxiplux.tdd.repositories;




import io.maxiplux.tdd.models.Post;
import io.maxiplux.tdd.models.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {



}
