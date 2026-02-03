import java.util.Scanner;
class GradeCalculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter total subjects");
        int subjects = sc.nextInt();
        int totalMarks = 0;
        for(int i = 1; i <= subjects; i++) {
            System.out.println("enter marks of subject " + i);
            int marks = sc.nextInt();
            if(marks < 0 || marks > 100) {
                System.out.println("invalid marks. Please enter marks between 1 to 100");
                i--;
                continue;
            }
           totalMarks += marks;
        }
        double averagePercentage = (double) totalMarks / subjects;
        char grade;
        if (averagePercentage >= 90)
            grade = 'A';
        else if (averagePercentage >= 75)
            grade = 'B';
        else if (averagePercentage >= 60)
            grade = 'C';
        else if (averagePercentage >= 45)
            grade = 'D';
        else 
            grade = 'F';
         System.out.println("Result");
          System.out.println("Total marks " + totalMarks);
           System.out.println("Average precentage " + averagePercentage);
           System.out.println("grade " + grade);
           sc.close();
    }
}