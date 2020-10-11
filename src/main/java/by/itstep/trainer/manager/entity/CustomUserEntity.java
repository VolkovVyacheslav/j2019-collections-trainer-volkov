package by.itstep.trainer.manager.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "custom_usrs")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class CustomUserEntity extends AbstractUserEntity {
    @Column(name = "password", nullable = true)
    private String password;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customUser" )
    private List<CommentsEntity> commentsList;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user" )
    private List<ReceptionEntity> receptionList;
}
