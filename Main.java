 import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Courier ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Source: ");
            String source = sc.nextLine();

            System.out.print("Enter Destination: ");
            String destination = sc.nextLine();

            double distance = readPositiveDouble(sc, "Enter Distance (km): ");
            double speed = readPositiveDouble(sc, "Enter Average Speed (km/h): ");

            double time = distance / speed;

            System.out.println("\n--- Courier Tracking ---");
            System.out.println("Courier ID: " + id);
            System.out.println("Route: " + source + " -> " + destination);
            System.out.printf("Distance: %.2f km%n", distance);
            System.out.printf("Estimated Time: %.2f hours%n", time);
        }
    }

    private static double readPositiveDouble(Scanner sc, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = sc.nextDouble();
                sc.nextLine(); // consume leftover newline
                if (value > 0) break;
                System.out.println("Please enter a value greater than 0.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid number, please try again.");
                sc.nextLine(); // clear bad input
            }
        }
        return value;
    }
} 
