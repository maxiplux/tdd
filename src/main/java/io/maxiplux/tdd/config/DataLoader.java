package io.maxiplux.tdd.config;


import io.maxiplux.tdd.models.users.Role;
import io.maxiplux.tdd.models.users.RoleName;
import io.maxiplux.tdd.models.users.User;
import io.maxiplux.tdd.repositories.RoleRepository;
import io.maxiplux.tdd.repositories.UserRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Transactional
public class DataLoader implements ApplicationRunner {

    @Value("${app.data.loader.delete}")
    private Boolean shouldItCleanTheData;

    @Value("${app.data.loader.create}")
    private Boolean shouldItCreateData;

    @Autowired
    private UserRepository userRepository;




    @Autowired
    private RoleRepository roleRepository;







    @Autowired
    private BCryptPasswordEncoder passwordEncoder;




    private EasyRandom factory;

    private void createFactory() {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(StandardCharsets.UTF_8)
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        factory = new EasyRandom(parameters);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        createFactory();
        if (this.shouldItCleanTheData)
        {

            this.userRepository.deleteAll();

        }
        if (this.shouldItCreateData)
        {
            this.createUser();

        }



    }




    private void createUser() {
        User user = new User();
        roleRepository.save(new Role(RoleName.ROLE_USER));
        roleRepository.save(new Role(RoleName.ROLE_ADMIN));
        user.setPassword(passwordEncoder.encode("12345"));
        user.setUsername("admin");
        user.setEnabled(true);
        user.setRoles((List<Role>) this.roleRepository.findAll());
        this.userRepository.save(user);




    }


}
