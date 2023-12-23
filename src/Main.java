import dbProperties.DB;
import entities.Passenger;
import entities.PassengerDependant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        //methods to connect with the database
        Connection con = DB.getConnection();
      //  String passangerStatement = "INSERT INTO passangerWithNoDependant(name, bDate, CPF , email, destination, dependant ) VALUES (?,?,?,?,?,?)";
//        String dependantStatement = "INSERT INTO passangerDependant(depName, depBDate, depCPF,responsibleName, responsibleEmail,responsibleCPF, responsibleBDate) VALUES(?,?,?,?,?,?,?)";
       // PreparedStatement ps = null;

        //starting the executable program
       try (Scanner sc = new Scanner(System.in)) {
            SimpleDateFormat dateConvert = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Hello, let's make your booking!");
            System.out.println("What's your name?");
            String name = sc.nextLine();
            System.out.println("What's your birth date?(dd-MM-yyyy)");
            String bDate = sc.next();
           // dateConvert.parse(bDate);
            System.out.println("What's your cpf?");
            String CPF = sc.next();
            System.out.println("What's your email?");
            String email = sc.next();
            System.out.println("What's your destination?");
            String destination = sc.next();
            System.out.println("Would you like to add a dependant?(Y/N)");
            char isThereDependant = sc.next().charAt(0);

            if (isThereDependant == 'N' || isThereDependant == 'n') {
                Passenger passenger = new Passenger(name,bDate, CPF, email, destination, isThereDependant);
                try {
                    passenger.createPerson();
                    System.out.println("Your booking is complete!");
                } catch (SQLException e) {
                    throw new SQLException(e);
                }
            }

            if (isThereDependant == 'Y' || isThereDependant == 'y') {
                System.out.println("Let's add your dependant information!");
                System.out.println("What's your dependant name?");
                String depName = sc.next();
                sc.nextLine();
                System.out.println("What's your dependant birth date?");
                String depBdate = sc.next();
                System.out.println("What's your dependant cpf?");
                String depCpf = sc.next();
                sc.close();
                Passenger passenger = new Passenger(name,bDate, CPF, email, destination, isThereDependant);
                PassengerDependant newDependant = new PassengerDependant(depName, depBdate, depCpf, name,email, CPF, bDate);
                try {
                    passenger.createPerson();
                   newDependant.createDependant();
                    System.out.println("Your booking and your dependant's are complete!");
                } catch (SQLException e) {
                    throw new SQLException(e);
                }


            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Insert a valid value");
        }

        DB.closeConnection();
    }
}