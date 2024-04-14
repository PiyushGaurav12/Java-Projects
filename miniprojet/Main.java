package miniprojet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Student> student = new ArrayList<>();

		System.out.println("Hello SIR\nWelcome to Student databse\n Please fill the following details before using the database.....");
		System.out.println("Enter no. of Students:");
		int n = sc.nextInt();
		int i=0;
		int j=1;
		Set<Integer> set = new HashSet<Integer>();
		for(i=0,j=1;i<n;i++,j++) {
		System.out.println("Enter student details for student "+j);
		System.out.println("Enter StudentId:");
		int StudentId=sc.nextInt();
		if(!set.add(StudentId)) {
			System.out.println("Cannot input same id");	
			System.out.println("Enter StudentId:");
			StudentId=sc.nextInt();
		}	
		System.out.println("Enter Student FirsName:");
		String FirstName=read.readLine();
		System.out.println("Enter Student LastName:");
		String LastName=read.readLine();
		System.out.println("Enter Student Department:");
		String Department=read.readLine();
		System.out.println("Enter Student Contact no.:");
		int Contactno=sc.nextInt();
		System.out.println("Enter Student Email:");
		String Email=read.readLine();
		System.out.println("Enter Student City:");
		String City=read.readLine();
		System.out.println("Enter Student State:");
		String State=read.readLine();
		System.out.println("Enter Student Country:");
		String Country=read.readLine();
		System.out.println("Enter Student ZIP:");
		int ZIP=sc.nextInt();
		System.out.println("Enter Student Marks:");
		int Marks=sc.nextInt();
		student.add(new Student(StudentId,FirstName,LastName,Department,Contactno,Email,City,State,Country,ZIP,Marks));
		}
		Collections.sort(student);
		
		int ch=1;
		while(ch==1) {
		System.out.println("\n1-Insert data\n2-Sort and Display the table\n3-Student with second highest marks\n4-Update a student's Email\n5-Delete a student details\n6-Exit");
		System.out.println("\nEnter your choice:");
		int choice = sc.nextInt();
		switch(choice) {
						
		case 1:
			Insert.insert(student);
			break;
		
		case 2:
			DisplaySorted.displaySorted();
			break;
			
		case 3:
			
			HighestMarks.highestMarks();
			
		case 4:
			
			 Update.update();
			break;
			
		case 5:
			
			Delete.delete();
			break;
		case 6:
			return;
		}
		
		}
	}
}


