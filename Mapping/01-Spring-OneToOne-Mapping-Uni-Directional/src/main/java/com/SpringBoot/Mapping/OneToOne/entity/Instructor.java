package com.SpringBoot.Mapping.OneToOne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Instructor {

    // define fields
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    // define constructor

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
