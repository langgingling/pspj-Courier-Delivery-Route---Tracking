import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter department: ");
        String dept = sc.nextLine();

        name = name.trim();
        dept = dept.trim();

        if (name.isBlank() || dept.isBlank()) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Student Name: " + name);
            System.out.println("Department: " + dept);

            if (dept.equalsIgnoreCase("CSE")) {
                System.out.println("Department is CSE");
            } else {
                System.out.println("Other Department");
            }
        }

        sc.close();
    }
}