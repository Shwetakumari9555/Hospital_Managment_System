//package com.Hotal_Managment;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class Patient {
//	
//	private Connection con;
//	
//	private Scanner sc;
//
//	public Patient(Connection con, Scanner sc) {
//		super();
//		this.con = con;
//		this.sc = sc;
//	}
//	
//	
//	public void addPatient() {
//		System.out.println("Enter Patient Name: ");
//		String name= sc.next();
//		System.out.println("Enter Patient Age: ");
//		int age= sc.nextInt();
//		System.out.println("Enter Patient Gender ");
//		String gender = sc.next();
//		
//		try {
//			String query= "INSERT INTO Patient (name,age,gender) Values (?,?,?)";
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1, name);
//			ps.setInt(2, age);
//			ps.setString(3, gender);
//			int affectedRow= ps.executeUpdate();
//			if(affectedRow>0) {
//				System.out.println("Patient added Successfully");
//				con.commit();
//			}else {
//				System.out.println("Error during Add Pateint");
//			}
//			
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void ViewPatient() {
//		String query= "Select * from Pateint";
//		try {
//			PreparedStatement ps= con.prepareStatement(query);
//			ResultSet rs= ps.executeQuery();
//			System.out.println("Patients :");
//			System.out.println("+------------+-----------------+----------+-----------+");
//			System.out.println("| Patient Id | Name            | Age      | Gender    |");
//			System.out.println("+------------+-----------------+----------+-----------+");
//			while(rs.next()) {
//				int id=rs.getInt("id");
//				String name= rs.getString("name");
//				int age=rs.getInt("Age");
//				String gender= rs.getString("gender");
//				System.out.printf("|%-12s|%-17s|%-10s|%-11s");
//				System.out.println("+------------+-----------------+----------+-----------+");
//				
//			}
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//	}
//	
//	}
//	
//	public void ViewPatientById() {
//		String query= "Select * from Patient Where Id= ?";
//		try {
//			PreparedStatement ps= con.prepareStatement(query);
//			ps.setInt(1, "id");
//			ResultSet rs= ps.executeQuery();
//			System.out.println("Patient :");
//			System.out.println("+------------+-----------------+----------+-----------+");
//			System.out.println("| Patient Id | Name            | Age      | Gender    |");
//			System.out.println("+------------+-----------------+----------+-----------+");
//			while(rs.next()) {
//				int id=rs.getInt("id");
//				String name= rs.getString("name");
//				int age=rs.getInt("Age");
//				String gender= rs.getString("gender");
//				System.out.printf("|%-12s|%-17s|%-10s|%-11s");
//				System.out.println("+------------+-----------------+----------+-----------+");
//				
//			}
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//	}
//	
//	}
//	
//	
//}

package com.Hotal_Managment; // Fixed package name

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {

	private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient(){
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();

        try{
            String query = "INSERT INTO patients(name, age, gender) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Patient Added Successfully!!");
            }else{
                System.out.println("Failed to add Patient!!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewPatients(){
        String query = "select * from patients";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients: ");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Patient Id | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", id, name, age, gender);
                System.out.println("+------------+--------------------+----------+------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getPatientById(int id){
        String query = "SELECT * FROM patients WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
