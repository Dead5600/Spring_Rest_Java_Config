package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Cars;

@Repository
public class CarsDaoImpl implements CarsDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public boolean addCar(Cars car) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(car);
			tx.commit();
			System.out.println("Cars added successfully.....");
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Cars> getAllCars() {
		Session session = null;
		String s = "From Cars";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery(s);
			List<Cars> list = query.list();
			
			tx.commit();
			System.out.println("List of cars is fetched.....");
			return list;
		}catch (Exception e) {
			System.out.println("unable to fetch list of cars.....");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public Cars getCar(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			System.out.println("Car is fetched  by id....");
			return session.get(Cars.class,id);
			
		}catch (Exception e) {
			System.out.println("car details unable to get.....");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		
	}

	@Override
	public boolean deleteCar(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Cars car = session.get(Cars.class,id);
			session.delete(car);
			tx.commit();
			System.out.println("Cars is deleted....");
			
			return true;
		}catch (Exception e) {
			System.out.println("car details unable deleted.....");
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		
	}

	
	@Override
	public boolean updateCarDetails(Cars car, int id) {
		Session session = null;
		String s = "Update Cars SET name =: name,company =:company where id =: id";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery(s);
			query.setParameter("name", car.getName());
			query.setParameter("company",car.getCompany());
			query.setParameter("id", id);
			query.executeUpdate();
			
			tx.commit();
			System.out.println("car details updated.....");
			return true;
		}catch (Exception e) {
			System.out.println("car details unable updated.....");
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

}
