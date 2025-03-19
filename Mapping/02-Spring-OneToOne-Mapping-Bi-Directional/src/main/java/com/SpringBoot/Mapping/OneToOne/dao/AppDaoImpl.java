package com.SpringBoot.Mapping.OneToOne.dao;

import com.SpringBoot.Mapping.OneToOne.entity.Instructor;
import com.SpringBoot.Mapping.OneToOne.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor theInstructor = entityManager.find(Instructor.class, id);
        return theInstructor;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor query = entityManager.find(Instructor.class, id);
        entityManager.remove(query);
    }

    @Override
    public List<Instructor> findAll() {
        TypedQuery<Instructor> query = entityManager.createQuery("from Instructor", Instructor.class);
        List<Instructor> instructors = query.getResultList();
        return instructors;
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }


}
