package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department insert ====");
		Department department  = new Department(null, "Food");
		departmentDao.insert(department);
		System.out.println("Insertion concluded for " + department);
		
		System.out.println("\n=== TEST 2: findById ====");
		Department found = departmentDao.findById(2);
		System.out.println("Id 2: " + found);
		
		System.out.println("\n=== TEST 3: department update ====");
		Department newDepartment  = departmentDao.findById(3);
		newDepartment.setName("Clothes");
		departmentDao.update(newDepartment);
		System.out.println("Update concluded!");
		
		System.out.println("\n=== TEST 4: department findAll ====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 5: seller delete ====");
		System.out.println("Enter id for delete test: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
