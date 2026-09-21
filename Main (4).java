import java.util.Scanner;

public class Main {

    static void display(int[] marks) {
        System.out.println("\nMarks:");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }
    }

    static int total(int[] marks) {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum;
    }

    static double average(int[] marks) {
        return (double) total(marks) / marks.length;
    }

    static int search(int[] marks, int target) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] marks = {78, 85, 92, 66, 88};

        while (true) {

            System.out.println("\n===== STUDENT MARKS SYSTEM =====");
            System.out.println("1. Display Marks");
            System.out.println("2. Total and Average");
            System.out.println("3. Search Mark");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {

                display(marks);

            } else if (choice == 2) {

                System.out.println("Total = " + total(marks));
                System.out.println("Average = " + average(marks));

            } else if (choice == 3) {

                System.out.print("Enter mark to search: ");
                int target = sc.nextInt();

                int index = search(marks, target);

                if (index == -1) {
                    System.out.println("Mark not found.");
                } else {
                    System.out.println(
                        "Mark found at index " + index
                    );
                }

            } else if (choice == 4) {

                System.out.println("Program ended.");
                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
