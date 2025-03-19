package com.SpringBoot.Mapping.OneToOne.dao;

import com.SpringBoot.Mapping.OneToOne.entity.Instructor;
import com.SpringBoot.Mapping.OneToOne.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    List<Instructor> findAll();

    InstructorDetail findInstructorDetailById(int id);
}
