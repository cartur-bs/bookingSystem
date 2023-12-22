import dbProperties.DB;
import entities.Passenger;
import entities.PassengerDependant;

import java.sql.Connection;
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
        String sql = "INSERT INTO Teste(Nome, DN) VALUES (?,?)";
        PreparedStatement ps = null;

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateConvert = new SimpleDateFormat("dd-MM-yyyy");
        //starting the program
       try{ System.out.println("Hello, let's make your booking!");
        System.out.println("What's your name?");
        String name = sc.next();
        System.out.println("What's your birth date?");
        String bDate = sc.next();
        dateConvert.parse(bDate);
        System.out.println("What's your cpf?");
        String CPF = sc.next();
        System.out.println("What's your email?");
        String email = sc.next();
        System.out.println("What's your destination?");
        String destination = sc.next();
       // System.out.println(name + bDate + CPF + destination);
        System.out.println("Would you like to add a dependant?(Y/N)");
        char isThereDependant = sc.next().charAt(0);

        if(isThereDependant == 'N'|| isThereDependant == 'n'){
            Passenger passenger = new Passenger(name, bDate, CPF, email, destination);
            System.out.println("Your booking is complete!");
            try{
                ps = DB.getConnection().prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, bDate);
                ps.executeUpdate();

                DB.closeConnection();
                ps.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(isThereDependant == 'Y' || isThereDependant == 'y'){
            System.out.println("Let's add your dependant information!");
            System.out.println("What's your dependant name?");
            String depName = sc.next();
            System.out.println("What's your dependant birth date?");
            String depBdate = sc.next();
            dateConvert.parse(depBdate);
            System.out.println("What's your dependant cpf?");
            String depCpf = sc.next();
            PassengerDependant newDependant = new PassengerDependant( depName, depBdate,  depCpf,  destination,  name,  CPF,  bDate);
            System.out.println("Your booking and your dependant's are complete!");
            System.out.println(newDependant.toString());
        }}
       catch(InputMismatchException e){
           e.printStackTrace();
           System.out.println("Insert a valid value");
       } catch (ParseException e) {
           throw new RuntimeException(e);
       } finally {
           sc.close();
       }

    }
}