package com.tushar;

import java.util.List;

import com.tushar.dao.StudentDao;
import com.tushar.entity.Student;

public class App {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
		studentDao.saveStudent(student);
		
		studentDao.insertStudent();
		
		// update student
		Student student1 = new Student("Ram", "Fadatare", "rameshfadatare@javaguides.com");
		studentDao.updateStudent(student1);
		
		// get students
		List<Student> students = studentDao.getStudents();
		students.forEach(s -> System.out.println(s.getFirstName()));
		
		// get single student
		Student student2 = studentDao.getStudent(1);
		System.out.println(student2.getFirstName());
		
		// delete student
		studentDao.deleteStudent(1);
	}
}