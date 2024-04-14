package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalManagementSystem {
	private static final String url="jdbc:mysql://localhost:3306/hospital";
	  private static final String username="root";
	  private static final String password="Piyush";

	  public static void main(String[] args) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");    
	        
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    Scanner scanner=new Scanner(System.in);
	    try {
	        Connection connection=DriverManager.getConnection(url, username, password);
	        
	        Patient patient=new Patient(connection,scanner);
	        Doctor doctors=new Doctor(connection);
	        while (true) {
	            System.out.println("HOSPITAL MANAGEMENT SYSTEM");
	            System.out.println("1. Add Patient");
	            System.out.println("2. View Patients");
	            System.out.println("3. View Doctors");
	            System.out.println("4. Book Apointement");
	            System.out.println("5. EXIT");
	            System.out.println("Enter your Choice");
	            int choice =scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    // add patient
	                    patient.addPatient();
	                    System.out.println();
	                    break;
	                case 2:
	                    // view patient
	                    patient.viewPatients();
	                    System.out.println();
	                    break;
	                case 3:
	                    // view doctors
	                    doctors.viewDoctor();
	                    System.out.println();
	                    break;
	                case 4:
	                    // book apointment
	                    bookAppointment(patient, doctors, connection, scanner);
	                    System.out.println();
	                    break;
	                case 5:
	                    // exit
	                    return;
	                default:
	                 System.out.println("Enter valid Choice !!!");  
	                 break;
	            }
	        }
	        
	    } catch (Exception e) {
	        
	        e.printStackTrace();
	    }
	  }
	  public static void bookAppointment(Patient patient, Doctor doctors, Connection connection, Scanner scanner){
	    System.out.println("Enter paitent id: ");
	    int patientID= scanner.nextInt();
	    System.out.println("Enter doctor id: ");
	    int doctorID= scanner.nextInt();
	    System.out.println("Enter appointment date (yyyy-mm-dd): ");
	    String appointmentDate=scanner.next();
	    if (patient.getPatientById(patientID) && doctors.getDoctorById(doctorID)) {
	        if (checkDoctorAvailablity(doctorID,appointmentDate,connection)) {
	            String appointmentQuery="INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES(?, ?, ?)";
	            try {
	                PreparedStatement preparedStatement=connection.prepareStatement(appointmentQuery);
	                preparedStatement.setInt(1, patientID);
	                preparedStatement.setInt(2, doctorID);
	                preparedStatement.setString(3,appointmentDate);
	                int rowsAffected=preparedStatement.executeUpdate();
	                 if (rowsAffected>0) {
	                    System.out.println("Appointment booked");
	                 }else{
	                    System.out.println("Failed to Book Apointment");
	                 }

	            } catch (Exception e) {
	                
	                e.printStackTrace();
	            }
	        }else{
	            System.out.println("Doctor not available on this date");
	        }
	    }else{
	        System.out.println("Either Doctor or Patient Do not exist");
	    }
	  }

	    public static boolean checkDoctorAvailablity(int doctorID, String appointmentDate, Connection connection){
	      String query="SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date=?";
	      try {
	        PreparedStatement preparedStatement=connection.prepareStatement(query);
	        preparedStatement.setInt(1,doctorID);
	        preparedStatement.setString(2, appointmentDate);
	        ResultSet resultSet=preparedStatement.executeQuery();
	        if(resultSet.next()){
	            int count = resultSet.getInt(1);
	            if(count==0){
	                return true;
	            }else{
	                return false;
	            }
	        }
	      } catch (Exception e) {
	        
	        e.printStackTrace();
	      } 
	      return false;
	  }
	}
