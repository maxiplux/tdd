package io.maxiplux.tdd.services.impl;



import io.maxiplux.tdd.models.users.Role;
import io.maxiplux.tdd.repositories.RoleRepository;
import io.maxiplux.tdd.services.RoleServices;
import io.maxiplux.tdd.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class RoleServicesImpl extends CrudServicesImpl<Role> implements RoleServices<Role> {

    @Autowired
    private RoleRepository roleRepository;


    @PostConstruct
    public void posContructor() {
        this.setRepository(roleRepository);
    }


    public Optional<Role> UpdateById(long id, Role element) {
        Optional<Role> optionalCurrentCompany = this.repository.findById(id);
        if (optionalCurrentCompany.isPresent()) {
            Role currentProduct = optionalCurrentCompany.get();

            if (element.getName() != null) {
                currentProduct.setName(element.getName());
            }


            return Optional.of((Role) this.repository.save(currentProduct));
        }
        return Optional.empty();

    }


}
