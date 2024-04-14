package miniprojet;

public class Student implements Comparable<Student>{
	
	int StudentId;
	String FirstName;
	String LastName;
	String Department;
	int Contactno;
	String Email;
	String City;
	String State;
	String Country;
	int ZIP;
	int Marks;
	
	Student(int StudentId,String FirstName,String LastName,String Department,int Contactno,String Email,String City,String State,String Country,int ZIP,int Marks) {
		
		this.StudentId=StudentId;
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.Department=Department;
		this.Contactno=Contactno;
		this.Email=Email;
		this.City=City;
		this.State=State;
		this.Country=Country;
		this.ZIP=ZIP;
		this.Marks=Marks;
		
	}
	


	@Override
	public int compareTo(Student obj) {
		return this.FirstName.compareTo(obj.FirstName) ;	
	}

	

	
}
