package com.SpringBoot.Mapping.OneToOne;

import com.SpringBoot.Mapping.OneToOne.dao.AppDao;
import com.SpringBoot.Mapping.OneToOne.entity.Instructor;
import com.SpringBoot.Mapping.OneToOne.entity.InstructorDetail;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.SysexMessage;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {

		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			System.out.println("Hello world!");
			// Uni-Directional Relationship
			// createNewObj(appDao);
			// findInstructorById(appDao);
			// deleteInstructorById(appDao);
			// findAll(appDao);
		};
	}

	private void findAll(AppDao appDao) {
		List<Instructor> instructors = appDao.findAll();
		System.out.println(instructors);
	}

	private void deleteInstructorById(AppDao appDao) {
		int id = 3;
		System.out.println("Delete instructor with instructor : " + id);
		appDao.deleteById(id);
		System.out.println("Successfully deleted..");
	}

	private void findInstructorById(AppDao appDao) {

		int id = 3;
		System.out.println("Searching instrcutor id : " + id);
		Instructor instructor = appDao.findById(id);
		System.out.println(instructor);
		String theInstructor = "The instructot name is " + instructor.getFirstName() + " " +
				instructor.getLastName();
		System.out.println(theInstructor);
	}

	private void createNewObj(AppDao appDao) {

		Instructor instructorBala = new Instructor(
				"Bit","fumes"
		);

		InstructorDetail instructorDetailbala = new InstructorDetail(
				"www.youtube.com/@Bitfumes","BitFumes"
		);

		// now associate both entity
		instructorBala.setInstructorDetail(instructorDetailbala);
		System.out.println("Saving..");
		appDao.save(instructorBala);
		System.out.println(instructorBala);
	}

}
