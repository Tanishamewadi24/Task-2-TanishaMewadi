import java.util.Scanner;

public class StudentGradeCalculator {

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT GRADE CALCULATOR =====");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int i = 1; i <= subjects; i++) {

            int marks;

            do {
                System.out.print("Enter Marks for Subject " + i + " (0-100): ");
                marks = sc.nextInt();
            } while (marks < 0 || marks > 100);

            totalMarks += marks;

            highest = Math.max(highest, marks);
            lowest = Math.min(lowest, marks);
        }

        double percentage = (double) totalMarks / subjects;

        String grade = calculateGrade(percentage);

        System.out.println("\n===== RESULT =====");
        System.out.println("Student Name : " + name);
        System.out.println("Total Marks  : " + totalMarks);
        System.out.println("Percentage   : " + percentage + "%");
        System.out.println("Grade        : " + grade);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks : " + lowest);

        if (percentage >= 40)
            System.out.println("Status       : PASS");
        else
            System.out.println("Status       : FAIL");

        sc.close();
    }
}