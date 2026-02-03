import java.util.*;
import java.io.*;
class Student implements Serializable
{
    private String name;
    private int rollNumber;
    private String grade;
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setName( String name) {
        this.name = name;
    }
    public void setGrade( String grade)
    {
        this.grade = grade;

    }
    @Override
    public String toString() {
        return " Roll No " + rollNumber + "NAME " + name + "GRADE " + grade;
    }
}
class StudentManager {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.dat";
    public StudentManager () {
        loadFromFile();
    }
    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
        System.out.println("Student added succesfully");
    }
    public void removeStudent(int roll) {
        boolean removed = students.removeIf( s-> s.getRollNumber() == roll);
        if(removed) {
            saveToFile();
            System.out.println("Student removed");
        }
        else {
            System.out.println("Student not found");
        }
    }
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found ");
        }
        else{
            for(Student s : students)
            {
                System.out.println(s);
            }
        }
    }
    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        }
        catch (IOException e) {
            System.out.println("Error saving data");
            
        }
    }
    public Student searchStudent(int roll) {
    for (Student s : students) {
        if (s.getRollNumber() == roll) {
            return s;
        }
    }
    return null;
}

    private void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>)in.readObject();
        }
        catch(Exception e) {
            students = new ArrayList<>();
        }
    }
}
public class StudentManagementSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;
        do {
            System.out.println("\n     Student Management System     ");
            System.out.println("1. Add Student");
            System.out.println("2. Remove student");
            System.out.println("3. Search Student");
            System.out.println("4. Display all students ");
            System.out.println("5. exit");
            System.out.println(" Enter your choice");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("name cannot be empty");
                        break;
                    }
                    System.out.println("ENTER ROLL NUMBER");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter grade");
                    String grade = sc.nextLine();
                    manager.addStudent(new Student(name, roll, grade));
                    break;
                    case 2:
                        System.out.println("enter roll no to remove");
                        manager.removeStudent(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("enter roll no to search");
                        Student s = manager.searchStudent(sc.nextInt());
                        if (s != null)
                            System.out.println(s);
                        else 
                            System.out.println("Student not found");
                        break;
                    case 4:
                            manager.displayAllStudents();
                            break;
                    case 5:
                            System.out.println("Exiting application");
                            break;
                            default:
                                System.out.println("INVALID CHOICE");
            }
        }
        while (choice != 5);
        sc.close();
    }
}