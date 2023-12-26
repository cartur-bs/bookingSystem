import dbProperties.DB;
import entities.Passenger;
import entities.PassengerDependant;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to make a booking or consult an existent one?");
        String action = sc.nextLine().toLowerCase();
        Passenger passenger = new Passenger();

        if(action.equals("make") ){
            try {
                System.out.println("Hello, let's make your booking!");
                System.out.println("What's your name?");
                String name = sc.nextLine();
                System.out.println("What's your birth date?(dd-MM-yyyy)");
                String bDate = sc.next();
                System.out.println("What's your cpf?");
                String CPF = sc.next();
                System.out.println("What's your email?");
                String email = sc.next();
                System.out.println("What's your destination?");
                String destination = sc.next();
                System.out.println("Would you like to add a dependant?(Y/N)");
                char isThereDependant = sc.next().toLowerCase().charAt(0);

                if ( isThereDependant == 'n') {
                    passenger = new Passenger(name,bDate, CPF, email, destination, isThereDependant);
                    try {
                        passenger.createPerson();
                        System.out.println("Your booking is complete!");
                    } catch (SQLException e) {
                        throw new SQLException(e);
                    }
                }

                if ( isThereDependant == 'y') {
                    System.out.println("Let's add your dependant information!");
                    System.out.println("What's your dependant name?");
                    String depName = sc.next();
                    sc.nextLine();
                    System.out.println("What's your dependant birth date?");
                    String depBdate = sc.next();
                    System.out.println("What's your dependant cpf?");
                    String depCpf = sc.next();
                    passenger = new Passenger(name,bDate, CPF, email, destination, isThereDependant);
                    PassengerDependant newDependant = new PassengerDependant(depName, depBdate, depCpf, name,email, CPF, bDate);
                    try {
                        passenger.createPerson();
                        newDependant.createDependant();
                        System.out.println("Your booking and your dependant's are complete!");
                    } catch (SQLException e) {
                        System.out.println("An error occurred, please try again.");
                        throw new SQLException(e);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Insert a valid value");
                throw new InputMismatchException();
            }
        }
        if(action.equals("consult")){
            System.out.println("Let's consult your reservation, what's your CPF?");
            String cpfToConsult = sc.nextLine();
            try{
                passenger.consultPerson(cpfToConsult);


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }catch(NullPointerException e){
                throw new NullPointerException();
            }
        }
        sc.close();
        DB.closeConnection();
    }
}