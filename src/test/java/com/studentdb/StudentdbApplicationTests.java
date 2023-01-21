package com.studentdb;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentdb.Repository.StudentRepository;
import com.studentdb.entity.Student;

@SpringBootTest
class StudentdbApplicationTests {
	@Autowired
 private StudentRepository studentrepo;
 
	@Test
	void saveOneStudent () {
		Student s1= new Student();
		s1.setName("aman");
		s1.setCourse("j2ee");
		s1.setFee(1300);
		studentrepo.save(s1);
	}
@Test
	void deleteOneStudent() {
		studentrepo.deleteById(1L);
	}
@Test
	void getOneStudent() {
		Optional<Student> findById = studentrepo.findById(10L);
		
  	    Student s = findById.get();
  	    
		 System.out.println(s.getId());
		 System.out.println(s.getName());
		 System.out.println(s.getCourse());
		 System.out.println(s.getFee());
		 
	} @Test
      void updateOneStudent() {
    	  Optional<Student> findById = studentrepo.findById(2L);
    	  Student s = findById.get();
    	  s.setCourse("dev");
    	  s.setFee(20000);
    	  studentrepo.save(s);
      }
	
}
