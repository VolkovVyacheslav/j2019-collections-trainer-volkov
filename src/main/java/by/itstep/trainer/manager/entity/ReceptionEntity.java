package by.itstep.trainer.manager.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "receptions")
public class ReceptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "custom_user_id")
    private CustomUserEntity user;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;
    @Column(name = "time")
    private Time time;
    @Column(name = "date")
    private Date date;
    @Column(name = "remark")
    private String remark;

}
