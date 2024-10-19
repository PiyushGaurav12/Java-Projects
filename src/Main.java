import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentDAO studentDAO = new StudentDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewAllStudents();
                    case 3 -> updateStudent();
                    case 4 -> deleteStudent();
                    case 5 -> {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void addStudent() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        Student student = new Student(0, name, age, email, course);
        studentDAO.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() throws SQLException {
        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        // Header row
        System.out.printf("+----+--------------------+-----+------------------------+--------------------+%n");
        System.out.printf("| ID | Name               | Age | Email                  | Course             |%n");
        System.out.printf("+----+--------------------+-----+------------------------+--------------------+%n");

        // Data rows
        for (Student student : students) {
            System.out.printf("| %-2d | %-18s | %-3d | %-22s | %-18s |%n",
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getEmail(),
                    student.getCourse());
        }

        // Footer row
        System.out.printf("+----+--------------------+-----+------------------------+--------------------+%n");
    }


    private static void updateStudent() throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        studentDAO.updateStudent(student);
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        studentDAO.deleteStudent(id);
        System.out.println("Student deleted successfully!");
    }
}
