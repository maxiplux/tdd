package io.maxiplux.tdd.repositories;




import io.maxiplux.tdd.models.users.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Role findByName(String name);

    //@Query("select u from USER u where u.username=?1")
    //User findByUsername2(String username);

}
