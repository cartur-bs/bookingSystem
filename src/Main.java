import dbProperties.DB;
import entities.Passenger;
import entities.PassengerDependant;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateHourFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to make(m) a booking or consult(c) an existent one?");
            String action = sc.nextLine().toLowerCase();
            Passenger passenger = new Passenger();

            if (action.equals("m")) {
                try {
                    System.out.println("Hello, let's make your booking!");
                    System.out.println("What's your name?");
                    String name = sc.nextLine();
                    System.out.println("What's your birth date?(dd/MM/yyyy)");
                    String bDate = sc.nextLine();
                    LocalDate bDateFormated = LocalDate.parse(bDate, dateFormat);
                    System.out.println("What's your cpf?");
                    String CPF = sc.next();
                    System.out.println("What's your email?");
                    String email = sc.next();
                    System.out.println("What's your destination?");
                    String destination = sc.next();
                    sc.nextLine();
                    System.out.println("Insert the date and time of your departure(dd/MM/yyyy HH:mm):");
                    String departureDate = sc.nextLine();
                    LocalDateTime departureDateFormated = LocalDateTime.parse(departureDate, dateHourFormat);

                    if (departureDateFormated.isBefore(LocalDateTime.now())) {
                        System.out.println("Please, insert a valid date, beginning from today");
                        return;
                    }
                        System.out.println("Would you like to add a dependant?(Y/N)");
                    char isThereDependant = sc.next().toUpperCase().charAt(0);

                    if (isThereDependant == 'N') {
                        passenger = new Passenger(name, bDateFormated, CPF, email, destination, departureDateFormated, isThereDependant);
                        try {
                            passenger.createPerson();
                            System.out.println("Your booking is complete!");
                        } catch (SQLException e) {
                            System.out.println("An error occurred during your booking, please try again.");
                            throw new SQLException(e);
                        }
                    } else if (isThereDependant == 'Y') {
                        System.out.println("Let's add your dependant information!");
                        System.out.println("What's your dependant name?");
                        String depName = sc.next();
                        sc.nextLine();
                        System.out.println("What's your dependant birth date?");
                        String depBdate = sc.next();
                        LocalDate depBDateFormated = LocalDate.parse(depBdate, dateFormat);
                        System.out.println("What's your dependant cpf?");
                        String depCpf = sc.next();
                        passenger = new Passenger(name, bDateFormated, CPF, email, destination, departureDateFormated, isThereDependant);
                        PassengerDependant newDependant = new PassengerDependant(depName, depBDateFormated, depCpf, departureDateFormated, name, email, CPF, bDate);
                        try {
                            passenger.createPerson();
                            newDependant.createDependant();
                            System.out.println("Your booking and your dependant's are complete!");
                        } catch (SQLException e) {
                            System.out.println("An error occurred during your booking, please try again.");
                            throw new SQLException(e);
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Insert a valid value");
                    throw new InputMismatchException();
                }
            } else if (action.equals("c")) {
                System.out.println("Let's consult your reservation, what's your CPF?");
                String cpfToConsult = sc.nextLine();
                try {
                    passenger.consultPerson(cpfToConsult);
                } catch (NullPointerException e) {
                    System.out.println("An error occurred during your booking, please try again.");
                    throw new NullPointerException();
                }
            } else System.out.println("Invalid value, please insert 'make' or 'consult'!");
            sc.close();
            DB.closeConnection();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}