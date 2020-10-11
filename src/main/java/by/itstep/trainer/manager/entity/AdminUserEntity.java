package by.itstep.trainer.manager.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "admins")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class AdminUserEntity extends AbstractUserEntity {
    @Column(name = "password", nullable = false)
    private String password;

}
