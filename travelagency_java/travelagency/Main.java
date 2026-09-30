package travelagency;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("         TRAVEL AGENCY SIMULATOR - Java Implementation      ");
        System.out.println("============================================================");

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();

            System.out.print("Enter customer age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Does customer have a passport? (true/false): ");
            boolean hasPassport = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Enter quotation price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println();
            System.out.println("Select eligibility strategy:");
            System.out.println("  1 - AgeStrategy");
            System.out.println("  2 - PassportStrategy");
            System.out.print("Enter choice (1 or 2): ");
            int strategyChoice = Integer.parseInt(scanner.nextLine());

            System.out.println();

            Customer customer = new Customer(name, age, hasPassport);
            Quotation quotation = new Quotation(price);
            Booking booking = quotation.accept();

            if (strategyChoice == 1) {
                booking.setStrategy(new AgeStrategy());
            } else {
                booking.setStrategy(new PassportStrategy());
            }

            booking.addObserver(new LogObserver());
            booking.addObserver(new EmailObserver());

            boolean isEligible = booking.verifyEligibility(customer);

            System.out.println();

            if (isEligible) {
                booking.confirm();
            } else {
                System.out.println("[BOOKING] Customer not eligible. Booking was NOT confirmed.");
            }

            System.out.println();
            System.out.print("Run another booking? (y/n): ");
            String again = scanner.nextLine();

            if (!again.trim().equalsIgnoreCase("y")) {
                running = false;
            }
        }

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                     SIMULATION COMPLETE                   ");
        System.out.println("============================================================");

        scanner.close();
    }
}
