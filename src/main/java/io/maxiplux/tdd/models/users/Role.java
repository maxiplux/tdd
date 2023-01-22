package io.maxiplux.tdd.models.users;




import io.maxiplux.tdd.models.AuditModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role extends AuditModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 20)
    private String name;

    public Role(RoleName roleAdmin) {
        this.name = roleAdmin.name();
    }
}
