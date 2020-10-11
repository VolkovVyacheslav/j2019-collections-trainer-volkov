package by.itstep.trainer.manager.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "achievements")

public class AchievementsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;
    @Column(name = "description")
    private String description;
    @Column(name ="is_assigned")
    private boolean isAssigned;

}
