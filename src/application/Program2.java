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

		System.out.println("=== TESTE 1 - Department: findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 2 - Department: insert ===");		
		Department newDep = new Department(null, "technology");
		departmentDao.insert(newDep);
		System.out.println("Inserted new department! " + newDep);
		
		System.out.println("\n=== TESTE 3 - Department: deleteById ===");		
		departmentDao.deleteById(16);
		System.out.println("Deleted department");

		System.out.println("\n=== TESTE 4 - Department: Update ===");
		dep = new Department(15, "Defensive");
		departmentDao.update(dep);
		System.out.println("Updated Department");
		
		System.out.println("\n=== TESTE 5 - Department: findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println(dep);
		
		sc.close();
	}

}
