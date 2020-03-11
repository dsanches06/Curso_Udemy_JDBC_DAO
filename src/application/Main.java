package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(5);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");
		List<Seller> list1 = sellerDao.findAll();
		for (Seller s : list1) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller("Bruno Carvalho", "bruno@scp.pt", new Date(), 30000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+newSeller.getId());

	}
}
