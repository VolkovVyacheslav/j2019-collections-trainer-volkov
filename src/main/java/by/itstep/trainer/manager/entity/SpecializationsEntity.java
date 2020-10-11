package by.itstep.trainer.manager.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specializations")

public class SpecializationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name = "time_duration")
    private Time duration;
    @Column(name = "user_to_grup")
    private int userToGroup;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;

}
