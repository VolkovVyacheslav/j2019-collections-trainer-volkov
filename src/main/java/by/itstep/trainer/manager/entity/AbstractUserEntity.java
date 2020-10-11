package by.itstep.trainer.manager.entity;

import by.itstep.trainer.manager.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="last_name")
    private String lastName;
    @Column(name ="mail")
    private String mail;
    @Column(name = "telefon")
    private String phoneNumber;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role")
    private Role role;

}
