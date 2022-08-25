package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TESTE 1: Seller - findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);

		System.out.println("\n=== TESTE 2: Seller - findByDepartment ===");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3: Seller - findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 4: Seller - Insert ===");
		Seller newSeller = new Seller(null, "Diana", "diana@gmail.com", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Seller Id: " + newSeller.getId());
		
		System.out.println("\n=== TESTE 5: Seller - Update ===");
		Seller updateSeller = new Seller(14, "Jardiana", "diana@gmail.com", new Date(), 9000.0, department);
		sellerDao.update(updateSeller);
		System.out.println("Updated Seller! " + updateSeller.getId());
		
		System.out.println("\n=== TESTE 6: Seller - Delete ===");
		sellerDao.deleteById(17);
		System.out.println("Deleted Seller!");
	}

}
