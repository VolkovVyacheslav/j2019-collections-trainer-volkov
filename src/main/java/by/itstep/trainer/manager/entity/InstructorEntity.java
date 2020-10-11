package by.itstep.trainer.manager.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "instructor")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class InstructorEntity extends AbstractUserEntity {
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "instructor")
    private List<SpecializationsEntity> specializationsList;
     @Column(name = "stage_month")
     private int stageMonth;
     @Column(name = "url_avatar")
     private String urlAvatar;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    private List <AchievementsEntity> achievementsList;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "instructor")
    private List<CommentsEntity> commentsList;
    @Column(name = "password", nullable = false)
    private String password;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "instructor")
    private List<ReceptionEntity> receptionList;


}
