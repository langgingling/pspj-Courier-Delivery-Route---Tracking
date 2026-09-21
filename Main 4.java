import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final double PETROL_FACTOR = 0.192;
    private static final double DIESEL_FACTOR = 0.171;
    private static final double BUS_FACTOR = 0.105;
    private static final double TRAIN_FACTOR = 0.041;

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Trip Name: ");
            String trip = sc.nextLine();

            System.out.println("\nSelect mode of transport:");
            System.out.println("1. Car (Petrol)");
            System.out.println("2. Car (Diesel)");
            System.out.println("3. Bus");
            System.out.println("4. Train");

            int choice = readChoice(sc, "Enter choice (1-4): ", 1, 4);
            double distance = readPositiveDouble(sc, "Enter Distance (km): ");

            String mode;
            double factor;

            switch (choice) {
                case 1:
                    mode = "Car (Petrol)";
                    factor = PETROL_FACTOR;
                    break;

                case 2:
                    mode = "Car (Diesel)";
                    factor = DIESEL_FACTOR;
                    break;

                case 3:
                    mode = "Bus";
                    factor = BUS_FACTOR;
                    break;

                default:
                    mode = "Train";
                    factor = TRAIN_FACTOR;
                    break;
            }

            double emissions = distance * factor;
            double trees = emissions / 21.0;

            System.out.println("\n--- CO2 Emission Report ---");
            System.out.println("Trip: " + trip);
            System.out.println("Mode: " + mode);
            System.out.printf("Distance: %.2f km%n", distance);
            System.out.printf("CO2 Emitted: %.2f kg%n", emissions);
            System.out.printf(
                "Trees needed to offset (1 year): %.2f%n",
                trees
            );
        }
    }

    private static double readPositiveDouble(
            Scanner sc, String prompt) {

        while (true) {
            System.out.print(prompt);

            try {
                double value = sc.nextDouble();
                sc.nextLine();

                if (value > 0) {
                    return value;
                }

                System.out.println(
                    "Value must be greater than 0."
                );

            } catch (InputMismatchException e) {
                System.out.println(
                    "Please enter a valid number."
                );
                sc.nextLine();
            }
        }
    }

    private static int readChoice(
            Scanner sc, String prompt, int min, int max) {

        while (true) {
            System.out.print(prompt);

            try {
                int value = sc.nextInt();
                sc.nextLine();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                    "Choice must be between "
                    + min + " and " + max + "."
                );

            } catch (InputMismatchException e) {
                System.out.println(
                    "Please enter a number."
                );
                sc.nextLine();
            }
        }
    }
}