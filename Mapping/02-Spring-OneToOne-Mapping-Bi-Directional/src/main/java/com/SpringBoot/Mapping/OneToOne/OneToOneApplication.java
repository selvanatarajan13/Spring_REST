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

			// Bi-Directional Relationship
			findInstructorDetailById(appDao);
		};
	}

	private void findInstructorDetailById(AppDao appDao) {
		int id = 103;
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}


}
