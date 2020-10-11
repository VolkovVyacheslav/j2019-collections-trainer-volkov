package by.itstep.trainer.manager.entity;

import by.itstep.trainer.manager.entity.enums.Rating;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")

public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Type(type = "text")
    @Column(name = "comment")
    private String comment;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rating")
    private Rating rating;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "custom_usr_id")
    private CustomUserEntity customUser;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;
    @Column(name = "is_approved")
    private boolean isApproved;
}
