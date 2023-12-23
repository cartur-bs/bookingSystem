package entities;

import dbProperties.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Passenger {
    String name;
    String birthDate;
    String cpf;
    String email;
    String destination;
    char isThereDependant;
    PreparedStatement ps = null;


    //creating a new object without dependant
    public Passenger(String name, String birthDate, String cpf,String email, String destination, char isThereDependant) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.destination = destination;
        this.email = email;
        this.isThereDependant=isThereDependant;
    }

    //sending the data to database
     public void createPerson() throws SQLException{
         String passengerStatement = "INSERT INTO passengerWithNoDependant(name, bDate, CPF , email, destination, dependant ) VALUES (?,?,?,?,?,?)";
         ps = DB.getConnection().prepareStatement(passengerStatement);
         ps.setString(1, name);
         ps.setString(2,  birthDate);
         ps.setString(3, cpf);
         ps.setString(4, email);
         ps.setString(5,destination);
         ps.setString(6, String.valueOf(isThereDependant));
         ps.executeUpdate();
         ps.close();
     }

    //consulting data from database
    public void consultPerson() throws SQLException{
        System.out.println("creating person");
    }

}
