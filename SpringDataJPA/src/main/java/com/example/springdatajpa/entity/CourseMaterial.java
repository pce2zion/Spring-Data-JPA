package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
          cascade = CascadeType.ALL,
            // this is to make sure that the joined class also gets printed alongside the
            //joiner class
            fetch = FetchType.LAZY,
            //this is used to fetch child and parent (course mat and course)from the db.
            // but when we specify as lazy, we say we want only the parent
         optional = false
            //this is used to specify that the classes joined cant be called alone
            //ie if a course is being created, a course material must be created alongside
            //hence the optionality is false
    )

    @JoinColumn(
            name = "course_id",
           referencedColumnName = "courseId"
    )
    private Course course;
    //later on, when you want to specify a bi-directional one to one relationship you
    //specify the mappedby = this 'course' you have here
}
