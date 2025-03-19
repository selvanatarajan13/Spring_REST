package com.SpringBoot.Mapping.OneToOne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor_detail")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InstructorDetail {

    // define fields
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "channel_name")
    private String channelName;

    // define constructor

    public InstructorDetail(String email, String channelName) {
        this.email = email;
        this.channelName = channelName;
    }
}
